import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../service/token-storage.service";
import {ClientsService} from "../service/user.service";
import {TicketService} from "../service/ticket.service";
import {User} from "../model/user";
import {Client} from "../model/client";
import {Locat} from "../model/locat";
import {LocationService} from "../service/location.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  err = '';
  mem = false;
  loading = false;
  isLogin = false;
  user: User;
  client: Client;
  name = '';
  flag = true;
  location: Locat[];
  date: Date;

  constructor(private tokenStorage: TokenStorageService, private clientSev: ClientsService, private ticket: TicketService, private locationServ: LocationService) {
    this.date = new Date();
  }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLogin = true;
      this.user = this.tokenStorage.getUser();
      this.getClient();
      this.getAllLocation();
    }
    if (!(this.err === '')) {
      this.flag = false;
    }
  }

  getAllLocation() {
    this.locationServ.getAllLocations().subscribe(date => {
      this.location = date;
      console.log(date);
    })
  }

  getClient(): void {
    this.clientSev.getClient(this.tokenStorage.getUser().id).subscribe(data => {
      this.client = data;
    });
  }


  onSubmit() {
    this.client.pass=null;
    this.clientSev.patchClient(this.client,this.user.id).subscribe(data=>{
      console.log(data)
    }, error => {
      this.err=error.message;
    })
  }
}
