package com.example.homework_23.controller;

import com.example.homework_23.model.Employee;
import com.example.homework_23.services.EmployeeServiceIMPL;
import com.example.homework_23.services.EmployeeServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceInterface employeeServiceInterface;

    public EmployeeController(EmployeeServiceInterface employeeServiceInterface) {
        this.employeeServiceInterface = employeeServiceInterface;
    }
    @GetMapping
    public String hello(){
        return "HELLO";
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam int department,
                        @RequestParam int salary){
        return employeeServiceInterface.addEmployee(firstName,lastName,department,salary);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("department") int department,
                           @RequestParam("salary") int salary){
        return employeeServiceInterface.removeEmployee(firstName,lastName,department,salary);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam int department,
                         @RequestParam int salary){
        EmployeeServiceIMPL service;
        return employeeServiceInterface.findEmployee(firstName,lastName, department, salary);
    }
    @GetMapping("/all")
    public Collection<Employee> allPrint(){
        return  employeeServiceInterface.findAll();
    }

}