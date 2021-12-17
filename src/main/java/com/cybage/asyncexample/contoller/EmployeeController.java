package com.cybage.asyncexample.contoller;

import com.cybage.asyncexample.model.Employee;
import com.cybage.asyncexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addNewEmployee(@RequestBody Employee emp) {
        return employeeService.addNewEmployee(emp);
    }

    @PutMapping("/edit")
    public Employee editEmployee(@RequestBody Employee emp) {
        return employeeService.editEmployee(emp);
    }

    @GetMapping("/getEmployeeDetailsByID/{id}")
    public Employee editEmployee(@PathVariable int id) {

        Employee resp = employeeService.getEmployeeDetailsByID(id);
        return resp;
    }

    @GetMapping("/getAllEmployeeList")
    public List<Employee> getAllEmployeeList() {

        List<Employee> empList = employeeService.getAllEmployeeList();
        return empList;
    }

    @DeleteMapping("/deleteEmp/{id}")
    public void deleteEmployee(@PathVariable int id) {

        employeeService.deleteEmployee(id);
    }

    @GetMapping("/getEmployeeByName/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {

        List<Employee> empList = employeeService.getEmployeeByName(name);
        return empList;
    }

    @GetMapping("/getEmployeeBySalary/{salary}")
    public List<Employee> findBySalaryLessThanEqual(@PathVariable float salary) {

        List<Employee> empList = employeeService.getEmployeeBySalary(salary);
        return empList;
    }

    @GetMapping("/getAllEmployeeListBySort")
    public List<Employee> getAllEmployeeListBySort() {

        List<Employee> empList = employeeService.getAllEmployeeListBySort();
        return empList;
    }
    @GetMapping("/getAllEmployeeListByPage")
    public List<Employee> getAllEmployeeListByPage() {

        List<Employee> empList = employeeService.getAllEmployeeListByPage();
        return empList;
    }
    @GetMapping("/findEmployeeByDesignation/{designation}")
    public List<Employee> findEmployeeByDesignation(@PathVariable String designation) {

        List<Employee> empList = employeeService.findEmployeeByDesignation(designation);
        return empList;
    }

}
