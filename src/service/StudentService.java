package service;

import entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> studentList();
    public List<String> schoolList();
    public List<String> majorList();
    public List<String> nationList();
    public int addStudent(Student student);
    public boolean delete(String id);
    public boolean update(String id,String newName,String newSchool,String newMajor);
    public Student getByStudentID(String id);
}
