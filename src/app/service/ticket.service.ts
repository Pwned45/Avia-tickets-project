import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Client} from '../model/client';
import {Check} from "../model/check";
import {ParametrSerch} from "../model/parametrSerch";
import {ResultTicketDto} from "../model/resultTicketDto";
import {Choice} from "../model/choice";
import {Ticket} from "../model/ticket";
import {TicketDtoFront} from "../model/ticketDtoFront";

const USER_API = 'http://localhost:8882/ticket/';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor(private http: HttpClient) {
  }

  getTicketsS(param: ParametrSerch): Observable<ResultTicketDto> {
    return this.http.post<ResultTicketDto>(USER_API + "all", httpOptions);
  }

  buy(choice: Choice): Observable<any> {
    return this.http.post<any>(USER_API + "buy", choice, httpOptions);
  }

  getUniqe(idUser: bigint): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(USER_API + idUser + '/uniqe', httpOptions);
  }
  getById(idT: bigint): Observable<Ticket> {
    return this.http.get<Ticket>(USER_API + idT , httpOptions);
  }

  patchTicket(ticket: Ticket): Observable<any> {
    return this.http.patch<any>(USER_API, ticket);
  }

  deleteTicket(id: bigint): Observable<any> {
    return this.http.delete<any>(USER_API + id);
  }

  saveTicket(ticketF: TicketDtoFront): Observable<any> {
    return this.http.post<any>(USER_API, ticketF);
  }

}
