import {Component, NgModule} from '@angular/core';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';

@NgModule({
    imports: [MatButtonModule, MatCheckboxModule],
})

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
}
