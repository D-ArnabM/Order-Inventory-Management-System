import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './logincomponents/login/login.component';
import { ForgotPasswordComponent } from './logincomponents/forgot-password/forgot-password.component';
import { NotFoundComponent } from './logincomponents/not-found/not-found.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LandingpageComponent } from './logincomponents/landingpage/landingpage.component';

import { CustomHttpInterceptor } from './modules/admin/services/http-interceptor';

import { EmailFormatDirective } from './custom-directive/email-format.directive';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ForgotPasswordComponent,
    NotFoundComponent,
    LandingpageComponent,
    EmailFormatDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ {
    provide: HTTP_INTERCEPTORS,
    useClass: CustomHttpInterceptor,
    multi: true,
  },],
  bootstrap: [AppComponent]
})
export class AppModule { }
