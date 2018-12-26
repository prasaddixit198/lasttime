import { Component, OnInit } from '@angular/core';
import { LeaveDetails } from '../leave-details';
import { Observable } from '../../../node_modules/rxjs';
import { EmployeesService } from '../employees.service';
import { ActivatedRoute, Router} from '@angular/router';
import { Employees } from '../employees';

@Component({
  selector: 'app-pending-leaves',
  templateUrl: './pending-leaves.component.html',
  styleUrls: ['./pending-leaves.component.css']
})
export class PendingLeavesComponent implements OnInit {
  leavedetails: Observable<LeaveDetails[]>;
  empMgrid :number;
  employees : Observable<Employees[]>
  empId :number;
  mp :number;
// mp1:number;
  empId1 :number;
  leaveid:number;
  showButton:boolean=false;
  emps:LeaveDetails[] = [];
  public searchText : string;
  public customerData : any;
  
  constructor(private employeesService : EmployeesService,private route:ActivatedRoute, private routes:Router) { 
    this.employees = employeesService.getEmployees();
    this.empId=parseInt(this.route.snapshot.params["empId"]);
   localStorage.setItem("empId",this.route.snapshot.params["empId"]);
   localStorage.setItem("empMgrid",this.route.snapshot.params["empId"]);
    this.leavedetails = employeesService.showPending(this.empId);
    this.empId1=parseInt(this.route.snapshot.params["empId"]);
    localStorage.setItem("leaveid",this.route.snapshot.params["leaveid"]);
    this.employeesService.showPending(this.empMgrid).subscribe(emp => this.emps = emp);
    this.mp=parseInt(this.route.snapshot.params["empId"]);
    // this.mp1=parseInt(this.route.snapshot.params["empId"]);
  }
  clickRow(x,e) {
    this.leaveid=x.leaveid; 
  
    localStorage.setItem("leaveid",x.leaveid); 

    localStorage.setItem("empId",e.empId);
    this.showButton=true;

  }
  cancel(){
    this.routes.navigate(["/"]);
  }
  doApproveDeny() { 
    this.routes.navigate(["/approve"]);
  }
  ngOnInit() {
    this.customerData=this.employeesService.showPending(this.empMgrid);
  }

}
