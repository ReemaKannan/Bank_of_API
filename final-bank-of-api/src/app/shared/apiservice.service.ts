import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class ApiserviceService {

  constructor(private http:HttpClient) { }

  public loginUserFromRemote(user:User):Observable<any>{
    return this.http.post<any>("http://localhost:5007/auth/login",user)
 }
 public RegisterUserFromRemote(user:User):Observable<any>{
   return this.http.post<any>("http://localhost:5007/registeruser",user)
}

public getloginuser():Observable<any>{
  return this.http.get<any>("http://localhost:5007/userid/"+localStorage.getItem("userId"))
}
public edit(user:User):Observable<any>{
  return this.http.put<any>("http://localhost:5007/edituserdetails/",user);
}

}
