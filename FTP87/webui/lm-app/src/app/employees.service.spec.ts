import { TestBed, inject } from '@angular/core/testing';
import { HttpModule } from '@angular/http'; 
import { EmployeesService } from './employees.service';

describe('EmployeesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[
        HttpModule
      ],
      providers: [EmployeesService]
    });
  });

  it('should be created', inject([EmployeesService], (service: EmployeesService) => {
    expect(service).toBeTruthy();
  }));
});
