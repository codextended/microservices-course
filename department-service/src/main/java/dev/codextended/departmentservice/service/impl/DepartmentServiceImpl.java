package dev.codextended.departmentservice.service.impl;

import dev.codextended.departmentservice.dto.DepartmentDto;
import dev.codextended.departmentservice.mapper.DepartmentMapper;
import dev.codextended.departmentservice.model.Department;
import dev.codextended.departmentservice.repository.DepartmentRepository;
import dev.codextended.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = departmentRepository.save(DepartmentMapper.INSTANCE.toEntity(departmentDto));
        return DepartmentMapper.INSTANCE.fromEntity(department);
    }

    @Override
    public DepartmentDto getDepartement(String departmentCode) {
        return DepartmentMapper.INSTANCE.fromEntity(departmentRepository.getByDepartmentCode(departmentCode));
    }
}
