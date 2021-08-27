package dev.patika.app.service.concretes;

import dev.patika.app.dao.CourseDao;
import dev.patika.app.model.Course;
import dev.patika.app.service.abstracts.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements BaseService<Course> {
    private CourseDao courseDao;
    @Autowired
    public CourseService(CourseDao courseDao){ this.courseDao = courseDao; };

    @Override
    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();
        Iterable<Course> courseIterable= this.courseDao.findAll();
        courseIterable.iterator().forEachRemaining(courses::add);
        return courses;
    }

    @Override
    public Course getById(int id) {
        return this.courseDao.findById(id);
    }

    @Override
    public Course save(Course course) {
        return (Course) this.courseDao.save(course);
    }

    @Override
    public Course update(Course course) {
        return (Course) this.courseDao.save(course);
    }

    @Override
    public String delete(int id) {
        Course course = this.courseDao.findById(id);
        this.courseDao.delete(course);
        return "Deleted.";
    }

    @Override
    public String deleteByName(String s) {
        Course course = this.courseDao.findByName(s);
        this.courseDao.delete(course);
        return "Deleted.";
    }
}
