import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApplicationserviceService } from '../applicationservice.service';
import { LogUser } from '../loginservice.service';

@Component({
  selector: 'app-apply',
  templateUrl: './apply.component.html',
  styleUrls: ['./apply.component.css']
})
export class ApplyComponent implements OnInit {

  title = 'homeloan';
  isShow = false;
 
  toggleDisplay() {
    this.isShow = !this.isShow;
}
fn;mn;ln;dob;g;n;ac;pc;mla;ir;t;la;pl;pn;ea;et;ra;ot;en;
    appid;

  constructor(private router: Router, private loguser: LogUser, private applynow : ApplicationserviceService) { }

  ngOnInit(): void {
    if(this.loguser.logged==false){
      this.router.navigate(['/'])
    }
    
    
    
  console.log(this.loguser.userid);

    this.applynow.applynow(this.loguser.userid).subscribe((data)=>{
    
      this.appid=data.income.applicationid.applicationid;
      this.fn=data.income.userid.first_name;
      this.mn=data.income.userid.middle_name;
      this.ln=data.income.userid.last_name;
      this.dob=data.income.userid.dob;
      this.g=data.income.userid.gender;
      this.n=data.income.userid.nationality;
      this.ac=data.income.userid.aadharcard;
      this.pc=data.income.userid.pancard;
      this.mla=data.income.applicationid.maxloanamount;
      this.ir=data.income.applicationid.interestrate;
      this.t=data.income.applicationid.tenure;
      this.la=data.income.applicationid.loanamount;
      this.pl=data.income.propertylocation;
      this.pn=data.income.propertyname;
      this.ea=data.income.estimatedamount;
      this.et=data.income.employmenttype;
      this.ra=data.income.retirementage;
      this.ot=data.income.organizationtype;
      this.en=data.income.employername;
    });
  }

  application():void { 
      this.router.navigate(['/application/' + this.loguser.userid])
  }

  home() : void{
      this.router.navigate(['/home'])  
  }

  apply() : void{
      this.router.navigate(['/apply/'+ this.loguser.userid])
  }

  logout(): void{
    this.loguser.logged=false; 
    this.loguser.userid=0;
    this.router.navigate(['/login'])
  }
  msg: String;
 
  applyloan() : void{
    this.applynow.applyloan(this.appid).subscribe((data)=>{
      if(data=="applied"){
        this.msg= this.appid;
      }
      
    });
  }

}
