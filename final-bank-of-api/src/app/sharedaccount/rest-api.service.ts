import { Injectable } from '@angular/core';
import { catchError, Observable, retry } from 'rxjs';
import { Account } from './account';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RestApiService {
 
  apiURL = 'http://localhost:8066';

  constructor(private http: HttpClient,private router:Router) {}

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  // HttpClient API get() method => Fetch account list
  getAccounts(): Observable<Account> {
    return this.http
      .get<Account>(this.apiURL + '/accountdb/')
  }

  // HttpClient API get() method => Fetch account
  getAccount(accountId: any): Observable<Account> {
    return this.http
      .get<Account>(this.apiURL + '/accountdb/' + accountId)
      .pipe(retry(1));
  }

  // HttpClient API post() method => Create account
  createAccount(account: any): Observable<Account> {
    console.log(account)
    return this.http
      .post<Account>(
        this.apiURL + '/accountdb/save',JSON.stringify(account),
        
        this.httpOptions )

  }

  getAccountByUserId(getAccountByUserId: any) : Observable<Account>{
    return this.http
    .get<Account>(this.apiURL + '/accountdb/byuserId/' + getAccountByUserId)
    .pipe(retry(1));
  }

  

  

  
}
