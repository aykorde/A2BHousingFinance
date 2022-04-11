import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LogUser } from '../loginservice.service';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  title = 'homeloan';
  isShow = false;
 
  toggleDisplay() {
    this.isShow = !this.isShow;
}

  constructor(private router: Router, private loguser: LogUser) { }

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
}

