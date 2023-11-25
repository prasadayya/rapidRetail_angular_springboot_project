import { Component } from '@angular/core';
import { RegestrationService } from '../regestration.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrl: './update.component.css'
})
export class UpdateComponent {
  formData = {
    email: '',
    oldPassword: '',
    newPassword: ''
  };

  updateSuccess: boolean = false;
  passwordMismatch: boolean = false;

  constructor(private userService: RegestrationService) { }

  onSubmit(updatePasswordForm: NgForm): void {
    if (updatePasswordForm.valid) {
      this.formData.newPassword = updatePasswordForm.value.newPassword;

      const updatePasswordData = {
        email: this.formData.email,
        oldPassword: this.formData.oldPassword,
        newPassword: this.formData.newPassword
      };

      this.userService
        .checkOldPassword(updatePasswordData)
        .subscribe({
          next: (isPasswordMatch: boolean) => {
            if (isPasswordMatch) {
              if (updatePasswordData.newPassword) {
                this.userService
                  .updatePassword(updatePasswordData)
                  .subscribe({
                    next: (data: string) => {
                      console.log(data);
                      this.updateSuccess = true;
                    },
                    error: (error) => {
                      console.log(error);
                    },
                  });
              } else {
                console.log("No new password provided. Skipping update.");
                this.updateSuccess = false;
              }
            } else {
              this.passwordMismatch = true;
            }
          },
          error: (error) => {
            console.log(error);
          },
        });
    } else {
      console.log('Form is invalid. Please check the fields.');

    }
  }
}