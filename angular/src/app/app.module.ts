import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';
import { CalculatorComponent } from './calculator/calculator.component';
import { EmiComponent } from './emi/emi.component';
import { Ng5SliderModule } from 'ng5-slider';
import { EligibleComponent } from './eligible/eligible.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { ApplicationComponent } from './application/application.component';
import { FaqComponent } from './faq/faq.component';
import { AdminComponent } from './admin/admin.component';
import { UserapplicationComponent } from './userapplication/userapplication.component';
import { LoginserviceService, LogUser } from './loginservice.service';
import { UserapplicationserviceService } from './userapplicationservice.service';
import { Userapplication2Component } from './userapplication2/userapplication2.component';
import { HomeComponent } from './home/home.component';
import { ApplicationserviceService } from './applicationservice.service';
import { ApplyComponent } from './apply/apply.component';
import { TrackstatusComponent } from './trackstatus/trackstatus.component';
import { DatePipe } from '@angular/common';
import { ViewalldocComponent } from './viewalldoc/viewalldoc.component';



@NgModule({
  declarations: [
    AppComponent,
    AboutusComponent,
    LoginComponent,
    CalculatorComponent,
    EmiComponent,
    EligibleComponent,
    ForgotpasswordComponent,
    ApplicationComponent,
    FaqComponent,
    AdminComponent,
    UserapplicationComponent,
    Userapplication2Component,
    HomeComponent,
    ApplyComponent,
    TrackstatusComponent,
    ViewalldocComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    Ng5SliderModule
  ],
  providers: [LoginserviceService, UserapplicationserviceService, LogUser, ApplicationserviceService, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
