package dev.patika.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_code")
    private String code;

    @Column(name = "course_credit_score")
    private int creditScore;

    @ManyToMany(mappedBy = "courses")
    List<Student> students;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "instructor_id")
    Instructor instructor;
}
