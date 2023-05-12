package dev.codextended.employeeservice.service;

import dev.codextended.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APICLient{

    @GetMapping("api/v1/departments/{departmentCode}")
    DepartmentDto getDepartmentDto(@PathVariable("departmentCode") String departmentCode);
}
