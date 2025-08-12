import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddlocationComponent } from './location/addlocation-component/addlocation-component';
import { Viewalllocation } from './location/viewalllocation/viewalllocation';
import { EditLocationComponent } from './location/edit-location-component/edit-location-component';
import { CustomerRegComponent } from './customer/customer-reg-component/customer-reg-component';

const routes: Routes = [
  {path: 'addlocation', component: AddlocationComponent},
  {path: 'locations', component: Viewalllocation},
  {path: 'editlocation/:id', component: EditLocationComponent},
  {path: 'customerReg', component: CustomerRegComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
