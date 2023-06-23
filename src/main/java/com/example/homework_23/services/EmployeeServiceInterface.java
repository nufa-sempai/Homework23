package com.example.homework_23.services;

import com.example.homework_23.model.Employee;

import java.util.Collection;


public interface EmployeeServiceInterface {
    Employee addEmployee(String lastName, String firstName, int department, int salary);
    Employee removeEmployee(String lastName, String firstName, int department, int salary);
    Employee findEmployee(String lastName, String firstName, int department, int salary);
    Collection<Employee> findAll();
}
