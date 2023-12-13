import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiserviceService } from '../shared/apiservice.service';
import { User } from '../shared/user';

@Component({
  selector: 'app-sign-up-page',
  templateUrl: './sign-up-page.component.html',
  styleUrls: ['./sign-up-page.component.scss']
})
export class SignUpPageComponent implements OnInit{
  user=new User();
  msg='';

  constructor(private service:ApiserviceService,private router:Router){}

  ngOnInit(): void {
    
  }

  registerUser(){
    this.service.RegisterUserFromRemote(this.user).subscribe(
      data=>{
        console.log("response received");
        alert("Registration successful");
        this.router.navigate(['/login-page'])

  },
      
    )
  }

}
