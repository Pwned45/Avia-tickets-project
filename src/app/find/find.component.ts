import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {ResultTicketDto} from "../model/resultTicketDto";
import {ParametrSerch} from "../model/parametrSerch";
import {TicketService} from "../service/ticket.service";
import {ListTicketDelay} from "../model/listTicketDelay";
import {Ticket} from "../model/ticket";
import {TokenStorageService} from "../service/token-storage.service";

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent implements OnInit {
  // file/:start/:end/:cst/:ced'
  idsList="";
  start: string;
  end: string;
  cst: string;
  ced: string;
  err: string;
  p = 0;
  price = 0;
  delayd = 0;
  paramOne: ParametrSerch;
  paranTwo: ParametrSerch;
  toRes: ResultTicketDto;
  fromRes: ResultTicketDto;
  res: ListTicketDelay[];
  tickres: Ticket[];
  isLogin=false;

  constructor(private route: ActivatedRoute, private ticketSev: TicketService) {
    this.paramOne = new ParametrSerch();
    this.paranTwo = new ParametrSerch();
    this.fromRes=new ResultTicketDto();
    this.toRes=new ResultTicketDto();
    //this.res = new ResultTicketDto();
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.start = params.start;
      this.end = params.end;
      this.cst = params.cst;
      this.ced = params.ced;
      this.paramOne.cityStart = this.cst;
      this.paramOne.cityEnd = this.ced;
      this.paramOne.dateS = this.start;

      this.paranTwo.cityStart = this.ced;
      this.paranTwo.cityEnd = this.cst;
      this.paranTwo.dateS = this.end;

      if (this.end == "0") {
       this.getTicketone(this.paramOne);

      } else {
      this.getTicketTwo(this.paranTwo);
        this.getTicketone(this.paramOne);
      }
    });
  }

  getTicketone(par: ParametrSerch) {
    console.log(par)
    this.ticketSev.getTicketsS(par).subscribe(data => {
      this.toRes = data;
      console.log(data)
    }, error => {
      this.err = error.message;
    });
    if (this.toRes.result) {
    //  return this.toRes;
    } else {
      this.err = "Билетов не найдено";
   //   return this.toRes;
    }
  }

  getTicketTwo(par: ParametrSerch) {
    debugger
    console.log(par)
    this.ticketSev.getTicketsS(par).subscribe(data => {
      this.fromRes = data;
      console.log(par)
      console.log(data)
    }, error => {
      this.err = error.message;
    });
    if (this.fromRes.result) {
    //  return this.fromRes;
    } else {
     this.err = "Билетов не найдено";
   //   return this.fromRes;
    }
  }

  doFilterbyDelayDur() {

    if (this.fromRes) {
      this.res = this.fromRes.result.sort((a, b) => (this.getDayBydelay(a.delay[0], a.delay[a.delay.length - 1]) < this.getDayBydelay(b.delay[0], b.delay[b.delay.length - 1])) ? 1 : -1)
      this.fromRes.result = this.res;
    }
    if (this.toRes) {
      this.res = this.toRes.result.sort((a, b) => (this.getDayBydelay(a.delay[0], a.delay[a.delay.length - 1]) < this.getDayBydelay(b.delay[0], b.delay[b.delay.length - 1])) ? 1 : -1)
      this.toRes.result = this.res;
    }
  }

  doFilterbyDelay() {

    if (this.fromRes) {
      this.res = this.fromRes.result.sort((a, b) => (a.countOfDelay > b.countOfDelay) ? 1 : -1)
      this.fromRes.result = this.res;
    }
    if (this.toRes) {
      this.res = this.toRes.result.sort((a, b) => (a.countOfDelay > b.countOfDelay) ? 1 : -1)
      this.toRes.result = this.res;
    }
  }

  doFilterbyPrice() {

    if (this.fromRes) {
      this.res = this.fromRes.result.sort((a, b) => (a.countOfDelay > b.countOfDelay) ? 1 : -1)
      this.fromRes.result = this.res;
    }
    if (this.toRes) {
      this.res = this.toRes.result.sort((a, b) => (this.getPrice(a.ticketDtoList) > this.getPrice(b.ticketDtoList)) ? 1 : -1)
      this.toRes.result = this.res;
    }
  }

  doFilterDate() {

    if (this.fromRes) {
      this.res = this.fromRes.result.sort((a, b) => (this.getDateBol(a.ticketDtoList[0].startDate, b.ticketDtoList[0].startDate)) ? 1 : -1)
      this.fromRes.result = this.res;
    }
    if (this.toRes) {
      this.res = this.toRes.result.sort((a, b) => (this.getDateBol(a.ticketDtoList[0].startDate, b.ticketDtoList[0].startDate)) ? 1 : -1)
      this.toRes.result = this.res;
    }

  }

  parseTime(s: string, e: string): string {
    let sarr = s.split(":");
    let earr = e.split(":");
    if (s === e) {
      return sarr[0] + " дней: " + sarr[1] + " часов: " + sarr[2] + " минут";
    } else {
      let ded = +earr[0];
      let dst = +sarr[0];
      let d = ded - dst;

      let hed = +earr[1];
      let hst = +sarr[1];
      let h = hed - hst;

      let med = +earr[2];
      let mest = +sarr[2];
      let m = med - mest;
      return d + " дней: " + h + " часов: " + m + " минут";
    }
  }

  getPrice(node: Ticket[]): number {
    for (let i = 0; i < node.length; i++) {
      this.p += Number(node[i].price);
    }
    this.price = this.p;
    this.p = 0;
    return this.price;
  }

  getDayBydelay(s: string, e: string): number {
    if(s) {
      let sarr = s.split(":");
      let earr = e.split(":");
      let ded = +earr[0];
      let dst = +sarr[0];
      let hed = +earr[1];
      let hst = +sarr[1];
      let med = +earr[2];
      let mest = +sarr[2];
      if (s === e) {
        return this.delayd = dst + hst/24 + mest/60;
      } else {
        let d = ded - dst;
        let h = (hed -hst) / 24;
        let m = (med - mest) / 60;
        return this.delayd = d + h + m;
      }
    }else {
      return 0;
    }

  }

  getDateBol(s: Date, s1: Date): boolean {
    return new Date(s) > new Date(s1)
  }
  getIds(list:Ticket[]):string{
    this.idsList="";
    for (let i = 0; i < list.length; i++) {
      if(i+1==list.length){
        this.idsList+=list[i].idTicket
      }else {
        this.idsList+=list[i].idTicket+",";
      }
    }
    console.log( this.idsList)
    return this.idsList;
  }
}
