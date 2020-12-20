import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Pembayaran extends JFrame{
    JTextField txtnama,txtnamaa,txtnamaaa,txtnamaaaa;

    private JLabel label;

    JPanel panel1 = new JPanel();
    ButtonGroup bgJenisKelamin;
    String[] heroes = {"Midnight", "Dawn", "Phoenix ", "Platinum"};
    JComboBox combBox = new JComboBox(heroes);
    JToggleButton btnSubscribe;


    public Pembayaran(){
        setTitle("Form Pembayaran");
        setSize(250,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());



        txtnama = new JTextField(15);
        txtnamaa = new JTextField (15);
        txtnamaaa = new JTextField (15);
        txtnamaaaa = new JTextField (15);





        JTabbedPane tabbedPane = new JTabbedPane();


        add(new JLabel("Choose Package"));
        add(combBox);

        add(new JLabel("Masukan ID"));
        add(txtnama);

        add(new JLabel("Masukan Password"));
        add(txtnamaa);

        add(new JLabel("Masukan Jumlah Uang"));
        add(txtnamaaaa);


        JButton btnA = new JButton("Bayar");
        JButton btnB = new JButton("Batal");

        add(btnA);
        add(btnB);

        btnA.addActionListener(new buttonAlistener());
        btnB.addActionListener(new buttonBlistener());




        setVisible(true);
    }

}


class buttonAlistener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Pembayaran Berhasil");
        new Member();


    }
}
class buttonBlistener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Pembayaran Dibatalkan"); {
            System.exit(0);
        }
    }
}

