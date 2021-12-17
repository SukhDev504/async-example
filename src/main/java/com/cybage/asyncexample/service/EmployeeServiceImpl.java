package com.cybage.asyncexample.service;

import com.cybage.asyncexample.model.Employee;
import com.cybage.asyncexample.repository.EmployeeRepository;
import com.cybage.asyncexample.util.SendNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    SendNotification notification;

    public Employee addNewEmployee(Employee emp) {

        return empRepo.save(emp);

    }

    public Employee editEmployee(Employee emp) {
        return empRepo.save(emp);

    }

    public Employee getEmployeeDetailsByID(int id) {

        Optional<Employee> optional = empRepo.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id :: " + id);
        }
        return employee;


    }


    public List<Employee> getAllEmployeeList() {
        List<Employee> emp = empRepo.findAll();
        notification.sendNotificationSMS(emp);
        // sendNotification(emp);
        return emp;
    }

    //This method not execute with Async concept because of As per
    // @Async rule Caller method and @Async should not in same class.
    @Async
    public void sendNotification(List<Employee> emp) {
        for (Employee e1 : emp
        ) {
            try {

                System.err.println("SMS Notification send to :" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(20);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //trying to create manual exception which is throw  exception msg
            //System.out.println(10 / 0);
        }
    }

    public void deleteEmployee(int id) {
        empRepo.deleteById(id);

    }

    public List<Employee> getEmployeeByName(String name) {
        return empRepo.findByName(name);
    }

    public List<Employee> getEmployeeBySalary(float salary) {

        return empRepo.findBySalaryLessThanEqual(salary);
    }

    public List<Employee> getAllEmployeeListBySort() {

        return empRepo.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }

    public List<Employee> getAllEmployeeListByPage() {
        PageRequest page = PageRequest.of(0, 2);
        return empRepo.findAll(page).getContent();
    }

    public List<Employee> findEmployeeByDesignation(String designation) {
        // return empRepo.getByDesignation(designation, Sort.by(Direction.DESC,
        // "name"));
        return empRepo.getByDesignation(designation);
    }


}
