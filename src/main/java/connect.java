import java.sql.*;
public class connect {


    public Connection db;
    public connect() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");


        db = DriverManager.getConnection("jdbc:mysql://localhost:3306/tbjava", "root", "");
    }
    public boolean isConnected(){
        return( db != null);
    }

}
