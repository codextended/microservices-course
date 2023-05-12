package dev.codextended.employeeservice.mapper;

import dev.codextended.employeeservice.dto.EmployeeDto;
import dev.codextended.employeeservice.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEntity(EmployeeDto employeeDto);
    EmployeeDto fromEntity(Employee employee);
}
