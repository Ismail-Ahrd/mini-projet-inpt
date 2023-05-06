import { Component, ViewChild } from '@angular/core';
import { SubService } from '../sub.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-resultat',
  templateUrl: './resultat.component.html',
  styleUrls: ['./resultat.component.css'],
  providers:[SubService]
})
export class ResultatComponent {
  constructor(private sub:SubService){

  }
  @ViewChild('f') Signupfrom: NgForm | undefined;


  onSubmit(){
  
  console.log(this.Signupfrom)
}
  selected!: string;
 }

