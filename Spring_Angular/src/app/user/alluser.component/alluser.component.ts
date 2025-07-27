import { Component, OnInit } from '@angular/core';
import { User,} from '../../model/user.model';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-alluser.component',
  standalone: false,
  templateUrl: './alluser.component.html',
  styleUrl: './alluser.component.css'
})
export class AlluserComponent implements OnInit {


  users: User[] = [];


  constructor(
    private userService: UserService
  ) { }

  ngOnInit(): void {

    this.loadUsers();
  }


 

  loadUsers(): void {
    this.userService.getAllUsers().subscribe({
      next: (data) => {
        console.log("User data loaded:", data); 
        this.users = data;
      },
      error: (err) => {
        console.error("Error fetching users", err);
      }
    });
  }

}

