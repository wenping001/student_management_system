package Dao.impl;

import entity.User;
import Utils.JDBCTool;

import java.sql.*;

public class UserDaoImpl implements Dao.UserDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private User user = null;

    @Override
    public User login(String username, String password) {
        connection = JDBCTool.getConnection();
        try {
            String sql = "select * from user where username = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user1 = new User();
                user1.setName(username);
                user1.setPassword(password);
                user1.setEmail(resultSet.getString(4));
                user = user1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void register(String username, String password, String email) {
        String sql = "insert into user values(null,?,?,?)";
        connection = JDBCTool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}