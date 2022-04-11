import { Component, OnInit, ɵɵqueryRefresh } from '@angular/core';
import { Router } from '@angular/router';
import { LogUser } from '../loginservice.service';
import { UserapplicationserviceService } from '../userapplicationservice.service';

@Component({
  selector: 'app-userapplication',
  templateUrl: './userapplication.component.html',
  styleUrls: ['./userapplication.component.css']
})
export class UserapplicationComponent implements OnInit {

  approve1list;
  

  constructor(private userapplicationservice: UserapplicationserviceService, private router: Router, private loguser: LogUser) { }

  ngOnInit(): void {

    

    this.userapplicationservice.getapprove1().subscribe((data)=>{
      console.log(data);
      this.approve1list = data;
    }); 
  }

  approve1(appid : String) :void{
    console.log(appid);
    this.userapplicationservice.approve1(appid).subscribe((data)=>{
      console.log(data);
    });

  }

  reject(appid: String): void{
    console.log(appid);
    this.userapplicationservice.reject(appid).subscribe((data)=>{
      console.log(data);
    });
  }
  logout(): void{
    this.loguser.logged=false; 
    this.loguser.userid=0;
    this.router.navigate(['/login'])
  }
  
}


