import java.sql.*;

public class JDBC {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "java";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        try {
            Class.forName(DRIVER);
            System.out.println("Show");

            try (Connection connection = DriverManager.getConnection(USERNAME, PASSWORD, URL)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM easy_drinks");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(7));
                }
                resultSet.close();
                statement.close();

            }
        } catch (SQLException e) {
            System.out.println("НЕ работает");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("No connection");
        }
    }


}

