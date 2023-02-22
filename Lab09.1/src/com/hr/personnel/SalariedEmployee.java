package com.hr.personnel;

import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    // fields
    private double salary;

    // constructors
    public SalariedEmployee() {
        super();                // a superclass ctor is always called, whether you say this or not!
    }

    public SalariedEmployee(String name, LocalDate hireDate) {
        super(name, hireDate);  // delegate to the superclass ctor for name,hireDate
    }

    public SalariedEmployee(String name, LocalDate hireDate, double salary) {
        this(name, hireDate);   // delegate to the ctor above
        setSalary(salary);      // handle this myself
    }

    // business methods
    @Override
    public void pay() {
        System.out.println(getName() + " is paid salary " + getSalary());
    }

    public void takeVacation() {
        System.out.println(getName() + " is on vacation.");
    }

    @Override   // interface TaxPayer
    public void payTaxes(){
        System.out.println(getName() + " paid taxes of " + (getSalary() * SALARIED_TAX_RATE));
    }

    @Override   // interface Taxpayer
    public void fileReturn() {
        System.out.println("Return filed electronically");
    }

    // accessors methods
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate() + ", salary=" + getSalary();

    }
}