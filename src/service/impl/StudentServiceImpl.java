package service.impl;

import Dao.StudentDao;
import Dao.impl.StudentDaoImpl;
import entity.Student;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> studentList() {
        return studentDao.studentList();
    }

    @Override
    public List<String> schoolList() {
        return studentDao.listSchool();
    }

    @Override
    public List<String> majorList() {
        return studentDao.listMajor();
    }

    @Override
    public List<String> nationList() {
        return studentDao.listNation();
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public boolean delete(String id) {
        return studentDao.delete(id);
    }

    @Override
    public boolean update(String id, String newName, String newSchool, String newMajor) {
        return studentDao.update(id,newName,newSchool,newMajor);
    }

    @Override
    public Student getByStudentID(String id) {
        return studentDao.getByStudentID(id);
    }
}
