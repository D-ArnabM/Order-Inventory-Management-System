import { Observable, of, switchMap, throwError } from 'rxjs';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Login } from '../login';
import { TokenDetails } from '../logincomponents/login/tokendetails';

@Injectable({
  providedIn: 'root',
})


export class AuthService {
  
  constructor(private router: Router, private http: HttpClient, private userlogin: Login) {}

  private validateUserUrl = "http://localhost:8005/auth/login";
  private  check = false;

  setToken(token: string): void {
    if(token !== null){
    localStorage.setItem('token', token);
    }
    else{
      localStorage.removeItem('token');
    }
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  isLoggedIn() {
    return this.getToken() !== null;
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['landingpage']);
    this.check = false;
  }

  validateUser(login: Login): Observable<TokenDetails> {
    return this.http.post<TokenDetails>(this.validateUserUrl, login);
  }

  login({ email, password }: any): Observable<any> {
    this.userlogin.email = email;
    this.userlogin.password = password;

    return this.validateUser(this.userlogin).pipe(
      switchMap((result) => {
        if (result) {
          this.setToken(result.jwtToken);
          return of({ name: result.username, email: email });
        } else {
          return throwError(new Error('Failed to login'));
        }
      })
    );
  }

  getHeaders(): HttpHeaders {
    const token = this.getToken();
    if (token) {
      return new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      });
    }
    return new HttpHeaders({ 'Content-Type': 'application/json' });
  }
}



 