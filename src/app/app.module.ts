import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
// import {authInterceptorProviders} from './AuthInterceptor/AuthInterceptor';
import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {HomepageComponent} from "./homepage/homepage.component";
import {BrasketComponent} from "./brasket/brasket.component";
import {FindComponent} from "./find/find.component";
import {ProfileComponent} from "./profile/profile.component";
import {RegisrtComponent} from "./regisrt/regisrt.component";
import {LoginComponent} from "./login/login.component";
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";
import {authInterceptorProviders} from "./AuthInterceptor/AuthInterceptor";
import {AdminComponent} from "./admin/admin.component";

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomepageComponent,
    BrasketComponent,
    FindComponent,
    ProfileComponent,
    RegisrtComponent,
    LoginComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
