import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LogUser } from './loginservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'homeloan';
  isShow = false;
 
  toggleDisplay() {
    this.isShow = !this.isShow;
}

constructor(private router: Router, private loguser: LogUser) { }



  application():void {
    this.router.navigate(['/application/' + this.loguser.userid])

  }

  home() : void{
    this.router.navigate(['/home'])
  }

  apply() : void{
    this.router.navigate(['/apply/' + this.loguser.userid])
  }

}
