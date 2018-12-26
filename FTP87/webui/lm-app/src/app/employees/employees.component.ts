import { Component, OnInit } from '@angular/core';
import { Observable } from '../../../node_modules/rxjs';
import { Employees } from '../employees';
import { EmployeesService } from '../employees.service';
import { ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  employees : Observable<Employees[]>;
  empMgrid: number;
  empId:number;
  emps:Employees[] = [];
  public searchText : string;
  public customerData : any;
  empName: string;

  constructor(private employeesService : EmployeesService, private router : Router, private route :ActivatedRoute) { 
    this.employees = employeesService.getEmployees();

     this.empId=parseInt(this.route.snapshot.params["empId"]);
     this.employees = employeesService.getEmployees();
    this.employeesService.getEmployees().subscribe(emp => this.emps = emp);
 
  }
  mgrId : number;
  show(eid,mid,empName) {
    this.empId=eid;
    this.mgrId=mid;
    this.empName=empName;
    localStorage.setItem("empId",eid);
    localStorage.setItem("mgrId",mid);
    localStorage.setItem("empName",empName);
  this.router.navigate(["/Login"]);
  }

  ngOnInit() {
    this.customerData=this.employeesService.getEmployees();
  }


}
