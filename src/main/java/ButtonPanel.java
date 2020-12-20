import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class ButtonPanel extends JPanel {

    JButton updatebutton= new JButton("Update");
    JButton addbutton=new JButton("Add");
    JButton deletebutton=new JButton("Delete");
    JButton closebutton=new JButton("Close");
    JButton bayarbutton=new JButton("Bayar");

    ButtonPanel(){
        setLayout(new GridLayout(1,4));
        add(updatebutton);
        add(addbutton);
        add(deletebutton);
        add(closebutton);
        add(bayarbutton);
        addbutton.addActionListener(new MemberEditPanel.buttonadd());
        updatebutton.addActionListener(new MemberEditPanel.buttonupdate());
        deletebutton.addActionListener(new MemberEditPanel.buttondelete());
        closebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        bayarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Pembayaran();
            }
        });




    }


}



