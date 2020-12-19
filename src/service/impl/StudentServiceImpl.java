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
    public boolean delete(String id) {
        return studentDao.delete(id);
    }

    @Override
    public boolean update(String id) {
        return studentDao.update(id);
    }
}
