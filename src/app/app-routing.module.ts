import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {HomepageComponent} from './homepage/homepage.component';
import {BrasketComponent} from "./brasket/brasket.component";
import {LoginComponent} from "./login/login.component";
import {RegisrtComponent} from "./regisrt/regisrt.component";
import {ProfileComponent} from "./profile/profile.component";
import {FindComponent} from "./find/find.component";
import {AdminComponent} from "./admin/admin.component";


const routes: Routes = [
  {path: '', component: HomepageComponent},
  {path: 'brasket/:ids', component: BrasketComponent},
  {path: 'login', component: LoginComponent},
  {path: 'regisrt', component: RegisrtComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'file/:start/:end/:cst/:ced', component: FindComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
