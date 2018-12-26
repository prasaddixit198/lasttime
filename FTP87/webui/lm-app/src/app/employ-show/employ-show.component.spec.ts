import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EmployeesService } from '../employees.service';
import { EmployShowComponent } from './employ-show.component';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from '../../../node_modules/rxjs';

const userServiceStub1 = {
  showEmploy(empId) {
    console.log('bahar aja');
    const users =  
      {
        "empId": 1,
        "empName": "Vishnupriya",
        "empDept": "sql",
        "empEmail": "priyamadiraju7@gmail.com",
        "empMob": "7303351629",
        "empDoj": "2018-12-12",
        "empLeavbal":12,
        "empMgrid":7,
      };
    
    return of( users );
  }
};

describe('EmployShowComponent', () => {
  let component: EmployShowComponent;
  let fixture: ComponentFixture<EmployShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule, FormsModule,HttpModule
      ],
      declarations: [ EmployShowComponent ],
      providers: [{provide: EmployeesService, 
        useValue: userServiceStub1},
        HttpClient,
        HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should match empEmail', () => {
    const fixture = TestBed.createComponent(EmployShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps1.empEmail).toEqual("priyamadiraju7@gmail.com");
  });

  it('should match empName', () => {
    const fixture = TestBed.createComponent(EmployShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps1.empName).toEqual("Vishnupriya");
  });

  it('should match empMob', () => {
    const fixture = TestBed.createComponent(EmployShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps1.empMob).toEqual("7303351629");
  });

  it('should match empDept', () => {
    const fixture = TestBed.createComponent(EmployShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps1.empDept).toEqual("sql");
  });

  it('should match empDoj', () => {
    const fixture = TestBed.createComponent(EmployShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps1.empDoj).toEqual("2018-12-12");
  });

  it('should match empLeavbal', () => {
    const fixture = TestBed.createComponent(EmployShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps1.empLeavbal).toEqual(12);
  });

  it('should match empMgrid', () => {
    const fixture = TestBed.createComponent(EmployShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps1.empMgrid).toEqual(7);
  });
});
