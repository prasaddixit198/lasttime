import { Injectable } from '@angular/core';
import { Observable } from '../../node_modules/rxjs';
import {Http, Response} from '@angular/http';
import {Employees} from './employees';
import 'rxjs/add/operator/map';
import { LeaveDetails } from './leave-details';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {

  applyLeave(leavedetails:LeaveDetails,empid : number):Observable<String>{
    return this.http.post('http://localhost:8080/ftp87/api/leavedetails/applyleave/' +empid,leavedetails)
     .map(response=>response.text()) 
   }
  constructor(private http: Http) { }
  getEmployees():Observable<Employees[]>{
    return this.http.get("http://localhost:8080/ftp87/api/employees").map((res : Response) => res.json());
  }
  showEmploy(empId):Observable<Employees>{
    return this.http.get("http://localhost:8080/ftp87/api/employees/" +empId).map((res : Response) => res.json());
  }
  showPending(empMgrid):Observable<LeaveDetails[]>{
    return this.http.get("http://localhost:8080/ftp87/api/leavedetails/pending/" +empMgrid).map((res : Response) => res.json());
  }
  approveDeny(leavedetails:LeaveDetails,leaveid : number):Observable<string>{
    return this.http.post('http://localhost:8080/ftp87/api/leavedetails/Ad/' +leaveid,leavedetails) .map(response=>response.text())
  }
  getLeave(leaveid):Observable<LeaveDetails>{
    return this.http.get("http://localhost:8080/ftp87/api/leavedetails/" +leaveid).map((res : Response) => res.json());
  }
  emphistory(empId):Observable<LeaveDetails[]>{
    return this.http.get("http://localhost:8080/ftp87/api/leavedetails/history/" +empId).map((res : Response) => res.json());
  }

}
