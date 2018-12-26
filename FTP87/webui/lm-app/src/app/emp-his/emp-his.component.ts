import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LeaveDetails } from '../leave-details';
import { EmployeesService } from '../employees.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-emp-his',
  templateUrl: './emp-his.component.html',
  styleUrls: ['./emp-his.component.css']
})
export class EmpHisComponent implements OnInit {

leavedetails:Observable<LeaveDetails[]>
empId: number;
emps:LeaveDetails[] = [];
  constructor(private employeesService : EmployeesService, private route:ActivatedRoute) {
    this.empId=parseInt(localStorage.getItem("empId"));
    this.leavedetails=employeesService.emphistory(this.empId);
    // this.employees = employeesService.emphistory();
    this.employeesService.emphistory(this.empId).subscribe(emp => this.emps = emp);
   }
  ngOnInit() {
  }

}
