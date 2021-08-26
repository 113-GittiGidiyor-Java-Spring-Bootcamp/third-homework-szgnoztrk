package dev.patika.app.services.concretes;

import dev.patika.app.dao.InstructorDao;
import dev.patika.app.model.Instructor;
import dev.patika.app.services.abstracts.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class InstructorService implements BaseService<Instructor> {
    private InstructorDao instructorDao;
    @Autowired
    public InstructorService(InstructorDao instructorDao){ this.instructorDao = instructorDao; };

    @Override
    public List<Instructor> getAll() {
        List<Instructor> instructors = new ArrayList<>();
        Iterable<Instructor> instructorIterable= this.instructorDao.findAll();
        instructorIterable.iterator().forEachRemaining(instructors::add);
        return instructors;
    }

    @Override
    public Instructor getById(int id) {
        return this.instructorDao.findById(id);
    }

    @Override
    public Instructor save(Instructor instructor) {
        return (Instructor) this.instructorDao.save(instructor);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return (Instructor) this.instructorDao.save(instructor);
    }

    @Override
    public String delete(int id) {
        Instructor instructor = this.instructorDao.findById(id);
        this.instructorDao.delete(instructor);
        return "Deleted.";
    }

    @Override
    public String deleteByName(String s) {
        Instructor instructor = this.instructorDao.findByFullName(s);
        this.instructorDao.delete(instructor);
        return "Deleted.";
    }
}
