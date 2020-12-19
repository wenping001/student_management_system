package service;

import entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> studentList();
    public boolean delete(String id);
    public boolean update(String id);
}
