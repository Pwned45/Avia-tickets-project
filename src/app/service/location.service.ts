import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Location} from "../model/location";

const CARB_API = 'http://localhost:8882/location/';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http: HttpClient) {
  }

  getAllLocations(): Observable<Location[]> {
    return this.http.get<Location[]>(CARB_API + "all", httpOptions);
  }

  getLocationById(id: bigint): Observable<Location> {
    return this.http.get<Location>(CARB_API + id, httpOptions);
  }

}
