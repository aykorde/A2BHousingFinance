import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { AdminComponent } from './admin/admin.component';
import { ApplicationComponent } from './application/application.component';
import { ApplyComponent } from './apply/apply.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { EligibleComponent } from './eligible/eligible.component';
import { EmiComponent } from './emi/emi.component';
import { FaqComponent } from './faq/faq.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { TrackstatusComponent } from './trackstatus/trackstatus.component';
import { UserapplicationComponent } from './userapplication/userapplication.component';
import { Userapplication2Component } from './userapplication2/userapplication2.component';
import { ViewalldocComponent } from './viewalldoc/viewalldoc.component';

const routes: Routes = [{
  path : 'aboutus',
  component : AboutusComponent
},
{
  path : 'login',
  component : LoginComponent
},
{
  path : 'calculator',
  component : CalculatorComponent
},
{
  path : 'calculator/emi',
  component : EmiComponent
},
{
  path : 'calculator/eligible',
  component : EligibleComponent
},
{
  path : 'forgotpassword',
  component : ForgotpasswordComponent
},
{
  path : 'application/:id',
  component : ApplicationComponent
},
{
  path : 'faq',
  component : FaqComponent
},
{
  path : 'login/admin',
  component : AdminComponent
},
{
  path : 'admin/userapplication',
  component : UserapplicationComponent
},
{
    path : 'admin/userapplication2',
    component : Userapplication2Component
},
{
  path : 'admin/viewall',
  component : ViewalldocComponent
},
{
  path : 'home',
  component : HomeComponent
},
{
  path : 'apply/:id',
  component : ApplyComponent
},
{
  path : 'trackstatus',
  component : TrackstatusComponent
},
 { path: '', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
