package dev.codextended.departmentservice.mapper;

import dev.codextended.departmentservice.dto.DepartmentDto;
import dev.codextended.departmentservice.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto fromEntity(Department department);

    Department toEntity(DepartmentDto departmentDto);
}
