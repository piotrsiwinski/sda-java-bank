import {Component, OnInit} from '@angular/core';
import {AlertService} from "../_services/alert.service";


@Component({
  selector: 'alert',
  templateUrl: 'alert-component.html'
})
export class AlertComponentDirective implements OnInit {
 private message: string;
  constructor(private alertService: AlertService) {
  }

  ngOnInit() {
    this.alertService.getMessage().subscribe(message => {
      this.message = message;
    });
  }

}
