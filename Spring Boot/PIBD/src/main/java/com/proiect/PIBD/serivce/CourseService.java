package com.proiect.PIBD.serivce;

import com.proiect.PIBD.domain.Course.Course;
import com.proiect.PIBD.domain.Course.CourseRepository;
import com.proiect.PIBD.domain.Employee.Employee;
import com.proiect.PIBD.domain.Employee.EmployeeRepository;
import com.proiect.PIBD.domain.Enrollment.Enrollment;
import com.proiect.PIBD.domain.Enrollment.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void deleteById(int id){
        courseRepository.deleteById(id);
    }

    public void createCourse( String courseName,
                          int duration,
                          String difficulty) {

        Course course = new Course();
        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setDifficulty(difficulty);
        courseRepository.save(course);
    }

    public List<Employee> getAllEmployeesFromCourseById(int id){
        List<Employee> employees = enrollmentRepository.findEmployeeFromCourseID(id);

        return employees;
    }

    public void deleteEmployee(int courseID, int employeeID){
        Enrollment.EmployeeCourse employeeCourse = new Enrollment.EmployeeCourse();
        employeeCourse.setCourseID(courseID);
        employeeCourse.setEmployeeID(employeeID);
        enrollmentRepository.deleteById(employeeCourse);
    }

    public void addEmployee(int courseID, int employeeID, Date completion_date, int grade){
        Enrollment enrollment = new Enrollment();
        Enrollment.EmployeeCourse employeeCourse = new Enrollment.EmployeeCourse();
        employeeCourse.setCourseID(courseID);
        employeeCourse.setEmployeeID(employeeID);

        if (enrollmentRepository.existsById(employeeCourse)){
            return ;
        }

        if (!employeeRepository.existsById(employeeID)){
            return ;
        }

        enrollment.setEmployeeCourseID(employeeCourse);
        enrollment.setCompletion_date(completion_date);
        enrollment.setGrade(grade);

       enrollmentRepository.save(enrollment);
    }

    public Course getCourseById(int id){
        return courseRepository.findById(id).get();
    }

    public void save(Course course){
        courseRepository.save(course);
    }
}
