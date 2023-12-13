import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from '../sharedTransaction/rest-api.service';

@Component({
  selector: 'app-transaction-add',
  templateUrl: './transaction-add.component.html',
  styleUrls: ['./transaction-add.component.scss']
})
export class TransactionAddComponent implements OnInit {
 @Input() transaction = { transactionId: '', fromAccountId: '', transactionType: '',toAccountId: '', amount: '',userId:'',};
  
 constructor(public restApi: RestApiService, public router: Router) {}

  ngOnInit() {}

  newTransaction(dataTransaction: any) {
    this.restApi.addTransaction(this.transaction).subscribe((data: {}) => {
      this.router.navigate(['/transaction-view']);
    });
  }
}
