import { Component, OnInit } from '@angular/core';
import {Client} from "../model/client";
import {TokenStorageService} from "../service/token-storage.service";
import {AuthService} from "../service/auth.service";
import {LocationService} from "../service/location.service";
import {Locat} from "../model/locat";


@Component({
  selector: 'app-regisrt',
  templateUrl: './regisrt.component.html',
  styleUrls: ['./regisrt.component.css']
})
export class RegisrtComponent implements OnInit {
  client: Client;
  locationt:Locat[]=[]
  loc:Locat;
  err = '';
  isLogin = false;
  loading = false;
  id:bigint;
  name = '';
  dateb;
  constructor(private tokenStorage: TokenStorageService, private authService: AuthService,private locationService: LocationService) {
    this.client = new Client();
    this.loc=new Locat();
    this.client.locationDto=this.loc;
    this.dateb = new Date();
  }

  ngOnInit(): void {
    this.getAllLocation();
    if (this.tokenStorage.getToken()) {
      this.isLogin = true;
      this.name = this.tokenStorage.getUser().name;

    }
  }
  onSubmit(): void {
    console.log(this.client);
    this.loading = true;
    this.client.locationDto.idLocation=this.id;
    console.log(this.client)
    this.authService.register(this.client).subscribe(
      data => {
        this.loading = false;
        location.href = '/login';
      }, error => {
        this.err = error.error.message;
        console.log(error);
      }
    );
    this.err = '';
  }
  getAllLocation() {
    this.locationService.getAllLocations().subscribe(date => {
      this.locationt = date;
      console.log(this.locationt);
    })
  }
}
