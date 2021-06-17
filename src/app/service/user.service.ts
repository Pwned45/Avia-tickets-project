import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Client} from '../model/client';
import {Check} from "../model/check";

const USER_API = 'https://aviatickets-3212.herokuapp.com/user/';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor(private http: HttpClient) {
  }

  getAllClient(): Observable<Client[]> {
    return this.http.get<Client[]>(USER_API + "all", httpOptions);
  }

  getClient(idUser: bigint): Observable<Client> {
    return this.http.get<Client>(USER_API + idUser, httpOptions);
  }

  deleteClient(idUser: bigint): Observable<void> {
    return this.http.delete<void>(USER_API + idUser, httpOptions);
  }

  patchClient(cl: Client, id: bigint): Observable<any> {
    return this.http.patch<any>(USER_API + id, cl);
  }

  getClientChecks(idUser: bigint): Observable<Check[]> {
    return this.http.get<Check[]>(USER_API + idUser + '/checks', httpOptions);
  }
  

}
