import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlluserComponent } from './user/alluser.component/alluser.component';
import { AddjobseekerComponent } from './jobseeker/addjobseeker.component/addjobseeker.component';
import { LoginComponent } from './auth/login.component/login.component';
import { Jobseekerprofilecomponent } from './jobseeker/jobseekerprofilecomponent/jobseekerprofilecomponent';

const routes: Routes = [

  { path: '', component: AlluserComponent },
  { path: 'jobseeker', component: AddjobseekerComponent },
  { path: 'login', component: LoginComponent },
  { path: 'jobsekpro', component: Jobseekerprofilecomponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
