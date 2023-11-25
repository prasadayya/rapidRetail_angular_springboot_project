import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  constructor(private router: Router) {}

  navigateToregister() {
    this.router.navigate(['/register']);
  }

  navigateToLogin(){
    this.router.navigate(['/login']);
  }

  navigateToUserdetail(){
    this.router.navigate(['/user-details']);
  }

  url1="../assets/product1.jpg";
  url2="../assets/product2.jpg";
  url3="../assets/product3.jpg";
  url4="../assets/product4.jpg";
  url5="../assets/product5.jpg";
  url6="../assets/product6.jpg";
  url7="../assets/product7.jpg";
  url8="../assets/product8.jpg";

}
