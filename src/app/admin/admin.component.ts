import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../service/token-storage.service";
import {ClientsService} from "../service/user.service";
import {TicketService} from "../service/ticket.service";
import {LocationService} from "../service/location.service";
import {User} from "../model/user";
import {Client} from "../model/client";
import {Check} from "../model/check";
import {Ticket} from "../model/ticket";
import {Locat} from "../model/locat";
import {TicketDtoFront} from "../model/ticketDtoFront";
import {Way} from "../model/way";
import {WayService} from "../service/way.service";
import {moment} from "ngx-bootstrap/chronos/test/chain";
import {parse} from "@angular/compiler/src/render3/view/style_parser";
import {Seat} from "../model/seat";


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  err = '';
  noAdmin = "";
  loading = false;
  isLogin = false;
  ticketPach: Ticket;
  ticketF: TicketDtoFront;
  way: Way;
  seat: Seat;
  waies: Way[] = [];
  idTf: bigint;
  user: User;
  client: Client;
  clients: Client[];
  ticketsList: Ticket[] = [];
  uniqTicket: Ticket[] = [];
  flag = true;
  date: Date;

  constructor(private tokenStorage: TokenStorageService, private clientSev: ClientsService,
              private ticketService: TicketService, private locationServ: LocationService,
              private wayServ: WayService) {
    this.date = new Date();
    this.ticketPach = new Ticket();
    this.client = new Client();
    this.ticketF = new TicketDtoFront();
    this.way = new Way();
    this.seat = new Seat();
    this.ticketF.wayDto = this.way;
  }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLogin = true;
      console.log(this.isLogin)
      this.user = this.tokenStorage.getUser();
      if (this.user.role == "ADMIN") {
        this.getAllClient()
        this.getAllTickets();
        this.getAllWay();
      } else {

      }
    }
    if (!(this.err === '')) {
      this.flag = false;
    }
  }

  onSubmit() {
    this.ticketF.wayDto = this.way;
    this.ticketF.seatDto = this.seat;
    let t = this.ticketF.startDate.slice(11, this.ticketF.startDate.length)
    let ts = +t.slice(0, 2) - 3
    this.ticketF.startDate = this.ticketF.startDate.slice(0, 10)
    this.ticketF.startDate += " " + ts + t.slice(2)
console.log( this.ticketF.startDate)
    this.ticketF.seatDto.idSeat = this.ticketF.wayDto.idWay;
debugger
    let e = this.ticketF.endDate.slice(11, this.ticketF.endDate.length)
    let te = +e.slice(0, 2) - 3
    this.ticketF.endDate = this.ticketF.endDate.slice(0, 10)
    this.ticketF.endDate += " " + te + e.slice(2)
    // this.ticketF.endDate += " " + e
    console.log( this.ticketF.endDate)
    this.saveTicket()

  }

  getAllClient() {
    this.clientSev.getAllClient().subscribe(data => {
      this.clients = data
    }, error => {
      this.err = error.message
    })
  }

  deleteUser(id: bigint) {
    this.clientSev.deleteClient(id).subscribe(data => {
      window.location.reload()
    })
  }

  deleteTicket(id: bigint) {
    this.ticketService.deleteTicket(id).subscribe(data => {
      location.reload()
    })
  }

  saveTicket() {
    this.ticketService.saveTicket(this.ticketF).subscribe(data => {
      console.log(data)
      location.reload()
    }, error => {
      console.log(error)
    })
  }

  getAllWay() {
    this.wayServ.getAllAvalWay().subscribe(data => {
      this.waies = data
    })
  }

  getAllTickets() {
    this.ticketService.getAll().subscribe(data => {
      this.ticketsList = data.sort((a, b) => (a.idTicket > b.idTicket) ? 1 : -1);
      console.log(data)
    })
  }

  click(ticketUp: Ticket) {
    console.log(ticketUp)
  }
}
