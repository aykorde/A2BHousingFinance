import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoanObj } from '../ApInterface';
import { ApplicationserviceService } from '../applicationservice.service';
import { LogUser } from '../loginservice.service';

@Component({
  selector: 'app-trackstatus',
  templateUrl: './trackstatus.component.html',
  styleUrls: ['./trackstatus.component.css']
})
export class TrackstatusComponent implements OnInit {

  title = 'homeloan';
  isShow = false;
 
  toggleDisplay() {
    this.isShow = !this.isShow;
}

  constructor(private router: Router, private loguser: LogUser,private appservice:ApplicationserviceService,private datePipe: DatePipe) { }

  ngOnInit(): void {
    if(this.loguser.logged==false){
      this.router.navigate(['/'])
    }
  }

  application():void { 
      this.router.navigate(['/application/' + this.loguser.userid])
  }

  home() : void{
      this.router.navigate(['/home'])  
  }

  apply() : void{
      this.router.navigate(['/apply/' + this.loguser.userid])
  }

  logout(): void{
    this.loguser.logged=false; 
    this.loguser.userid=0;
    this.router.navigate(['/login'])
  }


loanobj: LoanObj;
stringJson;
  
  msg: string;
  msg1: String;
  ApplicationId='';
  trackStatus():void{

    this.appservice.trackStatus(this.ApplicationId).subscribe((data)=>{
      this.loanobj=data;
    if(this.loanobj.status=="sent for verification"){
      this.msg="Your current Application Status: " + this.loanobj.status;
      this.msg1="";
      document.getElementById('msg').setAttribute("style", "color:orange;");
    }
    else if(this.loanobj.status=="verified and sent for further appointment"){
      this.msg="Your current Application Status: " + this.loanobj.status;
      
      this.msg1="Document Verification Date: " +this.datePipe.transform(this.loanobj.docverificationdate,'dd-MM-yyyy');
      document.getElementById('msg').setAttribute("style", "color:blue;");
      document.getElementById('msg1').setAttribute("style", "color:blue;");
    }
    else if(this.loanobj.status=="approved"){
      this.msg="Your current Application Status: " + this.loanobj.status;
      this.msg1=" Bank Account no. : " +this.loanobj.accno;
      document.getElementById('msg').setAttribute("style", "color:green;");
      document.getElementById('msg1').setAttribute("style", "color:green;");
    }
    else if(this.loanobj.status=="rejected"){
      this.msg="Your current Application Status: " + this.loanobj.status;
      this.msg1="";
      document.getElementById('msg').setAttribute("style", "color:red;");
    }
     
    });
  }

}
