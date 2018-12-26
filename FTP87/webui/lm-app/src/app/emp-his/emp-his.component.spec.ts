import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EmployeesService } from '../employees.service';
import { EmpHisComponent } from './emp-his.component';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from '../../../node_modules/rxjs';

const userServiceStub = {
  emphistory(empId) {
    console.log('console check');
    const users =  [
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
    return of( users );
  }
};

describe('EmpHisComponent', () => {
  let component: EmpHisComponent;
  let fixture: ComponentFixture<EmpHisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule, FormsModule,HttpModule
      ],
      declarations: [ EmpHisComponent ],
      providers: [{provide: EmployeesService, 
        useValue: userServiceStub},
        HttpClient,
        HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpHisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should match name', () => {
    const fixture = TestBed.createComponent(EmpHisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[0].empName).toEqual('Vishnupriya');
 
  });
  it('should match dept', () => {
    const fixture = TestBed.createComponent(EmpHisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[1].empDept).toEqual('java');
  });
  it('should match email', () => {
    const fixture = TestBed.createComponent(EmpHisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[2].empEmail).toEqual('priyamadiraju7@gmail.com');
  });
  it('should match mobno', () => {
    const fixture = TestBed.createComponent(EmpHisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[3].empMob).toEqual('2314569872');
  });
  it('should match doj', () => {
    const fixture = TestBed.createComponent(EmpHisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[4].empDoj).toEqual('2018-12-12');
  });
  it('should match leavebal', () => {
    const fixture = TestBed.createComponent(EmpHisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[5].empLeavbal).toEqual(12);
  });
  it('should match mgrid', () => {
    const fixture = TestBed.createComponent(EmpHisComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps[5].empMgrid).toEqual(2);
  });
  it('should render one employee record', async(() => {
  
    const fixture = TestBed.createComponent(EmpHisComponent);
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelectorAll('.leavedetails tr').length).toBe(6);
    });
}));
});