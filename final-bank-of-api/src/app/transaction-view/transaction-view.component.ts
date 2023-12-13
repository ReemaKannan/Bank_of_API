import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RestApiService } from '../sharedTransaction/rest-api.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-transaction-view',
  templateUrl: './transaction-view.component.html',
  styleUrls: ['./transaction-view.component.scss']
})
export class TransactionViewComponent implements OnInit {
  Transaction: any = [];
  

  constructor(public restApi: RestApiService,public router: Router) {}

  ngOnInit() {
    //this.loadTransactions();
  }
  displayTransaction() {
    
    let id=localStorage.getItem("userId")
    this.restApi.getTransactionByUserId(id).subscribe((data: {}) => {
      this.Transaction = data;
      console.log(data) 
      //this.router.navigateByUrl('/transaction-view');
    });
  }
  
}
