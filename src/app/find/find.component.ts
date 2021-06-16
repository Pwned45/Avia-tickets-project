import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {ResultTicketDto} from "../model/resultTicketDto";
import {ParametrSerch} from "../model/parametrSerch";
import {TicketService} from "../service/ticket.service";
import {ListTicketDelay} from "../model/listTicketDelay";

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent implements OnInit {
  // file/:start/:end/:cst/:ced'
  start: string;
  end: string;
  cst: string;
  ced: string;
  err: string;
  paramOne: ParametrSerch;
  paranTwo: ParametrSerch;
  toRes: ResultTicketDto;
  fromRes: ResultTicketDto;
  res: ListTicketDelay[];

  constructor(private route: ActivatedRoute, private ticketSev: TicketService) {
    this.paramOne = new ParametrSerch();
    this.paranTwo = new ParametrSerch();
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
        this.getTicketone(this.paramOne);
        this.getTicketTwo(this.paranTwo);
      }
    });
  }

  getTicketone(par: ParametrSerch): ResultTicketDto {
    console.log(par)
    this.ticketSev.getTicketsS(par).subscribe(data => {
      this.toRes = data;
      console.log(data)
    }, error => {
      this.err = error.message;
    });
    if (this.toRes.result) {
      return this.toRes;
    } else {
      this.err = "Билетов не найдено";
      return this.toRes;
    }
  }

  getTicketTwo(par: ParametrSerch): ResultTicketDto {
    console.log(par)
    this.ticketSev.getTicketsS(par).subscribe(data => {
      this.fromRes = data;
      console.log(data)
    }, error => {
      this.err = error.message;
    });
    if (this.fromRes.result) {
      return this.fromRes;
    } else {
      this.err = "Билетов не найдено";
      return this.fromRes;
    }
  }

  doFilterbyDelay() {
    if (this.fromRes) {
      this.res = this.fromRes.result.sort(x => x.countOfDelay).reverse()
      this.fromRes.result=this.res;
    }
    if (this.toRes) {
      this.res = this.toRes.result.sort(x => x.countOfDelay).reverse()
      this.toRes.result=this.res;
    }
  }
  doFilter

}
