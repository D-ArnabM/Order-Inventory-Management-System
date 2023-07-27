import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './guards/auth.guard';
import { ForgotPasswordComponent } from './logincomponents/forgot-password/forgot-password.component';
import { LandingpageComponent } from './logincomponents/landingpage/landingpage.component';
import { LoginComponent } from './logincomponents/login/login.component';
import { NotFoundComponent } from './logincomponents/not-found/not-found.component';

const routes: Routes = [
  {path: 'landingpage', component: LandingpageComponent},
  {path:'login',component:LoginComponent},
  {path:'forgot-password',component:ForgotPasswordComponent},
  {path:'',redirectTo:'/landingpage',pathMatch:'full'},
  {
    path:'admin', 
    canActivate:[AuthGuard],
    loadChildren:()=> import('./modules/admin/admin.module').then((m)=>m.AdminModule),
  },
  {path:'**',component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
