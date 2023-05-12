package dev.codextended.employeeservice.service.impl;

import dev.codextended.employeeservice.dto.APIResponseDto;
import dev.codextended.employeeservice.dto.DepartmentDto;
import dev.codextended.employeeservice.dto.EmployeeDto;
import dev.codextended.employeeservice.mapper.EmployeeMapper;
import dev.codextended.employeeservice.model.Employee;
import dev.codextended.employeeservice.repository.EmployeeRepository;
import dev.codextended.employeeservice.service.APICLient;
import dev.codextended.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
//    private final RestTemplate restTemplate;
//    private final WebClient webClient;
    private final APICLient apicLient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(EmployeeMapper.INSTANCE.toEntity(employeeDto));
        return EmployeeMapper.INSTANCE.fromEntity(employee);
    }

    @Override
    public APIResponseDto findEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();

            // Using Rest Template
//            ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//                    "http://localhost:8080/api/v1/departments/" + employee.getDepartmentCode(),
//                    DepartmentDto.class
//            );
//            APIResponseDto apiResponseDto = new APIResponseDto(
//                    EmployeeMapper.INSTANCE.fromEntity(employee),
//                    responseEntity.getBody()
//            );


            // Using Web CLient
//            DepartmentDto departmentDto = webClient.get()
//                    .uri("http://localhost:8080/api/v1/departments/" + employee.getDepartmentCode())
//                    .retrieve()
//                    .bodyToMono(DepartmentDto.class)
//                    .block();
//            APIResponseDto apiResponseDto = new APIResponseDto(
//                    EmployeeMapper.INSTANCE.fromEntity(employee),
//                    departmentDto
//            );

            // Using Open Feing
            DepartmentDto departmentDto = apicLient.getDepartmentDto(employee.getDepartmentCode());
            return new APIResponseDto(EmployeeMapper.INSTANCE.fromEntity(employee), departmentDto);
        }
        return null;
    }
}
