import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Customer } from '../../model/customer.model';
import { Customerservice } from '../../service/customerservice';

@Component({
  selector: 'app-customer-profile-component',
  standalone: false,
  templateUrl: './customer-profile-component.html',
  styleUrl: './customer-profile-component.css'
})
export class CustomerProfileComponent  implements OnInit {

  customer?: Customer;


  constructor(

    private customerService: Customerservice,
    private cdr: ChangeDetectorRef
  ) { }
  ngOnInit(): void {
    this.customerService.getProfile().subscribe({

      next:(data) => {

        this.customer = data;
        console.log(data);

        this.cdr.markForCheck();
      },
      error: (err) => {
        console.error('Failed to fetch customer profile', err);
      }
    });
  }

}
