package dev.codextended.employeeservice.service;

import dev.codextended.employeeservice.dto.APIResponseDto;
import dev.codextended.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

//    EmployeeDto findEmployee(Long id);
    APIResponseDto findEmployee(Long id);
}
