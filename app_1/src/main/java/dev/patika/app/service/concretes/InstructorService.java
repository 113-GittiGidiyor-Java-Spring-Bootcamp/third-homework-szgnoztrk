package dev.patika.app.service.concretes;

import dev.patika.app.dao.InstructorDao;
import dev.patika.app.model.Instructor;
import dev.patika.app.model.dto.InstructorSalaryDto;
import dev.patika.app.service.abstracts.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<InstructorSalaryDto> getTop3MaxSalary(){
        return this.instructorDao.getTop3MaxSalary();
    }

    public List<InstructorSalaryDto> getTop3MinSalary(){
        return this.instructorDao.getTop3MinSalary();
    }
}
