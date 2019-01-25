import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit, OnDestroy {
  user: { id: number, name: string };
  paramsSubscription: Subscription;
  constructor(private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.user = {
      id: this.route.snapshot.params['id'],
      name: this.route.snapshot.params['name']
    };
    // using observable to update the template
    // if you are on the same component use the observable approach.
    this.route.params.subscribe(
      (param: Params) => {
        this.user.id = param.id;
        this.user.name = param.name;
      }
    );



  }

  ngOnDestroy() {
    // need to unsubscribe in case you have implemented your own obsevable
    // angular will unsubscribe its own obervables by default
    // this.paramsSubscription.unsubscribe();
  }

}
