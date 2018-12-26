import { Component, OnInit } from '@angular/core';
import { Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  applyLeave(){
  this.router.navigate(["/ApplyLeave"]);
}

cancel() {
  this.router.navigate(['/']);
}
  constructor(public router : Router) {}

  ngOnInit() {
  }

}
