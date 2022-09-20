package com.example.thi_dawa;

public class Employee {
    private String Name;
    private String Designation;
    private String Salary;

    public Employee() {
    }

    public Employee(String name, String designation, String salary) {
        Name = name;
        Designation = designation;
        Salary = salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + Name + '\'' +
                ", Designation='" + Designation + '\'' +
                ", Salary='" + Salary + '\'' +
                '}';
    }
}
