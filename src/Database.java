import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private String dbName;
    private String url;
    private String username;
    private String password;

    Database(String dbName) {
        this.dbName = dbName;
        url = "jdbc:mysql://localhost:3306/" + dbName;
        username = "root";
        password = "123456789";
    }///

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // creating your own DB
    public void createDatabase() {
        try {
            String base_url = "jdbc:mysql://localhost:3306/";
            Connection con = DriverManager.getConnection(base_url, username, password);
            Statement st = con.createStatement();

            String query = "create database " + dbName + ";";

            st.execute(query);

            con.close();

            System.out.println(dbName + " Created Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // creating table in a particular DB
    public void deleteDatabase() {
        try {
            String query = "drop database " + dbName + ";";

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.execute(query);
            con.close();

            System.out.println(dbName + " Deleted Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }///

    public void createTable(String name) {
        String query = "create table " + name + " (id int , name varchar(50) , marks int);";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.execute(query);

            con.close();

            System.out.println(name + " Table created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }////

    public void createData() {
        // String query = "insert into student values ( 2 , 'steve' , 80 ) , ( 3 ,'tony'
        // , 100 ) ,( 4 , 'bruce' , 98 ) ;" ; // currently hardcoded
        String query = "insert into student values ( ? , ? , ? ) ;"; // with prepared statement
        try {
            Connection con = DriverManager.getConnection(url, username, password);

            // Statement st = con.createStatement();
            // st.executeUpdate(query);

            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, 5);
            st.setString(2, "Bucky");
            st.setInt(3, 67);

            st.executeUpdate();

            con.close();

            System.out.println("Data inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//

    public void readData() {
        String query = "select * from student ;";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString(2) + " : " + rs.getInt(3));
            }
            con.close();

            System.out.println("Reading Done Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//

}
