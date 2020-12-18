package Dao;

import Bean.User;
import Utils.JDBCTool;

import java.sql.*;

public class UserDao {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean isRight;
    private User user = null;

    public User getUser(String name, String password){
        connection = JDBCTool.getConnection();
        try {
            String sql = "select * from user where username = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user1 = new User();
                user1.setName(name);
                user1.setPassword(password);
                user1.setEmail(resultSet.getString(4));
                user = user1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println(userDao.getUser("wping", "123456").toString());

    }
}
