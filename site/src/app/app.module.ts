import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PrelevementComponent } from './prelevement/prelevement.component';
import { FormsModule } from '@angular/forms';
import { FeedbackComponent } from './feedback/feedback.component';
import { ResultatComponent } from './resultat/resultat.component';
import { CreationComponent } from './creation/creation.component';
import {HttpClientModule} from '@angular/common/http'
import { Routes,RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
const appRoutes:Routes=[{path:'Creation',component:CreationComponent},{path:'prelevement',component:PrelevementComponent},
{path:'Resultat',component:ResultatComponent},{path:'creation',component:CreationComponent},{path:'login',component:LoginComponent},{path:'feedback',component:FeedbackComponent}]
@NgModule({
  declarations: [
    AppComponent,
    PrelevementComponent,
    FeedbackComponent,
    ResultatComponent,
    CreationComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,FormsModule,HttpClientModule,RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
