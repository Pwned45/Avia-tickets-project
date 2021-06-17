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
  idTf: bigint;
  user: User;
  client: Client;
  clients: Client[];
  ticketsList: Ticket[] = [];
  uniqTicket: Ticket[] = [];
  flag = true;
  date: Date;

  constructor(private tokenStorage: TokenStorageService, private clientSev: ClientsService, private ticketService: TicketService, private locationServ: LocationService) {
    this.date = new Date();
    this.ticketPach = new Ticket();
    this.client = new Client();
    this.ticketF = new TicketDtoFront();
    this.way = new Way();
  }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLogin = true;
      this.user = this.tokenStorage.getUser();
      if (this.user.role == "ADMIN") {
        this.getAllClient()
        this.getAllTickets();
      } else {

      }
    }
    if (!(this.err === '')) {
      this.flag = false;
    }
  }

  onSubmit() {
    this.ticketF.wayDto = this.way;
    this.ticketF.wayDto.idWay = this.idTf;
    console.log(this.ticketF)
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

  pachTicket(id: bigint) {
    this.ticketService.patchTicket(this.ticketPach).subscribe()
  }

  deleteTicket(id: bigint) {
    this.ticketService.deleteTicket(id).subscribe()
  }

  saveTicket() {
    this.ticketService.saveTicket(this.ticketF).subscribe()
  }

  getAllWay() {

  }

  getAllTickets() {
    this.ticketService.getAll().subscribe(data => {
      this.ticketsList = data;
    })
  }
}
