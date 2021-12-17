package com.cybage.asyncexample.service;

import com.cybage.asyncexample.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addNewEmployee(Employee emp);

    Employee editEmployee(Employee emp);

    Employee getEmployeeDetailsByID(int id);

    List<Employee> getAllEmployeeList();

    void deleteEmployee(int id);

    List<Employee> getEmployeeByName(String name);

    List<Employee> getEmployeeBySalary(float salary);

    List<Employee> getAllEmployeeListBySort();

    List<Employee> getAllEmployeeListByPage();

    List<Employee> findEmployeeByDesignation(String designation);
}
