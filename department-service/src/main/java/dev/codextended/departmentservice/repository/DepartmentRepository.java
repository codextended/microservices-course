package dev.codextended.departmentservice.repository;

import dev.codextended.departmentservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department getByDepartmentCode(String departmentCode);
}
