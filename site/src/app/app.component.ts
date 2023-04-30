import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'site';
  dropped=false;
dropped2=false;

  drop(){
this.dropped=!this.dropped;
this.dropped2=!this.dropped2;
}
}
