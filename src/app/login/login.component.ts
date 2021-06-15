import { Component, OnInit } from '@angular/core';
import {Auth} from "../model/auth";
import {AuthService} from "../service/auth.service";
import {TokenStorageService} from "../service/token-storage.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  auth: Auth;
  err = '';
  loading = false;
  isLogin = false;
  name = '';
  flag = true;
  constructor(private tokenStorage: TokenStorageService, private authService: AuthService) {
    this.auth = new Auth();
  }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLogin = true;
      this.name = this.tokenStorage.getUser().name;
    }
    if (!(this.err === '')) {
      this.flag = false;
    }
  }

  onSubmit(): void {
    console.log(this.auth);
    this.loading = true;
    this.authService.login(this.auth).subscribe(
      data => {
        this.tokenStorage.saveToken(data.token);
        console.log(data.token);
        this.loading = false;
        this.tokenStorage.saveUser(data);
        location.href = '/profile';
      }, error => {
        this.err = error.error.message;
        console.log(error);
      }
    );
    this.err = '';
  }
}
