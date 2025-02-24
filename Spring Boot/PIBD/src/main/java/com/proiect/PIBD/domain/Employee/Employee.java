package com.proiect.PIBD.domain.Employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Table(name = "Employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("EmployeeID")
    @Column(name = "EmployeeID")
    private int EmployeeID;

    @Column(nullable = false, length = 50, name = "Name")
    @JsonProperty("Name")
    private String Name;

    @Column(length = 100, name = "Position")
    @JsonProperty("Position")
    private String Position;

    @Column(name = "HireDate")
    @JsonProperty("HireDate")
    private Date HireDate;

    @Column(length = 100, name = "Department")
    @JsonProperty("Department")
    private String Department;

    @Column(length = 100, name = "Salary")
    @JsonProperty("Salary")
    private String Salary;


    public int getEmployeeID() {
        return EmployeeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setHireDate(Date hireDate) {
        HireDate = hireDate;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }
}
