package dev.patika.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "student_fullname")
    private String fullName;

    @Column(name = "student_birthdate")
    private LocalDate birthDate;

    @Column(name = "student_address")
    private String address;

    @Column(name = "student_gender")
    private String gender;

    @JsonIgnore
    @ManyToMany
    private List<Course> courses;
}
