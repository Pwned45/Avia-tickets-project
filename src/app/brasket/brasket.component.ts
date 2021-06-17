import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../service/token-storage.service";
import {ConditionalService} from "../service/conditional.service";
import {TicketService} from "../service/ticket.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Choice} from "../model/choice";
import {User} from "../model/user";
import {Conditionals} from "../model/conditionals";
import {Card} from "../model/Card";
import {Ticket} from "../model/ticket";

@Component({
  selector: 'app-brasket',
  templateUrl: './brasket.component.html',
  styleUrls: ['./brasket.component.css']
})
export class BrasketComponent implements OnInit {
  choise: Choice;
  priceres:bigint;
  card: Card;
  ticketsArr: Ticket[] = [];
  condits: Conditionals[];
  ids: string;
  price: string;
  isLogin = false;
  user: User;
  arrB: number[] = [];
  arrCon: bigint[] = [];
  mess = ""

  constructor(private route: ActivatedRoute, private tokenStorage: TokenStorageService, private conidSev: ConditionalService, private ticketSev: TicketService) {
    this.choise = new Choice();
    this.user = new User();
    this.card = new Card();
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.ids = params.ids;
      this.price = params.price
      this.getIds();
      this.getAllCondit();
      this.getAllTickets();
      if (this.tokenStorage.getToken()) {
        this.isLogin = true;
        this.user = this.tokenStorage.getUser();

      }
    });
  }

  onclickCon(id: bigint) {

    this.arrCon.push(id);
    this.condits = this.condits.filter(obj => obj.idAdc != id);
  }

  getAllTickets() {
    for (let i = 0; i < this.arrB.length; i++) {
      this.ticketSev.getById(this.arrB[i]).subscribe(data => {
        this.ticketsArr.push(data)
      });
    }
    console.log(this.ticketsArr)
  }

  onSubmit() {

    this.choise.idTickets = this.arrB;
    if(this.arrB.length>0){
      this.choise.conditionals = this.arrCon;
      this.choise.userDtoId = this.user.id;
      this.choise.info = new Date().toDateString();
      this.choise.card_number = ""
      this.choise.card_number += this.card.card + " ";
      this.choise.card_number += this.card.owner + " ";
      this.choise.card_number += this.card.ccv + " ";
      this.choise.card_number += this.card.dayM + "/";
      this.choise.card_number += this.card.dayE;
      this.ticketSev.buy(this.choise).subscribe(data => {
        location.href = '/profile';
        this.mess = data.mess

      }, error => {
        this.mess = error
        console.log(error)
      })
      console.log(this.choise)
    }else {
      alert("Вы удалили все билеты, покупка не возможна")
    }


  }

  setTicket(id) {
    this.ticketsArr = this.ticketsArr.filter(obj => obj.idTicket != id);
    this.arrB = this.arrB.filter(obj => obj != id)
  }


  getAllCondit() {
    this.conidSev.getAllConditionals().subscribe(data => {
      this.condits = data
      console.log(data)
    })
  }

  getIds(): number[] {
    this.arrB = []
    let arr = this.ids.split(",");
    for (let i = 0; i < arr.length; i++) {
      this.arrB.push(+arr[i]);
    }
    return this.arrB;
  }
//   setPrice():bigint{
// debugger
//     for (let i = 0; i < this.condits.length; i++) {
//       if(!this.priceres){
//         this.priceres=this.condits[i].price;
//       }else{
//         this.priceres+=this.condits[i].price;
//       }
//     }
//
//     for (let i = 0; i < this.ticketsArr.length; i++) {
//       if(!this.priceres){
//         this.priceres=this.ticketsArr[i].price;
//       }else{
//         this.priceres+=this.ticketsArr[i].price;
//       }
//     }
//     return this.priceres;
//   }
}
