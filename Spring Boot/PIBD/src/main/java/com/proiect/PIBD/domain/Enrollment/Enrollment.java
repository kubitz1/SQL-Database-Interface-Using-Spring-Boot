package com.proiect.PIBD.domain.Enrollment;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Enrollment")
public class Enrollment {

    @EmbeddedId
    private EmployeeCourse employeeCourseID;

    @JsonProperty("Grade")
    @Column(name = "Grade")
    private int grade;

    @Column(name = "Completion_date")
    @JsonProperty("Completion_date")
    private Date Completion_date;

    @Embeddable
    @Data
    public static class EmployeeCourse {
        @JsonProperty("EmployeeID")
        @Column(name = "EmployeeID")
        private int EmployeeID;

        @JsonProperty("CourseID")
        @Column(name = "CourseID")
        private int CourseID;

        public EmployeeCourse(int EmployeeID, int CourseID) {
            this.EmployeeID = EmployeeID;
            this.CourseID = CourseID;
        }

        public EmployeeCourse() {
        }

    }

}
