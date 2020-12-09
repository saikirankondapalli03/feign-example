package com.travellerapp.cdd;

public class Employee {
    private Long employeeId;
    private String employeeName;
    private int employeeAge;
    private Employee.EmployeeGender employeeGender;

    public enum EmployeeGender {
        MALE, FEMALE
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public Employee.EmployeeGender getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(Employee.EmployeeGender employeeGender) {
        this.employeeGender = employeeGender;
    }

    public Employee() {
    }

    public Employee(String employeeName, int employeeAge, Employee.EmployeeGender employeeGender) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeGender = employeeGender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeGender=" + employeeGender +
                '}';
    }
}
