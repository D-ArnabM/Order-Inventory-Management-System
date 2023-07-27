import { Component, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Injectable({
  providedIn: 'root',
})

@Component({
  selector: 'app-landingpage',
  templateUrl: './landingpage.component.html',
  styleUrls: ['./landingpage.component.css']
})
export class LandingpageComponent {
  constructor(private auth: AuthService, private router: Router){}
  logout():void{
    this.auth.logout();
  }

  goToLogIn(){
    this.router.navigate(['login']);
  }
}
