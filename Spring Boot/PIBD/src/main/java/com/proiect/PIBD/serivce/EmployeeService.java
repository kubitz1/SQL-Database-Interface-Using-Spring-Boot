package com.proiect.PIBD.serivce;

import com.proiect.PIBD.domain.Employee.Employee;
import com.proiect.PIBD.domain.Employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();

        return employees;
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }
}
