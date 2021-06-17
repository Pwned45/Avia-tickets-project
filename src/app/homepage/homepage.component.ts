import {Component, OnInit} from '@angular/core';
import {LocationService} from "../service/location.service";
import {Locat} from "../model/locat";
import {ParametrSerch} from "../model/parametrSerch";
import {SearchUrl} from "../model/SearchUrl";
import {TokenStorageService} from "../service/token-storage.service";
import {User} from "../model/user";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  location: Locat[] = [];
  params: SearchUrl;
  date;
  isLogin;
  user: User;

  constructor(private locationService: LocationService, private tokenStroage: TokenStorageService) {
    this.date = new Date();
    this.params = new SearchUrl();
  }

  ngOnInit(): void {
    if (this.tokenStroage.getToken()) {
      this.isLogin = true;
      this.user = this.tokenStroage.getUser();
    }
    this.getAllLocation();
  }

  getAllLocation() {
    this.locationService.getAllLocations().subscribe(date => {
      this.location = date;
      console.log(date);
    },error => {
      console.log(error.message)
    })
  }

  getDate(date: string): Date {
    return new Date(date);
  }

  onSubmit() {
    if (this.params.dateE == null) {
      this.params.dateE="0";
      location.href = '/file/' + this.params.dateS + '/' + this.params.dateE + '/' + this.params.cityStart + '/' + this.params.cityEnd;
    }else {
      location.href = '/file/' + this.params.dateS + '/' + this.params.dateE + '/' + this.params.cityStart + '/' + this.params.cityEnd;
    }
    console.log(this.params)
  }
}
