import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginserviceService, LogUser } from '../loginservice.service';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit {

  constructor(private forgot: LoginserviceService, private loguser: LogUser, private router : Router) { }

  ngOnInit(): void {
    
  }

  

  msg: string;
  email: string;
  getPassword():void{

    this.forgot.forgetpassword(this.email).subscribe((data)=>{
    
      if(data=="sent"){
        this.msg = "Password has been sent to your registered Email Id";
        document.getElementById("login").style.visibility="visible";
      }
      else{
        this.msg = "Enter your registered Email Id";
      }
    });
  }

  
}
