import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../service/token-storage.service";
import {ConditionalService} from "../service/conditional.service";
import {TicketService} from "../service/ticket.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Choice} from "../model/choice";
import {User} from "../model/user";
import {Conditionals} from "../model/conditionals";

@Component({
  selector: 'app-brasket',
  templateUrl: './brasket.component.html',
  styleUrls: ['./brasket.component.css']
})
export class BrasketComponent implements OnInit {
  choise: Choice;
  condits: Conditionals[];
  ids: string;
  price: string;
  isLogin = false;
  user: User;
  arrB: number[] = [];
  mess=""

  constructor(private route: ActivatedRoute, private tokenStorage: TokenStorageService, private conidSev: ConditionalService, private ticketSev: TicketService) {
    this.choise = new Choice();
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.ids = params.ids;
      this.price = params.price
      this.getAllCondit()
      this.getIds()
      if (this.tokenStorage.getToken()) {
        this.isLogin = true;
        this.user = this.tokenStorage.getUser();

      }
    });
  }

  onSubmit() {
    this.choise.idTickets=this.getIds();
    this.choise.userDtoId=this.user.id;
    this.choise.info=new Date().toDateString()
    this.ticketSev.buy(this.choise).subscribe(data=>{
      this.mess=data.mess
    },error => {
      this.mess=error
      console.log(error)
    })
  }

  getAllCondit() {
    this.conidSev.getAllConditionals().subscribe(data => {
      this.condits = data
      console.log(data)
    })
  }

  getIds(): number[] {
    let arr = this.ids.split(",");
    for (let i = 0; i < arr.length; i++) {
      this.arrB.push(+arr[i]);
    }
    return this.arrB;
  }

}
