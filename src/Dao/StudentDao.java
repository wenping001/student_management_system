package Dao;

import entity.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> studentList();
    public int addStudent(Student student);
    public boolean delete(String id);
    public boolean update(String studentID,String newName,String newSchool,String newMajor);
    public List<String> listSchool();
    public List<String> listMajor();
    public List<String> listNation();
    public Student getByStudentID(String Id);
}
