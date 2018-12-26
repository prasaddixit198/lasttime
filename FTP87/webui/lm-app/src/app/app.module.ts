import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { MatTableModule } from '@angular/material/table'
import { AppComponent } from './app.component';
import { EmployeesService } from './employees.service';
import { EmployeesComponent } from './employees/employees.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RouterModule, Routes} from '@angular/router';
import { GrdFilterPipe } from './grd-filter.pipe';
import { EmployShowComponent } from './employ-show/employ-show.component';
import { ManagerShowComponent } from './manager-show/manager-show.component';
import { ApplyLeaveComponent } from './apply-leave/apply-leave.component';
import { FormsModule } from '../../node_modules/@angular/forms';
import { PendingLeavesComponent } from './pending-leaves/pending-leaves.component';
import { ApproveDenyComponent } from './approve-deny/approve-deny.component';
import { LoginComponent } from './login/login.component';
import { EmpHisComponent } from './emp-his/emp-his.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

const appRoutes: Routes = [
  {path: 'approve', component: ApproveDenyComponent},
  {path: 'Dashboard/:empId/:empMgrid', component: DashboardComponent},
  {path: 'Login', component: LoginComponent},
  {path: 'EmployShow/:empId', component: EmployShowComponent},
  {path: 'ManagerShow/:empMgrid', component: ManagerShowComponent},
  {path: 'ApplyLeave', component: ApplyLeaveComponent},
  {path: 'ApproveDeny', component: ApproveDenyComponent},
  {path: '', component: EmployeesComponent}
] ;
@NgModule({
  declarations: [
    AppComponent,
    EmployeesComponent,
    DashboardComponent,
    EmployShowComponent,
    ManagerShowComponent,
    ApplyLeaveComponent,
    PendingLeavesComponent,
    ApproveDenyComponent,
    LoginComponent,
    EmpHisComponent,
    GrdFilterPipe
  ],
  imports: [
    BrowserModule,FormsModule,MatTableModule,
    HttpModule, RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule
  ],
  providers: [EmployeesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
