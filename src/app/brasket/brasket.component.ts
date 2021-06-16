import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../service/token-storage.service";
import {ConditionalService} from "../service/conditional.service";
import {TicketService} from "../service/ticket.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Choice} from "../model/choice";
import {User} from "../model/user";
import {Conditionals} from "../model/conditionals";
import {Card} from "../model/Card";

@Component({
  selector: 'app-brasket',
  templateUrl: './brasket.component.html',
  styleUrls: ['./brasket.component.css']
})
export class BrasketComponent implements OnInit {
  choise: Choice;
  card: Card;
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
      this.getAllCondit()
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

  onSubmit() {
    debugger
    this.choise.conditionals = this.arrCon;
    this.choise.idTickets = this.getIds();
    this.choise.userDtoId = this.user.id;
    this.choise.info = new Date().toDateString();
    this.choise.card_number=""
    this.choise.card_number += this.card.owner + " ";
    this.choise.card_number += this.card.ccv + " ";
    console.log(this.choise)
    // this.ticketSev.buy(this.choise).subscribe(data => {
    //   this.mess = data.mess
    // }, error => {
    //   this.mess = error
    //   console.log(error)
    // })
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

  //
  // onSubmit() {
  //
  // }
}
