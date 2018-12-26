import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EmployeesService } from '../employees.service';
import { PendingLeavesComponent } from './pending-leaves.component';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from '../../../node_modules/rxjs';
import { GrdFilterPipe } from '../grd-filter.pipe';
const userServiceStub = {
  getEmployees() {
    console.log('came inside the stub');
    const users1 =  [
      {
        "empId": 1,
        "empName": "Vishnupriya",
        "empDept": "sql",
        "empEmail": "priyamadiraju7@gmail.com",
        "empMob": "7303351629",
        "empDoj": "2018-12-12",
        "empLeavbal":12,
        "empMgrid":7,
      },
      {        
        "empId": 2,
        "empName": "priya",
        "empDept": "java",
        "empEmail": "priya7@gmail.com",
        "empMob": "9324330169",
        "empDoj": "2018-11-12",
        "empLeavbal":12,
        "empMgrid":9,
      },
      {
        "empId": 3,
        "empName": "Vishnupriya",
        "empDept": "sql",
        "empEmail": "priyamadiraju7@gmail.com",
        "empMob": "2314569823",
        "empDoj": "2018-12-12",
        "empLeavbal":12,
        "empMgrid":6,
      },
      {
        "empId": 4,
        "empName": "Vishnupriya",
        "empDept": "angular",
        "empEmail": "priyamadiraju7@gmail.com",
        "empMob": "2314569872",
        "empDoj": "2018-12-12",
        "empLeavbal":12,
        "empMgrid":5,
      },
      {
        "empId": 5,
        "empName": "Vishnupriya",
        "empDept": "nodejs",
        "empEmail": "priyamadiraju7@gmail.com",
        "empMob": "2314569870",
        "empDoj": "2018-12-12",
        "empLeavbal":12,
        "empMgrid":3,
      },
      {
        "empId": 6,
        "empName": "vishnu",
        "empDept": "ang",
        "empEmail": "pri123@gmail.com",
        "empMob": "2314569879",
        "empDoj": "2018-12-12",
        "empLeavbal":12,
        "empMgrid":2,
      }
    ];
    return of( users1 );
  },
  showPending(empMgrid) {
    console.log('console check');
    const users =  [
      {
        "leaveid": 1,
        "empid": 123,
        "leavesdate": "2019-02-13",
        "leaveedate": "2019-02-13",
        "leavendays": 2,
        "leavetype": "SL",
        "leavestatus":"PENDING",
        "leavereason":"sick",
        "leaveappliedon":"2018-12-12",
        "leavemanagercomm":"abc"
      },
      {
        "leaveid": 2,
        "empid": 123,
        "leavesdate": "2019-02-13",
        "leaveedate": "2019-02-13",
        "leavendays": 2,
        "leavetype": "SL",
        "leavestatus":"PENDING",
        "leavereason":"sick",
        "leaveappliedon":"2018-12-12",
        "leavemanagercomm":"abc"
      },
      {
        "leaveid": 3,
        "empid": 123,
        "leavesdate": "2019-02-13",
        "leaveedate": "2019-02-13",
        "leavendays": 2,
        "leavetype": "SL",
        "leavestatus":"PENDING",
        "leavereason":"sick",
        "leaveappliedon":"2018-12-12",
        "leavemanagercomm":"abc"
      },
      {
        "leaveid": 4,
        "empid": 123,
        "leavesdate": "2019-02-13",
        "leaveedate": "2019-02-13",
        "leavendays": 2,
        "leavetype": "SL",
        "leavestatus":"PENDING",
        "leavereason":"sick",
        "leaveappliedon":"2018-12-12",
        "leavemanagercomm":"abc"
      },
      {
        "leaveid": 5,
        "empid": 123,
        "leavesdate": "2019-02-13",
        "leaveedate": "2019-02-13",
        "leavendays": 2,
        "leavetype": "SL",
        "leavestatus":"PENDING",
        "leavereason":"sick",
        "leaveappliedon":"2018-12-12",
        "leavemanagercomm":"abc"
      },
      {
        "leaveid": 6,
        "empid": 123,
        "leavesdate": "2019-02-13",
        "leaveedate": "2019-02-13",
        "leavendays": 2,
        "leavetype": "SL",
        "leavestatus":"PENDING",
        "leavereason":"sick",
        "leaveappliedon":"2018-12-12",
        "leavemanagercomm":"abc"
      },
    ];
    return of( users );
  }
};


describe('PendingLeavesComponent', () => {
  let component: PendingLeavesComponent;
  let fixture: ComponentFixture<PendingLeavesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule, FormsModule,HttpModule
      ],
      declarations: [ PendingLeavesComponent , GrdFilterPipe],
      providers: [{provide: EmployeesService, 
        useValue: userServiceStub},
        HttpClient,
        HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingLeavesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should match leavesdate', () => {
    const fixture = TestBed.createComponent(PendingLeavesComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[0].leavesdate).toEqual('2019-02-13');
 
  });
  it('should match leaveedate', () => {
    const fixture = TestBed.createComponent(PendingLeavesComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[1].leaveedate).toEqual('2019-02-13');
  });
  it('should match leavendays', () => {
    const fixture = TestBed.createComponent(PendingLeavesComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[2].leavendays).toEqual(2);
  });
  it('should match leavetype', () => {
    const fixture = TestBed.createComponent(PendingLeavesComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[3].leavetype).toEqual("SL");
  });
  it('should match leavestatus', () => {
    const fixture = TestBed.createComponent(PendingLeavesComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[4].leavestatus).toEqual('PENDING');
  });
  it('should match leavereason', () => {
    const fixture = TestBed.createComponent(PendingLeavesComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[5].leavereason).toEqual('sick');
  });
  it('should match leavemanagercomm', () => {
    const fixture = TestBed.createComponent(PendingLeavesComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[5].leavemanagercomm).toEqual('abc');
  });
//   it('should render one pending  record', async(() => {
  
//     const fixture = TestBed.createComponent(PendingLeavesComponent);
//     fixture.detectChanges();
//     fixture.whenStable().then(() => {
//     fixture.detectChanges();
//     const compiled = fixture.debugElement.nativeElement;
//     expect(compiled.querySelectorAll('.employees1 tr').length).toBe(6);
//     });
// }));

});
