import { Component } from '@angular/core';
import { AuthService } from './auth.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  log: boolean | undefined;
  constructor(private auth :AuthService){
  this.auth.getBooleanValue().subscribe(value =>{
    this.log=value;
  })
 }
  title = 'site';
  dropped=false;
dropped2=false;
  status=false;

  drop(){
this.dropped=!this.dropped;
this.dropped2=!this.dropped2;
this.status=false;
}
}
