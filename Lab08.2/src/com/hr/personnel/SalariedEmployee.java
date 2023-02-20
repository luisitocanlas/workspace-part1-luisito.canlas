package com.hr.personnel;

import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private double salary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String name, LocalDate hireDate) {
        super(name, hireDate);  // delegate to the superclass ctor for name,hireDate
    }

    public SalariedEmployee(String name, LocalDate hireDate, double salary) {
        this(name, hireDate);   // delegate to the ctor above
        setSalary(salary);      // handle this myself
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee: name=" + getName() + ", hireDate=" + getHireDate() + ", salary=" + getSalary();
    }
}