import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Locat} from "../model/locat";

const CARB_API = 'https://aviatickets-3212.herokuapp.com/location/';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http: HttpClient) {
  }

  getAllLocations(): Observable<Locat[]> {
    return this.http.get<Locat[]>(CARB_API + "all", httpOptions);
  }

  getLocationById(id: bigint): Observable<Locat> {
    return this.http.get<Locat>(CARB_API + id, httpOptions);
  }

}
