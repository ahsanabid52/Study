import { Component, OnInit } from '@angular/core';
import { AccountsService } from './accounts.service';
import { LoggingService } from './logging.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  accounts: { name: string, status: string }[];

  constructor(private accountsService: AccountsService, private loggingService: LoggingService) {
  }

  ngOnInit() {
    this.accounts = this.accountsService.accounts;
    this.loggingService.logString("ngOnInit is called");
  }

  onAccountAdded(newAccount: { name: string, status: string }) {
    this.loggingService.logString("new account pushed with name :- " + name);
    this.accounts.push(newAccount);
  }

  onStatusChanged(updateInfo: { id: number, newStatus: string }) {
    this.loggingService.logStatusChange(status);
    this.accounts[updateInfo.id].status = updateInfo.newStatus;
  }
}