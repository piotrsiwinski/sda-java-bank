import {Component, NgModule} from '@angular/core';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {CanActivateViaAuthGuard} from "./common/activate-guard";

@NgModule({
    imports: [MatButtonModule, MatCheckboxModule],
})

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app';
  constructor(private activator: CanActivateViaAuthGuard){};

  canActivate(){
    this.activator.canActivate()
  }

}
