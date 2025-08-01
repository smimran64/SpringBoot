import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlluserComponent } from './user/alluser.component/alluser.component';
import { AddjobseekerComponent } from './jobseeker/addjobseeker.component/addjobseeker.component';

const routes: Routes = [

  { path: '', component: AlluserComponent },
  { path: 'jobseeker', component: AddjobseekerComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
