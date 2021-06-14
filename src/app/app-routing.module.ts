import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {HomepageComponent} from './homepage/homepage.component';
import {RegistrationComponent} from "./registration/registration.component";
import {LoginComponent} from "./login/login.component";
import {ProfileComponent} from "./profile/profile.component";
import {AdminComponent} from "./admin/admin.component";
import {FindpageComponent} from "./findpage/findpage.component";
import {BasketComponent} from "./basket/basket.component";


const routes: Routes = [
  {path: '', component: HomepageComponent},
  {path: 'find', component: FindpageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'reg', component: RegistrationComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'basket/:ids', component: BasketComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
