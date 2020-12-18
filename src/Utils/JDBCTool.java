package Utils;

import java.sql.*;

public class JDBCTool {

    static private Connection connection;
    static private String URL = "jdbc:mysql://localhost:3307/student_information";
    static private String USER = "root";
    static private String PASS = "wenping";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static public Connection getConnection() {
        try {
            connection = DriverManager. getConnection(URL, USER, PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


    static public void release(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection!=null){
                connection.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
