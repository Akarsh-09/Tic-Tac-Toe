import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{

    JPanel base;
    JPanel c1, c2, r1, r2;

    Frame()
    {

        base = new JPanel();
        base.setBackground(new Color(0xB7DEFD));
        base.setBounds(90, 80, 420, 420);
        base.setLayout(null);

        c1 = new JPanel();
        c1.setBackground(new Color(0x000000));
        c1.setBounds(136, 0, 6, 420);

        c2 = new JPanel();
        c2.setBackground(new Color(0x000000));
        c2.setBounds(278, 0, 6, 420);

        r1 = new JPanel();
        r1.setBackground(new Color(0x000000));
        r1.setBounds(0, 136, 420, 6);

        r2 = new JPanel();
        r2.setBackground(new Color(0x000000));
        r2.setBounds(0, 278, 420, 6);

        base.add(c1);
        base.add(c2);
        base.add(r1);
        base.add(r2);

        this.setTitle("Tic Tac Toe");
        this.setSize(600, 700);
        this.setBackground(Color.white);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
        this.setLayout(null);
    }
}