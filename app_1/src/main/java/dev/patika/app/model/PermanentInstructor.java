package dev.patika.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permanent_instructor")
public class PermanentInstructor extends Instructor{
    @Column(name = "vr_fixed_salary")
    private double fixedSalary;

    @Builder(builderMethodName = "PermanentInstructorBuilder")
    public PermanentInstructor(int id, String fullName, String address, String phoneNumber, List<Course> courses, double fixedSalary) {
        super(id, fullName, address, phoneNumber, courses);
        this.fixedSalary = fixedSalary;
    }
}
