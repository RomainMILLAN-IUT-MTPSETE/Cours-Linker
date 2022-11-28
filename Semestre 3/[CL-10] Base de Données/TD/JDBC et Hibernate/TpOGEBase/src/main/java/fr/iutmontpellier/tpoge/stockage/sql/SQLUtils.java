package fr.iutmontpellier.tpoge.stockage.sql;

import java.sql.*;

public class SQLUtils {
    private static SQLUtils instance = null;
    private Connection connection;
    private SQLUtils() {
        String url = "jdbc:oracle:thin:@162.38.222.149:1521:iut";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String user = "millanr";
        String pass = "090816840JK";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return this.connection;
    }
    public static SQLUtils getInstance() {
        if(instance == null) {
            instance = new SQLUtils();
        }
        return instance;
    }
}
