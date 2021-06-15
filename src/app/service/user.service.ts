import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Client} from '../model/client';

const USER_API = 'http://localhost:8882/user/';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor(private http: HttpClient) {
  }

  // getAllClient(): Observable<Client[]> {
  //   return this.http.get<Client[]>(USER_API, httpOptions);
  // }
  //
  // getClient(idUser: bigint): Observable<Client> {
  //   return this.http.get<Client>(USER_API + idUser, httpOptions);
  // }
  //
  // postClient(cl: Client): Observable<void> {
  //   return this.http.post<void>(USER_API, cl, httpOptions);
  // }
  //
  // patchClient(cl: Client, id: bigint): Observable<any> {
  //   console.log('dsd');
  //   return this.http.patch<any>(USER_API + 1 + '/client', cl);
  // }
  //
  // getClientAdvert(idUser: bigint): Observable<Advertisment[]> {
  //   return this.http.get<Advertisment[]>(USER_API + idUser + '/advert', httpOptions);
  // }
  //
  // getClientComparepage(idUser: bigint, page: number, size: number): Observable<PageCompare> {
  //   return this.http.get<PageCompare>(USER_API + idUser + '/compare' + '?page=' + page + '&size=' + size, httpOptions);
  // }
  //
  // getClientCompare(idUser: bigint): Observable<Compare[]> {
  //   return this.http.get<Compare[]>(USER_API + idUser + '/compareList', httpOptions);
  // }
  //
  // deleteClient(idUser: bigint): Observable<void> {
  //   return this.http.delete<void>(USER_API + idUser, httpOptions);
  // }
  //
  // deleteClientComp(idComp: bigint): Observable<void> {
  //   return this.http.delete<void>(USER_API + 'comparedelete/' + idComp, httpOptions);
  // }
  //
  // postCompare(idUser: bigint, idAdvert: bigint): Observable<any> {
  //   return this.http.get<any>(USER_API + idUser + '/advertcomp/' + idAdvert,
  //     httpOptions);
  // }
}
