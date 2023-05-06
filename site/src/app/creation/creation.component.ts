import { HttpClient } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-creation',
  templateUrl: './creation.component.html',
  styleUrls: ['./creation.component.css']
})
export class CreationComponent {
  constructor(private auth:AuthService,private http: HttpClient,private router:Router) {

  }
  profession!: string;
  mdp!: string;
  cmdp!:string;

  onSubmit(f: NgForm) {
    console.log(f.value);

   this.auth.signup(f).subscribe(Response => {
    this.auth.setdata(Response);
    

  })
  this.router.navigate(['feedback'])    
    
  }
}
