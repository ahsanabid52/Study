
import { Component } from "@angular/core";

@Component({
    selector:'app-server',
    templateUrl:'./server.component.html',
    styles:[`
    .online{
        color:white
    }
    `]
})
export class ServerComponent{
    serverId:number=10;
    serverStatus:String="";

    constructor(){
        this.serverStatus = Math.random() > 0.5? "Offline" : "Online";
    }
    getServerStatus(){
        return this.serverStatus;
    }
    
    getColor(){
        return this.serverStatus === "Offline" ? "red" : "green"; 
    }
}