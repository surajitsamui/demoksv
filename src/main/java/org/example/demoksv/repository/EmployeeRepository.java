package org.example.demoksv.repository;
import org.example.demoksv.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}