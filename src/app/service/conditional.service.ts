import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Conditionals} from "../model/conditionals";

const CARB_API = 'https://aviatickets-3212.herokuapp.com/condit/';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ConditionalService {

  constructor(private http: HttpClient) {
  }

  getAllConditionals(): Observable<Conditionals[]> {
    return this.http.get<Conditionals[]>(CARB_API + "all", httpOptions);
  }

  getConditionalsById(id: bigint): Observable<Conditionals> {
    return this.http.get<Conditionals>(CARB_API + id, httpOptions);
  }

}
