import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private String dbName;
    private String url;
    private String username;
    private String password;

    Database(String name) {
        dbName = name;
        url = "jdbc:mysql://localhost:3306/";
        username = "root";
        password = "123456789";
    }///

    public void createDatabase() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            String query = "create database " + dbName + ";";

            st.execute(query);

            con.close();
            System.out.println(dbName + " Created Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }////

}
