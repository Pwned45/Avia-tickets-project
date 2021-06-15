import {Component, OnInit} from '@angular/core';
import {LocationService} from "../service/location.service";
import {Location} from "../model/location";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  location: Location[]=[];

  constructor(private locationService: LocationService) {
  }

  ngOnInit(): void {
    this.getAllLocation();

  }

  getAllLocation() {
    this.locationService.getAllLocations().subscribe(date => {
      this.location = date;
      console.log(date);
    })
  }

  onSubmit() {
    location.href = '/profile';
  }
}
