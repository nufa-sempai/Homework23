package com.example.homework_23.model;

import java.util.Objects;

public class Employee {
    private String lastName;
    private String firstName;
    private int department;
    private static int countId = 1;
    private final int id;


    public Employee(String lastName, String firstName, int department, int id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
        this.id = countId++;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        Employee.countId = countId;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && id == employee.id && lastName.equals(employee.lastName) && firstName.equals(employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, department, id);
    }
}