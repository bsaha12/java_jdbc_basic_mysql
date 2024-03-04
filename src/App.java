public class App {
    public static void main(String[] args) throws Exception {

        Database db = new Database("Students") ;

        // creating a database .. just one time
        // db.createDatabase();

        // deleting database if needed 
        // db.deleteDatabase();

        // create table once
        // db.createTable("student");

        // db.createData() ;

        db.readData() ;

    }
}
