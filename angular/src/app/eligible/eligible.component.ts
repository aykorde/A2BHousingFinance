import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Options, LabelType } from 'ng5-slider';
import { LogUser } from '../loginservice.service';

@Component({
  selector: 'app-eligible',
  templateUrl: './eligible.component.html',
  styleUrls: ['./eligible.component.css']
})
// export class EligibleComponent implements OnInit {

//   constructor() { }

//   ngOnInit(): void {
//   }

// }
export class EligibleComponent implements AfterViewInit {
  filters: any;

  memi = {
    value: "240"
  }

  query = {
    tenureMo: '0'
  }

  result = {
    emi: '0'
  }

  moptions: Options = {
    floor: 1,
    ceil: 200,
    translate: (value: number, label: LabelType): string => {
      switch (label) {
        case LabelType.Low:
          return value + '<b>K</b>';
        case LabelType.High:
          return value + '<b>L</b>';
        default:
          return value + '<b>K</b>';
      }
    }
  };


  constructor(private router: Router, private loguser: LogUser) { }

  ngAfterViewInit() {
    //this.update();
  }

  tbupdate(id) {
    if (id == 3) {
      this.memi.value = this.query.tenureMo;
    }
    this.update();
  }
  update() {


    var numberOfMonths = Number(this.memi.value);
    this.query.tenureMo = this.memi.value.toString();

    var emi = 60 * (0.6 * numberOfMonths);

    this.result.emi = emi.toFixed(0).toString().replace(/,/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"K";
  }


  title = 'homeloan';
  isShow = false;
 
  toggleDisplay() {
    this.isShow = !this.isShow;
}


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
