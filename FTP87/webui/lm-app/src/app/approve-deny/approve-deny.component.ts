import { Component, OnInit } from '@angular/core';
import { LeaveDetails } from '../leave-details';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { EmployeesService } from '../employees.service';
import { Employees } from '../employees';

@Component({
  selector: 'app-approve-deny',
  templateUrl: './approve-deny.component.html',
  styleUrls: ['./approve-deny.component.css']
})
export class ApproveDenyComponent implements OnInit {
  
  employees : Observable<Employees>;
  leavedetails : Observable<LeaveDetails>;
  empId : number;
  leaveid:number;
  empMgrid : number;
  msg : String;
  constructor(public employeesService:EmployeesService, public router : Router) {
    this.empId=parseInt(localStorage.getItem("empId"));
    this.empMgrid=parseInt(localStorage.getItem("empMgrid"));

    this.employees=employeesService.showEmploy(this.empId);

    this.leaveid=parseInt(localStorage.getItem("leaveid"));
    this.leavedetails=employeesService.getLeave(this.leaveid);
   }
  ld = new LeaveDetails(); 

  approve() {
    this.ld.leaveid=parseInt(localStorage.getItem("leaveid")); 
    this.ld.leavestatus="APPROVED"; 
    this.ld.empid=this.empMgrid;

    this.employeesService.approveDeny(this.ld,this.leaveid).subscribe(
        success => {
            this.msg=success;
        },
        err => { 
            this.msg=err;
            console.log(err);
        }
    )
  }
  reject() {
    this.ld.leaveid=parseInt(localStorage.getItem("leaveid")); 
    this.ld.leavestatus="DENIED"; 
    this.ld.empid=this.empMgrid;
    this.empMgrid=parseInt(localStorage.getItem("empMgrid"));

    this.employeesService.approveDeny(this.ld,this.leaveid).subscribe(
        success => {
            this.msg=success;
        },
        err => { 
            this.msg=err;
            console.log(err);
        }
    )
  }
  cancel(){
    this.router.navigate(['/']);
  }
  ngOnInit() {
  }

}