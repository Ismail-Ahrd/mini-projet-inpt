import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

constructor(private auth :AuthService,private http: HttpClient,private router:Router,){

}
onSubmit(f: NgForm) {
  console.log(f.value);
  this.http.post('http://localhost:8080/authentication/authenticate',f.value).subscribe(Response=> {
    console.log("sent")
    
  })
  this.auth.setBooleanValue(true);
  
}
  change(){}

}
