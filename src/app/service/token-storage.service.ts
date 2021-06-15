import { Injectable } from '@angular/core';
import {User} from '../model/user';

const TOKEN_KEY = 'auth-token';
const USER = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }
  signOut(): void {
    sessionStorage.clear();
  }

  public saveToken(token: string): void {
    sessionStorage.removeItem(TOKEN_KEY);
    sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user:User): void {
    sessionStorage.removeItem(USER);
    sessionStorage.setItem(USER, JSON.stringify(user));
  }

  public getUser(): User {
    return JSON.parse(sessionStorage.getItem(USER));
  }
}
