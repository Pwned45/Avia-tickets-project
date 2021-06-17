import {Component, OnInit} from '@angular/core';
import {Client} from "../model/client";
import {TicketDtoFront} from "../model/ticketDtoFront";
import {TokenStorageService} from "../service/token-storage.service";
import {TicketService} from "../service/ticket.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Ticket} from "../model/ticket";

@Component({
  selector: 'app-ticket-update',
  templateUrl: './ticket-update.component.html',
  styleUrls: ['./ticket-update.component.css']
})
export class TicketUpdateComponent implements OnInit {
  ticketF: TicketDtoFront
  ticket: Ticket;
  ids: number;
  hour = 0;
  h = ""
  s = ""
  isLogin = false

  constructor(private tokenStorage: TokenStorageService, private ticketService: TicketService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
        this.ids = params.id;
        this.getTicket(this.ids)
        if (this.tokenStorage.getToken()) {
          this.isLogin = true;
        }
      }
    )
  }

  onSubmit() {

    let h = this.ticketF.startDate.slice(11, this.ticketF.startDate.length)
    let hour = +h.slice(0, 2) - 3;
    let s = this.ticketF.startDate.slice(0, 10)
    this.ticketF.startDate = s + " " + hour + h.slice(2)

    let he = this.ticketF.endDate.slice(11, this.ticketF.endDate.length)
    let houre = +he.slice(0, 2) - 3;
    let se = this.ticketF.endDate.slice(0, 10)
    this.ticketF.endDate = se + " " + houre + he.slice(2)

    console.log(this.ticketF.startDate)


    this.ticketService.patchTicket(this.ticketF).subscribe(data => {
      location.reload()
    })
  }

  getTicket(id: number) {
    this.ticketService.getByIdDto(id).subscribe(data => {
      this.ticketF = data;
      console.log(data)

    })
  }
}
