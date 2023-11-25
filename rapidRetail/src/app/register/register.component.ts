import { Component } from '@angular/core';
import { RegestrationService } from '../regestration.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  user = {
    name: '',
    email:'',
    phone:'',
    password:'',
  };

  constructor(private userService: RegestrationService, private router: Router) {}

  // onSubmit(signUp: NgForm): void{
  //   if(signUp.valid){
  //     console.log("Form submmited", signUp.value);
  //     this.saveUser(signUp.value);
  //   }else{
  //     console.log("invalid form");
  //   }

  // }

  onSubmit(signUp: NgForm): void {
    if (signUp.valid) {
      alert("Form submitted\n" + JSON.stringify(signUp.value));
      this.saveUser(signUp.value);
    } else {
      alert("Invalid form");
    }
  }

  saveUser (user: any) : void{
    this.userService.createUser(user).subscribe({
      next: (data: any) => {
        console.log(data);
      },
      error: (error) => {
        console.log(error);
        // Handle the error as needed
      },
    })
  }

}

