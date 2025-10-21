package com.pluralsight;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    private int employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private double REGULAR_HOURS = 40;

    private String clockInTime;
    private LocalTime clockOutTime;

    public Employee(int employeeID, String name, String department, double payRate, double hoursWorked) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay() {
        return payRate * payRate;
    }

    public double getRegularHours() {
        if (hoursWorked < REGULAR_HOURS) {
            return hoursWorked * payRate;
        } else {
            return REGULAR_HOURS * payRate;
        }
    }

    public double getOvertimeHours() {
        if (hoursWorked > REGULAR_HOURS) {
            return (hoursWorked - REGULAR_HOURS) * (payRate + .5);
        } else {
            return 0;
        }
    }
    public void punchIn() {
        clockInTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss a"));
        System.out.printf("%s clocked in at %s\n", name, clockInTime);
    }

}
