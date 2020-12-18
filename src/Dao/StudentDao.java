package Dao;

import Bean.Student;
import Bean.User;
import Utils.JDBCTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    
    public void addStudent(Student student){
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
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTool.release(connection,statement,null);
        }
    }

    public ArrayList<Student> listStudent(){
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

    public void delete(String studentID){
        String sql = "delete from student where studentID = ?";
    }

    public void update(){

    }

    public static void main(String[] args) {
        List<Student> list = new StudentDao().listStudent();
        for (Student student:list){
            System.out.println(student.toString());
        }
    }
}
