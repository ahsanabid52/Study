import { LoggingService } from "./logging.service";
import { Injectable, EventEmitter } from "@angular/core";

@Injectable()
export class AccountsService {
    statusUpdated = new EventEmitter<string>();

    constructor(private loggingService: LoggingService) {
    }

    accounts = [{
        name: 'Master Account', status: 'active'
    }
    ];

    addAccount(newName: string, newStatus: string) {
        this.accounts.push({ name: newName, status: newStatus })
        this.loggingService.logString("New Account is created :- " + newName);
    }

    updateStatus(id: number, newStatus: string) {
        this.accounts[id].status = newStatus;
        this.loggingService.logStatusChange(newStatus);
    }
}