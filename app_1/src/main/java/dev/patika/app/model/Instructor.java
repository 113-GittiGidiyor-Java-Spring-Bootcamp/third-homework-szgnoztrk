package dev.patika.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private int id;

    @Column(name = "instructor_fullname")
    private String fullName;

    @Column(name = "instructor_address")
    private String address;

    @Column(name = "instructor_phone")
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;
}
