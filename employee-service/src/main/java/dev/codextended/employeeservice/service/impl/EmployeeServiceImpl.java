package dev.codextended.employeeservice.service.impl;

import dev.codextended.employeeservice.dto.EmployeeDto;
import dev.codextended.employeeservice.mapper.EmployeeMapper;
import dev.codextended.employeeservice.model.Employee;
import dev.codextended.employeeservice.repository.EmployeeRepository;
import dev.codextended.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(EmployeeMapper.INSTANCE.toEntity(employeeDto));
        return EmployeeMapper.INSTANCE.fromEntity(employee);
    }

    @Override
    public EmployeeDto findEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            return EmployeeMapper.INSTANCE.fromEntity(employee);
        }
        return null;
    }
}
