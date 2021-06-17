import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Locat} from "../model/locat";
import {Way} from "../model/way";

const CARB_API = 'https://aviatickets-3212.herokuapp.com/way/';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class WayService {

  constructor(private http: HttpClient) {
  }

  getAllAvalWay(): Observable<Way[]> {
    return this.http.get<Way[]>(CARB_API + "all", httpOptions);
  }


}
