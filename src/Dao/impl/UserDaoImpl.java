package Dao.impl;

import entity.User;
import Utils.JDBCTool;

import java.sql.*;

public class UserDaoImpl implements Dao.UserDao {
    private Connection connection;
    private Statement statement;
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

    @Override
    public User isValidEmail(String email) {
        String sql = "select * from user where email = ?";
        User user = new User();
        connection = JDBCTool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setName(this.resultSet.getString(2));
                user.setPassword(this.resultSet.getString(3));
                user.setEmail(email);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTool.release(connection,statement,resultSet);
        }

        return user;
    }

    @Override
    public boolean resetPassword(User user, String newPassword) {
        boolean execute = false;
        String username = user.getName();
        String sql = "update user set password = ? where username = ?";
        connection = JDBCTool.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,newPassword);
            preparedStatement.setString(2,username);
            execute = preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTool.release(connection,statement,null);
        }
        return execute;
    }
}