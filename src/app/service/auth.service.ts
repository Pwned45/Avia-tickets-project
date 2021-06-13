import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Auth} from '../model/auth';
import {User} from "../model/user";

const AUTH_API = 'http://localhost:8882/auth';//TODO: Я опять же не знаю какой тут у нас адресс будет

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
  }

  login(user: Auth): Observable<any> {
    return this.http.post<Auth>(AUTH_API + '/login', user, httpOptions);
  }

  register(user: User): Observable<any> {
    return this.http.post<any>(AUTH_API+'/reg', user, httpOptions);
  }
}
