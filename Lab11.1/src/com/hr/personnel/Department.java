/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.hr.personnel;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The Department class manages employees.
 *
 * Properties:
 *   String name
 *   String location
 *   Employee[] employees  the Employees in this department.
 *   int currentIndex      internal counter for number of employees in the department.
 *
 * Methods (excluding get/set methods):
 *   void listEmployees()  print info on all employees in the department.
 *   void workEmployees()  make all employees in the department work.
 *   String toString()     self-explanatory.
 */
public class Department {
    // fields
    private String name;
    private String location;
    private final Collection<Employee> employees = new ArrayList<>();

    // constructors
    public Department() {
        super();        // a superclass ctor is always called, whether you say this or not!
    }

    public Department(String name, String location) {
        super();        // a superclass ctor is always called, whether you say this or not!
        setName(name);
        setLocation(location);
    }

    // business methods
    public void listEmployees() {
        for (Employee emp : employees){
            System.out.println(emp);            // toString() automatically called
        }
    }

    public void workEmployees() {
        for (Employee emp : employees) {
            emp.work();
        }
    }

    public void payEmployees() {
        for (Employee emp : employees) {
            emp.pay();
        }
    }

    /*
     * "Forced vacation". That is, for all employees that take vacation (SalariedEmployees), make them take vacation.
     * How can we find out what exact type we have here???
     */
    public void holidayBreak() {
        for (Employee emp : employees) {
            // downcast the Employee reference (emp) to specific type SalariedEmployee,
            // then we can call SalariedEmployee-specific methods (like takeVacation())

            // First, we "ask" emp, "are you really a SalariedEmployee?"
            // NOTE: instanceof does an IS-A check (so it's true for an Executive, also)
            if (emp instanceof SalariedEmployee) {
                ((SalariedEmployee) emp).takeVacation();
            }
        }
    }

    // 'emp' is a reference of type Employee, that's pointing to an Employee object, an HourlyEmployee object, or a
    // SalariedEmployee object, depending on how the client called it.
    public void addEmployee(Employee emp) {
        employees.add(emp);     // just call add() on the collection
    }

    // accessor methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return "Department: name=" + getName() + ", location=" + getLocation();

    }
}