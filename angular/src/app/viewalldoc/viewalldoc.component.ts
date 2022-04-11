import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApplicationserviceService } from '../applicationservice.service';
import { LogUser } from '../loginservice.service';

@Component({
  selector: 'app-viewalldoc',
  templateUrl: './viewalldoc.component.html',
  styleUrls: ['./viewalldoc.component.css']
})
export class ViewalldocComponent implements OnInit {

  constructor(private router: Router, private loguser: LogUser, private appservice: ApplicationserviceService) { }
  
  ApplicationId: String;

  docsjson;
  ngOnInit(): void {
  }

  logout(): void{
    this.loguser.logged=false; 
    this.loguser.userid=0;
    this.router.navigate(['/login'])
  }
i;
pan;
vi;
ss;
loa;
noc;
ats;
base64Data: any;
retrievedImage: any;
  viewAll(): void{
    this.appservice.getdocs(this.ApplicationId).subscribe((data)=>{
      this.docsjson=data;
      this.pan=this.docsjson[0];
      this.vi=this.docsjson[1];
      this.ss=this.docsjson[2];
      this.loa=this.docsjson[3];
      this.noc=this.docsjson[4];
      this.ats=this.docsjson[5];
    });
    (<HTMLInputElement>document.getElementById("docs")).hidden = false;
  }

  download1() : void{
    this.base64Data = this.pan.picByte;
    this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
  }
  download2() : void{
    this.base64Data = this.vi.picByte;
    this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
  }
  download3() : void{
    this.base64Data = this.ss.picByte;
    this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
  }
  download4() : void{
    this.base64Data = this.loa.picByte;
    this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
  }
  download5() : void{
    this.base64Data = this.noc.picByte;
    this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
  }
  download6() : void{
    this.base64Data = this.ats.picByte;
    this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
  }


}
