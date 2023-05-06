import { Injectable, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class SubService {
  @ViewChild('f') Signupfrom: NgForm | undefined;


  onSubmit(){
  
  console.log(this.Signupfrom)
}
  constructor() { }
}
