import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LogUser } from '../loginservice.service';
import { UserapplicationserviceService } from '../userapplicationservice.service';


@Component({
  selector: 'app-userapplication2',
  templateUrl: './userapplication2.component.html',
  styleUrls: ['./userapplication2.component.css']
})
export class Userapplication2Component implements OnInit {
  
  approve2list;
  constructor(private userapplicationservice: UserapplicationserviceService, private router: Router, private loguser: LogUser) { }

  ngOnInit(): void {

    

    this.userapplicationservice.getapprove2().subscribe((data)=>{
      console.log(data);
      this.approve2list = data;
    });

  }

  approve2(appid : String) :void{
    console.log(appid);
    this.userapplicationservice.approve2(appid).subscribe((data)=>{
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
