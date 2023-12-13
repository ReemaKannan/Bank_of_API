import { Component, OnInit } from '@angular/core';
import { RestApiService } from '../sharedaccount/rest-api.service';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.scss']
})
export class AccountListComponent implements OnInit {
  Account: any = [];

  constructor(public restApi: RestApiService) {}

  ngOnInit() {
    //this.loadAccounts();
  }

  // Get account list
  // loadAccounts() {
  //   return this.restApi.getAccounts().subscribe((data: {}) => {
  //     this.Account = data;
  //   });
  // }

  displayAccount() {
    let id = localStorage.getItem("userId")
    this.restApi.getAccountByUserId(id).subscribe((data: {}) => {
      this.Account = data;
      console.log(data)
      
    });
}
}
