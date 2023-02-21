/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.hr.personnel;

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
    private Employee[] employees = new Employee[100];
    private int currentIndex = 0;  // for dealing with the array

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
        // Note: we don't use for-each here because we only want to access the array where employees were added,
        // i.e.,
        // Question: what is in the array for indices where no Employee was added?  null!
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(employees[i]);  // toString() automatically called
        }
    }

    public void workEmployees() {
        for (int i = 0; i < currentIndex; i++) {
            employees[i].work();
        }
    }

    public void payEmployees() {
        for (int i = 0; i < currentIndex; i++) {
            employees[i].pay();
        }
    }

    /*
     * "Forced vacation". That is, for all employees that take vacation (SalariedEmployees), make them take vacation.
     * How can we find out what exact type we have here???
     */
    public void holidayBreak() {
        for (int i = 0; i < currentIndex; i++) {
            // downcast the Employee reference (employees[i]) to specific type SalariedEmployee
            // then we can call SalariedEmployee-specific methods (like takeVacation())

            // First, we "ask" employees[i], "are you really a SalariedEmployee?"
            if (employees[i] instanceof SalariedEmployee){
                // downcast-and-method-call in one shot
                ((SalariedEmployee) employees[i]).takeVacation();

                // SalariedEmployee semp = (SalariedEmployee) employees[i];
                // semp.takeVacation();
            }
        }
    }

    // helper method to add an Employee to the array

    // 'emp' is a reference of type Employee, that's pointing to an Employee object, an HourlyEmployee object, or a
    // SalariedEmployee object, depending on how the client called it.
    public void addEmployee(Employee emp) {
        employees[currentIndex++] = emp;
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