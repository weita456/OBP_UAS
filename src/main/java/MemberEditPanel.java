import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;



class MemberEditPanel extends JPanel {

    static JTextField id = new JTextField();
    static JTextField fullname = new JTextField();
    static  JTextField phonenumber = new JTextField();
    static String[] g = {"Male", "Female"};
    static JComboBox gender = new JComboBox(g);
    static String[] p = {
            "Midnight - IDR.20,000",
            "Dawn - IDR.15,000",
            "Phoenix - IDR.30,000",
            "Platinum - IDR.50,000"
    };
    static JComboBox position = new JComboBox(p);




    MemberEditPanel() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("UID(number): "));
        add(id);


        add(new JLabel("Name : "));
        add(fullname);


        add(new JLabel("Phone Number (+62) : "));
        add(phonenumber);

        add(new JLabel("Gender : "));
        add(gender);

        add(new JLabel("Package : "));
        add(position);

        //border
        Border etc = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder title = BorderFactory.createTitledBorder(etc, "Member Data Edit ");
        title.setTitleFont(title.getTitleFont().deriveFont(Font.BOLD));


        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), title));
    }
    static class buttonadd implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            try {
                String sql = "insert into member(id,fullname,gender,package,phonenumber) values(?,?,?,?,?)";
                Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/tbjava", "root", "");
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,id.getText());
                ps.setString(2,fullname.getText());
                ps.setString(3, String.valueOf(gender.getSelectedItem()));
                ps.setString(4, String.valueOf(position.getSelectedItem()));
                ps.setString(5,phonenumber.getText());
                ps.executeUpdate();
                DataPanel.melihatdata();




                JOptionPane.showMessageDialog(null,"Data berhasil ditambah");



            } catch (Exception exception) {
                exception.printStackTrace();
            }
            formdikosongin();

        }

        private void formdikosongin(){
            id.setText("");
            fullname.setText("");
            phonenumber.setText("");
            gender.setSelectedItem("");
            position.setSelectedItem("");
        }

    }

    static class buttonupdate implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String sql = "update member set fullname=?,gender=?,package=?,phonenumber=? where id=? ";
                Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/tbjava", "root", "");
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,fullname.getText());
                ps.setString(2, String.valueOf(gender.getSelectedItem()));
                ps.setString(3, String.valueOf(position.getSelectedItem()));
                ps.setString(4, phonenumber.getText());
                ps.setString(5,id.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
                formdikosongin();
                DataPanel.melihatdata();


            } catch (Exception exception) {
                exception.printStackTrace();
            }




        }
        private void formdikosongin(){
            id.setText("");
            fullname.setText("");
            phonenumber.setText("");
            gender.setSelectedItem("");
            position.setSelectedItem("");
        }

    }

    static class buttondelete implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
                String sql = "delete from member where id=?";
                Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/tbjava", "root", "");
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,id.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
                formdikosongin();
                DataPanel.melihatdata();


            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,"Data gagal dihapus");
            }
        }
        private void formdikosongin(){
            id.setText("");

        }

    }




}