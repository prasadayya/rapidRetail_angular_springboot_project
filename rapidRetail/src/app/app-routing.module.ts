import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { UpdateComponent } from './update/update.component';
import { UserDetailsComponent } from './user-details/user-details.component';

const routes: Routes = [
  {component: RegisterComponent , path: 'register'},
  { component: LoginComponent, path:'login'},
  {component: UpdateComponent, path:'update'},
  {component: UserDetailsComponent, path:'user-details'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
