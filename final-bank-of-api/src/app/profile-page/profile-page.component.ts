import { Component, OnInit } from '@angular/core';
import { User } from '../shared/user';
import {HttpClient} from '@angular/common/http';
import {  Router } from '@angular/router';
import { ApiserviceService } from '../shared/apiservice.service';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.scss']
})
export class ProfilePageComponent implements OnInit{
    user: Array<User>=[];
    msg="";
    id:any;
    users=new User();
  update={
  userId:"",
    userName:"",
    userPassword:"",
    address:""
};
    constructor( public router: Router, 
      private service:ApiserviceService,
      private http:HttpClient) {}
    ngOnInit() {
      //this.display();
    }
    display() {

      let id=localStorage.getItem("userId")
      this.service.getloginuser().subscribe((data) => {
        this.users = data;
        console.log(this.users)
        //this.router.navigateByUrl('/transaction-view');
      });
    } 
    Edit(User:{userId:string;userName:string;userPassword:string;address:string}){
      this.update=User;
    }
    editUser(){
      this.service.edit(this.users).subscribe(
        data=>{
          console.log("response received");
          alert("Updated Successfully");
        }
      )
    }
   
  }