import { HttpClient, HttpRequest, HttpEvent} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Income, Loan } from './ApInterface';

@Injectable({
  providedIn: 'root'
})
export class ApplicationserviceService {
  

  constructor(private http: HttpClient) { }

  saveloan(loan: Loan, id : number): Observable<any>{
    return this.http.post('http://localhost:8089/homeloan/application/loan/'+id, loan, { responseType: 'text' });
  }

  saveincome(income: Income, id : number): Observable<any>{
    return this.http.post('http://localhost:8089/homeloan/application/income/'+id, income, { responseType: 'text' });
  }

  trackStatus(id: String): Observable<any>{
    return this.http.get('http://localhost:8089/homeloan/user/trackstatus/'+id, {responseType: 'json'});

  }

  generatechecklist(id: number): Observable<any>{
    return this.http.get('http://localhost:8089/homeloan/document/checklist/'+id, {responseType: 'json'});

  }

  applynow(id: number): Observable<any>{
    return this.http.get('http://localhost:8089/homeloan/user/applynow/'+id, {responseType: 'json'});
  }


  applyloan(id: number): Observable<any>{
    return this.http.get('http://localhost:8089/homeloan/user/applyloan/'+id, {responseType: 'text'});
  }

  getdocs(id: String): Observable<any>{
    return this.http.get('http://localhost:8089/homeloan/document/viewall/'+id, {responseType: 'json'});

  }
}