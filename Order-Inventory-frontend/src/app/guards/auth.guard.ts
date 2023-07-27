import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../service/auth.service';

 

@Injectable({
  providedIn:'root'
}) 

export class AuthGuard implements CanActivate{
  constructor(private auth:AuthService, private router:Router){}
  canActivate(route: ActivatedRouteSnapshot,
              state:RouterStateSnapshot): boolean | Promise<boolean> | Observable<boolean>{
                //return true;
                if(!this.auth.isLoggedIn){
                this.router.navigate(['login']);
                return false ;
                }
                return this.auth.isLoggedIn();
              }

}

