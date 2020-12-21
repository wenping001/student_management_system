package Dao.impl;

import entity.Student;
import Utils.JDBCTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements Dao.StudentDao {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    boolean b;

    @Override
    public List<Student> studentList() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "select * from student";
        try {
            connection = JDBCTool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Student student = new Student();
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                String nation = resultSet.getString(4);
                String studentID = resultSet.getString(5);
                String school = resultSet.getString(6);
                String major = resultSet.getString(7);

                student.setId(id);
                student.setName(name);
                student.setSex(sex);
                student.setNation(nation);
                student.setStudentId(studentID);
                student.setSchool(school);
                student.setMajor(major);

                students.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTool.release(connection,statement,resultSet);
        }
        return students;
    }

    @Override
    public int addStudent(Student student) {
        int result = 0;
        connection = JDBCTool.getConnection();
        String sql = "insert into student values (null,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getSex());
            preparedStatement.setString(3,student.getNation());
            preparedStatement.setString(4,student.getStudentId());
            preparedStatement.setString(5,student.getSchool());
            preparedStatement.setString(6,student.getMajor());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTool.release(connection,statement,null);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        String sql = "delete from student where studentID = " + id;
        connection = JDBCTool.getConnection();
        try {
            statement = connection.createStatement();
            b = statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTool.release(connection,statement,null);
        }
        return b;
    }



    @Override
    public boolean update(String studentID, String newName, String newSchool, String newMajor) {
        String sql = "update student set name = ? ,school = ? , major = ? where studentID = ?";
        connection = JDBCTool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,newName);
            preparedStatement.setString(2,newSchool);
            preparedStatement.setString(3,newMajor);
            preparedStatement.setString(4,studentID);
            b = preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTool.release(connection,preparedStatement,null);
        }
        return b;
    }


    @Override
    public List<String> listSchool() {
        List<String> schoolList = new ArrayList<>();
        String sql = "select distinct school from student ";
        connection = JDBCTool.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                schoolList.add(resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTool.release(connection,statement,resultSet);
        }

        return schoolList;
    }

    @Override
    public List<String> listMajor() {
        List<String> majorList = new ArrayList<>();
        String sql = "select distinct major from student ";
        connection = JDBCTool.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                majorList.add(resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTool.release(connection,statement,resultSet);
        }

        return majorList;
    }

    @Override
    public List<String> listNation() {
        List<String> nationList = new ArrayList<>();
        String sql = "select distinct nation from student ";
        connection = JDBCTool.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                nationList.add(resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTool.release(connection,statement,resultSet);
        }

        return nationList;
    }

    @Override
    public Student getByStudentID(String Id) {
        String sql = "select * from student where studentID = ?";
        Student student = new Student();
        connection = JDBCTool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                student.setName(resultSet.getString(2));
                student.setSex(resultSet.getString(3));
                student.setNation(resultSet.getString(4));
                student.setStudentId(resultSet.getString(5));
                student.setSchool(resultSet.getString(6));
                student.setMajor(resultSet.getString(7));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTool.release(connection,preparedStatement,resultSet);
        }
        return student;
    }

}
