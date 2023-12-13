import { Component,OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from '../sharedaccount/rest-api.service';


@Component({
  selector: 'app-account-create',
  templateUrl: './account-create.component.html',
  styleUrls: ['./account-create.component.scss']
})
export class AccountCreateComponent implements OnInit{
  @Input() accountDetails = { accountId: '', accountType: '', accountBalance: '',secretePassword: '', userId:''};

constructor(public restApi: RestApiService, public router: Router) {}

  ngOnInit() {
    
  }

  addAccount(data: any) {
    this.restApi.createAccount(this.accountDetails).subscribe((data: {}) => {
    
    alert("Account added successfully !")
    });
  }
}
   