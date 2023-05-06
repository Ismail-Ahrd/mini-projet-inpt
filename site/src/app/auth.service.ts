import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { USER } from './USER.model';
import { NgForm } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
interface datare{
  token:string;
  }
@Injectable({
  providedIn: 'root'
})

export class AuthService {
  
  constructor(private http:HttpClient,private router:Router ){

  }

  private ata!: Object;
  getBooleanValue() {
    return this.booleanValue.asObservable();
  }

  setBooleanValue(newValue: boolean) {
    this.booleanValue.next(newValue);
  }
  private booleanValue = new BehaviorSubject<boolean>(false);
  signup(form:NgForm){
    return  this.http.post('http://localhost:8080/authentication/register', form.value)
  

  }
 setdata(data:Object){
  this.ata=data;

 } 
 getdata(){
  return this.ata;
 }
}
