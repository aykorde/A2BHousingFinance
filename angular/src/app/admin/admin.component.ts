import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LogUser } from '../loginservice.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private router: Router, private loguser: LogUser) { }

  ngOnInit(): void {
    
  }

  

  logout(): void{
    this.loguser.logged=false; 
    this.loguser.userid=0;
    this.router.navigate(['/login'])
  }

}
