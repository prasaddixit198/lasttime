import { Component, OnInit } from '@angular/core';

import { NgForm } from "@angular/forms";
import { Router } from '@angular/router';
import { LeaveDetails } from '../leave-details';
import { EmployeesService } from '../employees.service';

@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css']
})
export class ApplyLeaveComponent implements OnInit {

  constructor(public applyLeaveService:EmployeesService, public router : Router) {
    this.empId=parseInt(localStorage.getItem("empId"));
    this.empMgrid=parseInt(localStorage.getItem("empMgrid"));
    alert(this.empId);
    alert(this.empMgrid);
   }
  model=new LeaveDetails();
  message:string;
  msg:String;
  empId : number;
  empMgrid: number;
  isValidFormSubmitted = false;
  calculateDays() {
    let date1: string=this.model.leavesdate.toString();
    let date2: string=this.model.leaveedate.toString();
    let diffInMs: number = Date.parse(date2) - Date.parse(date1);
    let diffInHours: number = diffInMs / 1000 / 60 / 60/24;
    this.model.leavendays=diffInHours + 1;

}

applyLeave(form: NgForm)
{
  alert("Applying...");
    this.isValidFormSubmitted=false;
    if(form.invalid){
   //     alert("Invalid");
     return; 
  }  
    console.log ('end date component' + this.model.leaveedate);
    this.applyLeaveService.applyLeave(this.model,this.empId).subscribe(
        success => {
            this.msg=success;
        },
        err => { 
            this.msg=err;
            console.log(err);
        }
    )
    this.isValidFormSubmitted = true;
}
cancel(){

  this.router.navigate(["/"]);
  
}
  ngOnInit() {
  }

}
