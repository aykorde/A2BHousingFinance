import {HttpClient, HttpClientModule} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserapplicationserviceService {

  constructor(private http: HttpClient) { }

  getapprove1() : Observable<any>{
    return this.http.get('http://localhost:8089/homeloan/admin/getallsfaapplication');
  }

  getapprove2() : Observable<any>{
    return this.http.get('http://localhost:8089/homeloan/admin/getallvsfaapplication');
  }

  approve1(appid: String) : Observable<any>{
    return this.http.get('http://localhost:8089/homeloan/admin/approve1/'+appid+'/', {responseType: 'text' });
  }

  approve2(appid: String) : Observable<any>{
    return this.http.get('http://localhost:8089/homeloan/admin/approve2/'+appid+'/', {responseType: 'text' });
  }

  reject(appid:String) : Observable<any>{
    return this.http.get('http://localhost:8089/homeloan/admin/reject/'+appid+'/', {responseType: 'text' });
  }
  
}
