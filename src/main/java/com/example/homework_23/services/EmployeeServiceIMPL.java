package com.example.homework_23.services;

import com.example.homework_23.model.Employee;
import com.example.homework_23.exception.EmployeeAlreadyAddedException;
import com.example.homework_23.exception.EmployeeNotFoundException;
import com.example.homework_23.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceIMPL implements EmployeeServiceInterface {
    private static final int CAPACITY = 10;
    List<Employee> staff = new ArrayList();

    ValidatorService validatorService;

    public EmployeeServiceIMPL(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        Employee temp = new Employee(
                validatorService.validateFirstName(firstName),
                validatorService.validateLastName(lastName),
                department, salary);
        if (this.staff.size() >= 10) {
            throw new EmployeeStorageIsFullException();
        } else if (this.staff.contains(temp)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            this.staff.add(temp);
            return temp;
        }
    }

    public Employee removeEmployee(String firstName, String lastName, int department, int salary) {
        int index = this.staff.indexOf(new Employee(firstName, lastName, department, salary));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        } else {
            return this.staff.remove(index);
        }
    }

    public Employee findEmployee(String firstName, String lastName, int department, int salary) {
        int index = this.staff.indexOf(new Employee(firstName, lastName, department, salary));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        } else {
            return this.staff.get(index);
        }
    }

    public List<Employee> findAll() {
        return Collections.unmodifiableList(this.staff);
    }
}
