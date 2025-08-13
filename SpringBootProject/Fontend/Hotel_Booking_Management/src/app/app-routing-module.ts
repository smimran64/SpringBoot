import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddlocationComponent } from './location/addlocation-component/addlocation-component';
import { Viewalllocation } from './location/viewalllocation/viewalllocation';
import { EditLocationComponent } from './location/edit-location-component/edit-location-component';
import { CustomerRegComponent } from './customer/customer-reg-component/customer-reg-component';
import { Login } from './auth/login/login';
import { HotelAdminRegComponent } from './hotelAdmin/hotel-admin-reg-component/hotel-admin-reg-component';
import { AddhotelComponent } from './hotel/addhotel-component/addhotel-component';
import { Viewallhotelcomponent } from './hotel/viewallhotelcomponent/viewallhotelcomponent';

const routes: Routes = [
  {path: 'addlocation', component: AddlocationComponent},
  {path: '', component: Viewalllocation},
  {path: 'editlocation/:id', component: EditLocationComponent},
  {path: 'addhotel', component: AddhotelComponent},
  {path: 'viewHotel', component: Viewallhotelcomponent},
  {path: 'customerReg', component: CustomerRegComponent},
  {path: 'hotelAdminReg', component: HotelAdminRegComponent},
  {path: 'login', component: Login},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
