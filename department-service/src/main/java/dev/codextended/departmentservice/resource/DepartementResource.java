package dev.codextended.departmentservice.resource;

import dev.codextended.departmentservice.dto.DepartmentDto;
import dev.codextended.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/departments")
@RequiredArgsConstructor
public class DepartementResource {

    private final DepartmentService departmentService;


    @PostMapping()
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable(value = "departmentCode") String departmentCode) {
        return new ResponseEntity<>(departmentService.getDepartement(departmentCode), HttpStatus.OK);
    }
}
