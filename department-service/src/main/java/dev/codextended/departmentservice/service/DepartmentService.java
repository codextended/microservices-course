package dev.codextended.departmentservice.service;

import dev.codextended.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartement(String departmentCode);
}
