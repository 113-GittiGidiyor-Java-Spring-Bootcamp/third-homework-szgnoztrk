package dev.patika.app.config;

import dev.patika.app.dao.CourseDao;
import dev.patika.app.dao.InstructorDao;
import dev.patika.app.dao.StudentDao;
import dev.patika.app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitializerRunner implements CommandLineRunner {
    //Field Injection
    @Autowired
    private CourseDao courseDao;
    //Field Injection
    @Autowired
    private InstructorDao instructorDao;
    //Field Injection
    @Autowired
    private StudentDao studentDao;

    @Override
    public void run(String... args) throws Exception {
        this.courseDao.save(Course.builder()
                .name("Programlamaya Giriş")
                .code("BM123")
                .creditScore(2)
                .instructor((Instructor) this.instructorDao.save(VisitingResearcher.VisitingResearcherBuilder()
                        .fullName("Abdullah Talha Kabakuş")
                        .address("Sakarya")
                        .phoneNumber("+906664443322")
                        .hourlySalary(150.0).build())).build());
        this.courseDao.save(Course.builder()
                .name("Bilgisayar Ağları")
                .code("BM245")
                .creditScore(3)
                .instructor((Instructor) this.instructorDao.save(PermanentInstructor.PermanentInstructorBuilder()
                        .fullName("Resul Kara")
                        .address("Düzce")
                        .phoneNumber("+905559993322")
                        .fixedSalary(10000.0).build())).build());
        this.courseDao.save(Course.builder()
                .name("Java Programlama")
                .code("BM345")
                .creditScore(1)
                .instructor((Instructor) this.instructorDao.save(VisitingResearcher.VisitingResearcherBuilder()
                        .fullName("Koray Güney")
                        .address("İstanbul")
                        .phoneNumber("+905554443322")
                        .hourlySalary(200.0).build())).build());

        /*
            İlk önce her ekleyeceğim öğrenci için course listesi oluşturarak bu listeleri save işleminde kullandım.
         */
        List<Course> student1Course = new ArrayList<>();
        student1Course.add(this.courseDao.findById(1));
        student1Course.add(this.courseDao.findById(3));
        this.studentDao.save(Student.builder()
                .fullName("Sezgin Öztürk")
                .gender("Erkek")
                .birthDate(LocalDate.of(1996, Month.OCTOBER, 24))
                .address("Avcılar/İstanbul")
                .courses(student1Course).build());

        List<Course> student2Course = new ArrayList<>();
        student2Course.add(this.courseDao.findById(2));
        this.studentDao.save(Student.builder()
                .fullName("Sezgin Öztürk")
                .gender("Erkek")
                .birthDate(LocalDate.of(1999, Month.FEBRUARY, 04))
                .address("Bağcılar/İstanbul")
                .courses(student2Course).build());

        List<Course> student3Course = new ArrayList<>();
        student3Course.add(this.courseDao.findById(1));
        student3Course.add(this.courseDao.findById(2));
        student3Course.add(this.courseDao.findById(3));
        this.studentDao.save(Student.builder()
                .fullName("Yağmur Azra")
                .gender("Kadın")
                .birthDate(LocalDate.of(2000, Month.APRIL, 6))
                .address("Çan/Çanakkale")
                .courses(student3Course).build());
    }
}
