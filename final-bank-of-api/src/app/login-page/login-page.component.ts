import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {  Router } from '@angular/router';
import { ApiserviceService } from '../shared/apiservice.service';
import { User } from '../shared/user';
@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit{
  user=new User();
  msg='';

  constructor(private service:ApiserviceService,private router:Router){}

  ngOnInit(): void {
    
  }

  loginUser(){
    this.service.loginUserFromRemote(this.user).subscribe(
      data=>{
        console.log("response received")
        alert("login Success");
        this.router.navigate(['/dashboard-page'])
        localStorage.setItem("userId",this.user.userId+"");
  },
      error=>{
        console.log("exception occured");
        this.msg="Bad credentials,Please enter valid username and userpassword";     
    }
    )
  }
  gotoregistration(){
    this.router.navigate(['/sign-up-page'])
  }

}
