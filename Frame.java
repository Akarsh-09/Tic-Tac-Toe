import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Frame()
    {
        this.setTitle("Tic Tac Toe");
        this.setSize(600, 700);
        this.setBackground(Color.white);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
        this.setLayout(null);
    }
}