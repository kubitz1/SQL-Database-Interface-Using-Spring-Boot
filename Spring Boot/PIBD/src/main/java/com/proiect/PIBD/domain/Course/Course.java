package com.proiect.PIBD.domain.Course;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("CourseID")
    @Column(name = "CourseID")
    private int CourseID;

    @Column(length = 50, name = "Name")
    private String courseName;

    @Column(name = "Duration")
    private int duration;

    @Column(length = 50, name = "Difficulty")
    private String difficulty;

}
