import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountCreateComponent } from './account-create/account-create.component';
import { AccountListComponent } from './account-list/account-list.component';
import { DashboardPageComponent } from './dashboard-page/dashboard-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { SignUpPageComponent } from './sign-up-page/sign-up-page.component';
import { TransactionAddComponent } from './transaction-add/transaction-add.component';
   import { TransactionViewComponent } from './transaction-view/transaction-view.component';

const routes: Routes = [
  { path: '', redirectTo: 'home-page', pathMatch: 'full' },
  { path: 'home-page', component: HomePageComponent },
  { path: 'dashboard-page', component: DashboardPageComponent },
  {path:'profile-page',component:ProfilePageComponent},
  {path:'login-page',component:LoginPageComponent},
  {path:'sign-up-page',component:SignUpPageComponent},
    { path: 'transaction-add', component: TransactionAddComponent},
  { path: 'transaction-view', component: TransactionViewComponent},
  {path:'account-create',component:AccountCreateComponent},
  {path:'account-list',component:AccountListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
