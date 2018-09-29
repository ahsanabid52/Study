import { Component, OnInit } from '@angular/core';

@Component({
  // selector: 'app-servers',  
  selector: 'app-servers',
  // selector: '[app-servers]',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {
 allowNewServer = false;
 serverCreationStatus="No Server is created.";
 serverName='';
 serverCreated = false;
 servers = ["Dev","QA"]; 
 constructor()
    { 
      setTimeout(() => {
      this.allowNewServer=true;
    }, 3000);
   }

  ngOnInit() {
  }

  onCreateServer(){
    this.serverCreated = true;
    this.servers.push(this.serverName);
    this.serverCreationStatus = "Server was created. Server Name is :- "+ this.serverName;
  }

  onUpdateServerName(event: Event){
    this.serverName = (<HTMLInputElement>event.target).value;
    console.log(event);
  }
}
