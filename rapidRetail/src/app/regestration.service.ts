import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http'
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegestrationService {
  private baseurl = "http://localhost:2020";

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<any[]> {
    const url = `${this.baseurl}/getAllUsers`;
    return this.http.get<any[]>(url);
  }

  deleteUserByEmail(email: string): Observable<any> {
    const url = `http://localhost:2020/getAllUsers/${email}`;
    return this.http.delete(url).pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status === 200) {
          console.log(`User with email ${email} deleted successfully.`);
          // Additional handling if needed
        } else {
          console.error(`Error deleting user with email ${email}:`, error);
        }
        // Continue the observable stream by returning an empty observable
        return new Observable();
      })
    );
  }



  createUser(user: any): Observable<any> {
    const url = `${this.baseurl}/saveUser`;
    return this.http.post(url, user);
  }

  updatePassword(updatePasswordData: any): Observable<string> {
    return this.http.post<string>(`${this.baseurl}/getAllUsers/update-password`, updatePasswordData);
  }

  checkOldPassword(data: any): Observable<boolean> {
    const url = `${this.baseurl}/check-password`;
    return this.http.post<boolean>(url, data)
      .pipe(
        catchError((error: HttpErrorResponse) => {
          console.error(`Error checking old password:`, error);
          return throwError(() => false);
        })
      )


    // register(user: any): void {
    //   console.log('User registration', user);
    // }




  }
}



