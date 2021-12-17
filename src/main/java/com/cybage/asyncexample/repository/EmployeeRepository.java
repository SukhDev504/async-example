package com.cybage.asyncexample.repository;

import com.cybage.asyncexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findByName(String name);

    List<Employee> findBySalaryLessThanEqual(float salary);

    List<Employee> getByDesignation(String designation);
}
