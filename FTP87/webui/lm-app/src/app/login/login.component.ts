import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { Router } from '@angular/router';
import { trigger, state, style, transition, animate } from '@angular/animations';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  styles:[`
  div{
     margin: 0 auto;
     text-align: center;
     align: center;
     width:200px;
  }
  .rotate{
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 500px;
    //  width:200px;
    //  height:200px;
  }
`],
animations: [
  trigger('myanimation',[
     state('smaller',style({
        transform : 'translateY(500px)'
     })),
     state('larger',style({
        transform : 'translateY(500px)'
     })),
     transition('smaller <=> larger',animate('100ms ease-in'))
  ])
]
})
export class LoginComponent implements OnInit {
  model = new Login();
  empId: number;
  empMgrid: number;
  psw:string;
 empName :string;
  constructor(private router :Router) { 
    this.empId=parseInt(localStorage.getItem("empId"));
    this.empMgrid=parseInt(localStorage.getItem("mgrId"));
    this.empName=localStorage.getItem("empName");
    this.model.username=localStorage.getItem("empId");
   }
login() {

if (this.psw =="ftp87"){
  alert(this.empId);
  this.router.navigate(["/Dashboard",this.empId,this.empMgrid]);
}else{
  alert("enter password");
}

}
  ngOnInit() {
  }

}
