package dev.patika.app.service.abstracts;
import java.util.List;

public interface BaseService<T> {
    List<T> getAll();
    T getById(int id);
    T save(T t);
    T update(T t);
    String delete(int id);
    String deleteByName(String s);
}