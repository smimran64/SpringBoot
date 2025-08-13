import { NgModule, provideBrowserGlobalErrorListeners, provideZonelessChangeDetection } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { AddlocationComponent } from './location/addlocation-component/addlocation-component';
import { Viewalllocation } from './location/viewalllocation/viewalllocation';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { EditLocationComponent } from './location/edit-location-component/edit-location-component';
import { AddhotelComponent } from './hotel/addhotel-component/addhotel-component';
import { Viewallhotelcomponent } from './hotel/viewallhotelcomponent/viewallhotelcomponent';
import { CustomerRegComponent } from './customer/customer-reg-component/customer-reg-component';
import { Viewcustomercomponent } from './customer/viewcustomercomponent/viewcustomercomponent';
import { Navbar } from './layout/navbar/navbar';
import { Footer } from './layout/footer/footer';
import { AboutHotel } from './layout/about-hotel/about-hotel';
import { Login } from './auth/login/login';
import { Logout } from './auth/logout/logout';
import { HotelAdminRegComponent } from './hotelAdmin/hotel-admin-reg-component/hotel-admin-reg-component';
import { ViewAllHotelAdmin } from './hotelAdmin/view-all-hotel-admin/view-all-hotel-admin';

@NgModule({
  declarations: [
    App,
    AddlocationComponent,
    Viewalllocation,
    EditLocationComponent,
    AddhotelComponent,
    Viewallhotelcomponent,
    CustomerRegComponent,
    Viewcustomercomponent,
    Navbar,
    Footer,
    AboutHotel,
    Login,
    Logout,
    HotelAdminRegComponent,
    ViewAllHotelAdmin
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZonelessChangeDetection(),
    provideClientHydration(withEventReplay()),
    provideHttpClient(
      withFetch()
    )
  ],
  bootstrap: [App]
})
export class AppModule { }
