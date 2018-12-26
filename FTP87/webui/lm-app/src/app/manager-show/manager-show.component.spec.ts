import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { ManagerShowComponent } from './manager-show.component';
import { EmployeesService } from '../employees.service';
import { HttpModule } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from '../../../node_modules/rxjs';

const userServiceStub2 = {
  showEmploy(empMgrid) {
    console.log('bahar nikal');
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


describe('ManagerShowComponent', () => {
  let component: ManagerShowComponent;
  let fixture: ComponentFixture<ManagerShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule, FormsModule,HttpModule
      ],
      declarations: [ ManagerShowComponent ],
      providers: [{provide: EmployeesService, 
        useValue: userServiceStub2},
        HttpClient,
        HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should match empEmail', () => {
    const fixture = TestBed.createComponent(ManagerShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps2.empEmail).toEqual("priyamadiraju7@gmail.com");
  });

  it('should match empName', () => {
    const fixture = TestBed.createComponent(ManagerShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps2.empName).toEqual("Vishnupriya");
  });

  it('should match empMob', () => {
    const fixture = TestBed.createComponent(ManagerShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps2.empMob).toEqual("7303351629");
  });

  it('should match empDept', () => {
    const fixture = TestBed.createComponent(ManagerShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps2.empDept).toEqual("sql");
  });

  it('should match empDoj', () => {
    const fixture = TestBed.createComponent(ManagerShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps2.empDoj).toEqual("2018-12-12");
  });

  it('should match empLeavbal', () => {
    const fixture = TestBed.createComponent(ManagerShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps2.empLeavbal).toEqual(12);
  });

  it('should match empMgrid', () => {
    const fixture = TestBed.createComponent(ManagerShowComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.emps2.empMgrid).toEqual(7);
  });
});
