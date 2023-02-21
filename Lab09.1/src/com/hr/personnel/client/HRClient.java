/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.hr.personnel.client;

import com.hr.personnel.*;

import java.time.LocalDate;

/**
 * Application main-class.
 */
class HRClient {

    public static void main(String[] args) {
        // create Department object
        Department dept = new Department("Sales", "Seattle");
        System.out.println(dept);

        // add Employees to it
        dept.addEmployee(new SalariedEmployee("Lui", LocalDate.of(2015, 2, 11), 120000));
        dept.addEmployee(new SalariedEmployee("Jason", LocalDate.of(1990, 8, 24), 79000));
        dept.addEmployee(new HourlyEmployee("Julie", LocalDate.of(2000, 2, 2), 44, 40.0));
        dept.addEmployee(new Executive("Lulu", LocalDate.of(2019, 6, 3), 175000));

        // list its Employees
        System.out.println("\nList employees:");
        dept.listEmployees();

        // make its Employees work
        System.out.println("\nMake employees work:");
        dept.workEmployees();

        // pay the Employees
        System.out.println("\nPay employees:");
        dept.payEmployees();

        // holiday break
        System.out.println("\nHoliday break:");
        dept.holidayBreak();
    }
}