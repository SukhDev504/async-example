package com.cybage.asyncexample.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee_details")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employee {
    @Id
    @GeneratedValue
    private int employeeId;
    @Column(name = "emp_name")
    private String name;
    private String designation;
    private float salary;
    @OneToMany(mappedBy = "employee")
    private List<Address> address;

}
