import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
user ={
  email: '',
  password: '',
};

login(): any {
 
  console.log('User logged in:', this.user);
  
}

getForm(data:any){
  console.log(data);
}

}
