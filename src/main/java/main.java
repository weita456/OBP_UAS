import java.sql.SQLException;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args) {
        new Member();

        try{
            connect db = new connect();
            System.out.println("Database is connected: "+db.isConnected());

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
