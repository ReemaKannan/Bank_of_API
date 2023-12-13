import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { User } from '../shared/user';
import { Transactiondata } from './transactiondata';

@Injectable({
  providedIn: 'root'
})
export class RestApiService {
  apiURL = 'http://localhost:8081';
  Transactions: any

  constructor(private http: HttpClient) { }

  public  loginUserFromRemote(user:User):Observable<any>{
    return this.http.post<any>("http://localhost:8081/login",user)
  }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  getTransactions(): Observable<any> {
    return this.http
      .get<any>("http://localhost:8081/transaction/")
      .pipe(retry(1));
  }

  getTransactionByTransactionId(transactionid: any): Observable<Transactiondata> {
    return this.http
      .get<Transactiondata>(this.apiURL + '/transaction/' + transactionid)
      .pipe(retry(1));
  }

  getTransactionByUserId(getTransactionByUserId: any) : Observable<any>{
    return this.http
    .get<any>("http://localhost:8081/transaction/byUserId/" + getTransactionByUserId)


    .pipe(retry(1));
  }

  addTransaction(transaction: any): Observable<Transactiondata> {
    console.log(transaction.update)
    return this.http
      .post<Transactiondata>(
        this.apiURL + '/transaction/save',
        JSON.stringify(transaction),
        this.httpOptions
      )
      .pipe(retry(1));

  }

  updateTransaction(id: any, transaction: any): Observable<Transactiondata> {
    return this.http
      .put<Transactiondata>(
        this.apiURL + '/transaction/' + id,
        JSON.stringify(transaction),
        this.httpOptions
      )
      .pipe(retry(1));
  }
    
  

    
}

