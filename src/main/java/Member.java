import javax.swing.*;

public class Member extends  JFrame{

    public Member(){
        setTitle("Input Member Data");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        add(new DataPanel());
        add(new MemberEditPanel());
        add(new ButtonPanel());

        setVisible(true);

    }






}
