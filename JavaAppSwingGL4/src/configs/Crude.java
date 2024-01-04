package configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crude {

   private final String url = "jdbc:mysql://localhost:3306/javaappswinggl4?characterEncoding=UTF-8";
    private final String login="root";
    private final String pwd="";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, login, pwd);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    public ResultSet exeRead(String sql) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                return statement.executeQuery();
            } catch (SQLException e) {
                return null;
            } finally {
                closeConnection(connection);
            }
        }
        return null;
    }

    public boolean exeCreate(String sql) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                return statement.executeUpdate() > 0;
            } catch (SQLException e) {
                return false;
            } finally {
                closeConnection(connection);
            }
        }
        return false;
    }

    public boolean exeUpdate(String sql) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                return statement.executeUpdate() > 0;
            } catch (SQLException e) {
                return false;
            } finally {
                closeConnection(connection);
            }
        }
        return false;
    }

    public boolean exeDelete(String sql) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                return statement.executeUpdate() > 0;
            } catch (SQLException e) {
                return false;
            } finally {
                closeConnection(connection);
            }
        }
        return false;
    }
}
