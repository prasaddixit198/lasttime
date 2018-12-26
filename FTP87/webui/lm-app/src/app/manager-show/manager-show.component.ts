import { Component, OnInit } from '@angular/core';
import { Observable } from '../../../node_modules/rxjs';
import { Employees } from '../employees';
import { EmployeesService } from '../employees.service';
import { ActivatedRoute } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-manager-show',
  templateUrl: './manager-show.component.html',
  styleUrls: ['./manager-show.component.css']
})
export class ManagerShowComponent implements OnInit {
  employees: Observable<Employees>;
  empMgrid : number;
  emps2:Employees;
  constructor(private employeesService : EmployeesService, private route:ActivatedRoute) {
    this.empMgrid=this.route.snapshot.params["empMgrid"]
    localStorage.setItem("empMgrid",this.route.snapshot.params["empMgrid"]);
    alert(this.empMgrid);
    this.employees = employeesService.showEmploy(this.empMgrid);
    this.employeesService.showEmploy(this.empMgrid).subscribe(emp => this.emps2 = emp);
   }


  ngOnInit() {
  }

}
