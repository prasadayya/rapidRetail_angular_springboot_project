import { Component } from '@angular/core';
import { RegestrationService } from '../regestration.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrl: './user-details.component.css'
})
export class UserDetailsComponent {
  users: any[] = [];
  constructor(private userService: RegestrationService) {}

  ngOnInit(): void {
    this.loadAllUsers();
  }

  loadAllUsers(): void {
    this.userService.getAllUsers().subscribe({
      next: (data: any) => {
        this.users = data;
      },
      error: (error) => {
        console.error('Error fetching user details:', error);
      },
    });
  }

  deleteUser(email: string): void {
    if (confirm('Are you sure you want to delete this user?')) {
      this.userService.deleteUserByEmail(email).subscribe({
        next: (data:any) => {
          console.log(`User with email ${email} deleted successfully.`);
          // Refresh the user list or perform any other necessary actions
          this.loadAllUsers();
        },

        error: (error) => {
          console.error(`Error deleting user with email ${email}:`, error);
        }
      });
    }
  }
 }


