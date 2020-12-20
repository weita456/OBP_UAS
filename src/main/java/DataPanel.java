import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;


class DataPanel extends JPanel {
    static DefaultTableModel tabelmodel;
    static   JTable table;

    DataPanel() {
        tabelmodel=new DefaultTableModel();
        table = new JTable(tabelmodel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        this.melihatdata();

        setLayout(new GridLayout(1, 1));
        setBorder(new EmptyBorder(10, 10, 0, 12));

        add(scrollPane);
    }



    static void melihatdata (){

        try {
            tabelmodel= new DefaultTableModel();
            tabelmodel.addColumn("UID");
            tabelmodel.addColumn("NAME");
            tabelmodel.addColumn("GENDER");
            tabelmodel.addColumn("PACKAGE");
            tabelmodel.addColumn("PHONE NUMBER");
            PreparedStatement ps= DriverManager.getConnection("jdbc:mysql://localhost:3306/tbjava", "root","").prepareStatement("select * from member order by id");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                tabelmodel.addRow(
                        new Object[]{
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5)


                        }
                );

            }

            table.setModel(tabelmodel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}

