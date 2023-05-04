import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-prelevement',
  templateUrl: './prelevement.component.html',
  styleUrls: ['./prelevement.component.css']
})
export class PrelevementComponent {
  @ViewChild('f') Signupfrom: NgForm | undefined;


  onSubmit(){
  
  console.log(this.Signupfrom)
}
}
