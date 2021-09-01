import java.sql.*;

import static java.lang.Class.forName;

public class JDBC {
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "java";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static Connection connection;
    public static Statement statement;

    public static void main(String[] args) {
        try {
            forName(DRIVER);

            connection = DriverManager.getConnection(USER_NAME, PASSWORD, URL);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM easy_drinks");
           while (resultSet.next()) {
                System.out.println(resultSet.getString(7));
           }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("НЕ работает");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("No connection");
        }
    }
}




