package com.proiect.PIBD.domain.Enrollment;

import com.proiect.PIBD.domain.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Enrollment.EmployeeCourse> {

    @Query("SELECT e FROM Employee e JOIN Enrollment en ON e.EmployeeID = en.employeeCourseID.EmployeeID WHERE en.employeeCourseID.CourseID = :courseID")
    List<Employee> findEmployeeFromCourseID(@Param("courseID") int courseID);



}
