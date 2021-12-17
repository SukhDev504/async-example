package com.cybage.asyncexample.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_address")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Address {
    @Id
    private int pincode;
    private String street;
    private String city;
    private String state;
    @ManyToOne
    private Employee employee;


}
