import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {ResultTicketDto} from "../model/resultTicketDto";

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent implements OnInit {
  f: string;
  toRes:ResultTicketDto;
  fromRes:ResultTicketDto;
  constructor(private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.f = params.ced;
    });
  }

  getTicetTo(){

  }
}
