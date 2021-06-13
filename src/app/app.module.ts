import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
// import {authInterceptorProviders} from './AuthInterceptor/AuthInterceptor';
import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {HomepageComponent} from "./homepage/homepage.component";

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomepageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
