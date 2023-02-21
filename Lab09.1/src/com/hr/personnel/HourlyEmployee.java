package com.hr.personnel;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {
    //fields
    private double rate;
    private double hours;

    // constructors
    public HourlyEmployee() {
        super();                // a superclass ctor is always called, whether you say this or not!
    }

    public HourlyEmployee(String name, LocalDate hireDate) {
        super(name, hireDate);  // delegate to the superclass ctor for name,hireDate
    }

    public HourlyEmployee(String name, LocalDate hireDate, double rate, double hours) {
        this(name, hireDate);   // delegate to the ctor above
        setRate(rate);          // handle this myself
        setHours(hours);        // handle this myself
    }

    // methods
    @Override
    public void pay() {
        System.out.println(getName() + " is paid hourly with a total of " + (getRate() * getHours()));
    }

    @Override  // interface TaxPayer
    public void payTaxes(){
        System.out.println(getName() + " paid taxes of " + (getRate() * getHours() * HOURLY_TAX_RATE));
    }

    // accessors
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    // toString
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate() + ", rate=" + getRate() +
                ", hours=" + getHours();
    }
}