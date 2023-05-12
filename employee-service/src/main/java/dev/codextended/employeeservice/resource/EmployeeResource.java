package dev.codextended.employeeservice.resource;

import dev.codextended.employeeservice.dto.APIResponseDto;
import dev.codextended.employeeservice.dto.EmployeeDto;
import dev.codextended.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
public class EmployeeResource {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmpolyee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<APIResponseDto> findEmployee(@PathVariable(value = "employeeId") Long employeeId) {
        return new ResponseEntity<>(employeeService.findEmployee(employeeId), HttpStatus.OK);
    }
}
