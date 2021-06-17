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
  user: User;
  client: Client;
  clients: Client[];
  uniqTicket: Ticket[] = [];
  flag = true;
  date: Date;

  constructor(private tokenStorage: TokenStorageService, private clientSev: ClientsService, private ticketService: TicketService, private locationServ: LocationService) {
    this.date = new Date();
  }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLogin = true;
      this.user = this.tokenStorage.getUser();
      if (this.user.role == "ADMIN") {
        this.getAllClient()
      } else {

      }
    }
    if (!(this.err === '')) {
      this.flag = false;
    }
  }

  onSubmit() {

  }

  getAllClient() {
    this.clientSev.getAllClient().subscribe(data => {
      this.clients = data
    }, error => {
      this.err = error.message
    })
  }
  deleteUser(id:bigint){
    this.clientSev.deleteClient(id).subscribe(data=>{
      window.location.reload()
    })
  }
}
