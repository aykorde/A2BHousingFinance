import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LoginserviceService, LogUser } from '../loginservice.service';
import { Login, User, Admin } from './login';
import { ReactiveFormsModule } from '@angular/forms'
import { RouterModule, RouterOutlet, Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isShow1 = false;
 
  toggleDisplay() {
    this.isShow1 = !this.isShow1;
}
  newuserform:FormGroup;  
  loginform: FormGroup;
  adminloginform: FormGroup;
  login:Login;
  user: User;
  admin: Admin;

  constructor(private loginService: LoginserviceService,private router: Router,private activated : ActivatedRoute, private loguser: LogUser) { }
  ngOnInit(): void {
    this.newuserform = new FormGroup({
      first_name: new FormControl(),
      middle_name: new FormControl(),
      last_name: new FormControl(),
      email: new FormControl(),
      password: new FormControl(),
      phonenumber: new FormControl(),
      dob: new FormControl(),
      gender: new FormControl(),
      nationality: new FormControl(),
      aadharcard: new FormControl(),
      pancard: new FormControl(),
    })

    this.loginform= new FormGroup({
      email: new FormControl(''),
      password: new FormControl('')
    })

    this.adminloginform= new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    })
  }

  saveuser():void{
    
    this.user = this.newuserform.value;
    this.loginService.save(this.user).subscribe((data)=>{
      console.log(data);
      if(data =="saved"){
        this.router.navigate(['/login']);
        document.getElementById("home-tab").click();

      }
    });
  }

  verifyuser():void{
    this.login = this.loginform.value;
    this.loginService.login(this.login).subscribe((data)=>{
      console.log(data);
      if(data > 0){
        this.loguser.logged = true;
        this.loguser.userid = data;
        if(this.loguser.logged){
        this.router.navigate(['/home']);
          
        }
      }
    });
  }

  verifyadmin():void{
    this.admin = this.adminloginform.value;
    this.loginService.admin(this.admin).subscribe((data)=>{
      console.log(data);
      if(data =="valid"){
        this.loguser.logged=true;
        this.router.navigate(['/login/admin']);
      }
    });
  

  }
}
