import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login, User, Admin } from './login/login';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private http: HttpClient) { }

  save(user: User): Observable<any>{
    return this.http.post('http://localhost:8089/homeloan/register/saveuser', user, { responseType: 'text' });
  }

  login(login: Login): Observable<any>{
    return this.http.post('http://localhost:8089/homeloan/login/verifyuser', login, { responseType: 'text' });
  }

  admin(admin: Admin): Observable<any>{
    return this.http.post('http://localhost:8089/homeloan/login/verifyadmin', admin, { responseType: 'text' });
  }

  forgetpassword(email:string): Observable<any>{
    return this.http.get('http://localhost:8089/homeloan/login/forgetpassword/'+email+'/', {responseType: 'text' });
  }

 
}

@Injectable()
export class LogUser {
  logged = false;
  userid: number;
}
