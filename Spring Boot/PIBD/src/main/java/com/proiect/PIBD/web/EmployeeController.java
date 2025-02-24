package com.proiect.PIBD.web;

import com.proiect.PIBD.domain.Course.Course;
import com.proiect.PIBD.domain.Employee.Employee;
import com.proiect.PIBD.serivce.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String index(Model model) {

        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        return "employeeindex";
    }


    @PostMapping("/create")
    public String create(@RequestParam String Name,
                         @RequestParam String Position,
                         @RequestParam String Department,
                         @RequestParam String Salary) {

        Employee employee = new Employee();
        employee.setName(Name);
        employee.setPosition(Position);
        employee.setDepartment(Department);
        employee.setSalary(Salary);
        employee.setHireDate(new Date());
        employeeService.save(employee);

        return "redirect:/employee";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        employeeService.deleteById(id);

        return "redirect:/employee";
    }

    @GetMapping("/{employeeID}/update")
    public String updateEmployee(@PathVariable int employeeID, Model model){
        Employee employee = employeeService.findById(employeeID);

        model.addAttribute("Name", employee.getName());
        model.addAttribute("Position", employee.getPosition());
        model.addAttribute("Department", employee.getDepartment());
        model.addAttribute("Salary", employee.getSalary());

        return "employeeUpdate";
    }

    @PostMapping("/{employeeID}/save")
    public String updateEmployeeById(@PathVariable int employeeID,
                                     @RequestParam String Name,
                                     @RequestParam String Position,
                                     @RequestParam String Department,
                                     @RequestParam String Salary){
        Employee employee = employeeService.findById(employeeID);

        employee.setName(Name);
        employee.setPosition(Position);
        employee.setDepartment(Department);
        employee.setSalary(Salary);

        employeeService.save(employee);

        return "redirect:/employee";
    }
}
