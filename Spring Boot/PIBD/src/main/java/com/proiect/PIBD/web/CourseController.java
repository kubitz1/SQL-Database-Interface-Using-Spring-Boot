package com.proiect.PIBD.web;

import com.proiect.PIBD.domain.Course.Course;
import com.proiect.PIBD.domain.Employee.Employee;
import com.proiect.PIBD.serivce.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("")
    public String index(Model model){
        List<Course> courses = courseService.getAllCourses();

        model.addAttribute("courseModel", courses);

        return "courseindex";
    }

    @PostMapping("/create")
    public String create(@RequestParam String courseName,
                         @RequestParam int duration,
                         @RequestParam String difficulty){

        courseService.createCourse(courseName, duration, difficulty);
        return "redirect:/course";
    }

    @PostMapping("/{id}")
    public String deleteCourse(@PathVariable int id){
        courseService.deleteById(id);

        return "redirect:/course";
    }

    @GetMapping("/{courseID}/employee")
    public String viewEmployee(@PathVariable int courseID, Model model){
        List<Employee> employees = courseService.getAllEmployeesFromCourseById(courseID);
        model.addAttribute("employees", employees);
        model.addAttribute("courseID", courseID);

        return "courseEmployee";
    }

    @PostMapping("/{courseID}/employee/remove/{employeeID}")
    public String removeEmployee(@PathVariable int courseID, @PathVariable int employeeID){
        courseService.deleteEmployee(courseID, employeeID);

        return "redirect:/course/"+ courseID + "/employee";
    }
//    course/1/employee/add
    @PostMapping("/{courseID}/employee/add")
    public String addEmployee(@PathVariable int courseID, @RequestParam int employeeID, @RequestParam int grade){

        Date completion_date  = new Date();
        courseService.addEmployee(courseID, employeeID, completion_date, grade);

        return  "redirect:/course/"+ courseID + "/employee";
    }

    @GetMapping("/{courseID}/update")
    public String updateCourse(@PathVariable int courseID, Model model){

        Course course = courseService.getCourseById(courseID);
        model.addAttribute("courseId", courseID);
        model.addAttribute("courseName", course.getCourseName());
        model.addAttribute("duration", course.getDuration());
        model.addAttribute("difficulty", course.getDifficulty());


        return "courseUpdate";
    }

    @PostMapping("/{courseId}/save")
    public String updateCourseById(@PathVariable int courseId, @RequestParam String courseName, @RequestParam int duration, @RequestParam String difficulty){
        Course course = courseService.getCourseById(courseId);

        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setDifficulty(difficulty);

        courseService.save(course);

        return "redirect:/course";
    }
}
