import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project{

    Frame frame;
    JPanel Panel;

    int[][] matrix = { { -1, -1, -1 },
            { -1, -1, -1 },
            { -1, -1, -1 }
    };

    int check_o() { // o -> 1
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++)
                sum = sum + matrix[i][j];
            if (sum == 3)
                return 1;
        }

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++)
                sum = sum + matrix[j][i];
            if (sum == 3)
                return 1;
        }

        if (matrix[0][0] + matrix[1][1] + matrix[2][2] == 3 || matrix[0][2] + matrix[1][1] + matrix[2][0] == 3)
            return 1;
        return 0;
    }

    int check_x() { // x -> 4
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++)
                sum = sum + matrix[i][j];
            if (sum == 12)
                return 1;
        }

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++)
                sum = sum + matrix[j][i];
            if (sum == 12)
                return 1;
        }

        if (matrix[0][0] + matrix[1][1] + matrix[2][2] == 12 || matrix[0][2] + matrix[1][1] + matrix[2][0] == 12)
            return 1;
        return 0;
    }

    JCheckBox box00, box01, box02, box10, box11, box12, box20, box21, box22;

    JLabel Result;

    ImageIcon img1 = new ImageIcon("BluePanel.jpg");
    ImageIcon img2 = new ImageIcon("Cross.jpg");
    ImageIcon img3 = new ImageIcon("Round.jpg");

    JPanel base;
    JPanel c1, c2, r1, r2;

    int a = 0;

    Project() {

        frame = new Frame();
        Panel = new JPanel();

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

        box00 = new JCheckBox();
        box00.setFocusable(false);
        box00.setIcon(img1);
        box00.setBounds(0, 0, 136, 136);

        box01 = new JCheckBox();
        box01.setFocusable(false);
        box01.setIcon(img1);
        box01.setBounds(142, 0, 136, 136);

        box02 = new JCheckBox();
        box02.setFocusable(false);
        box02.setIcon(img1);
        box02.setBounds(284, 0, 136, 136);

        box10 = new JCheckBox();
        box10.setFocusable(false);
        box10.setIcon(img1);
        box10.setBounds(0, 142, 136, 136);

        box11 = new JCheckBox();
        box11.setFocusable(false);
        box11.setIcon(img1);
        box11.setBounds(142, 142, 136, 136);

        box12 = new JCheckBox();
        box12.setFocusable(false);
        box12.setIcon(img1);
        box12.setBounds(284, 142, 136, 136);

        box20 = new JCheckBox();
        box20.setFocusable(false);
        box20.setIcon(img1);
        box20.setBounds(0, 284, 136, 136);

        box21 = new JCheckBox();
        box21.setFocusable(false);
        box21.setIcon(img1);
        box21.setBounds(142, 284, 136, 136);

        box22 = new JCheckBox();
        box22.setFocusable(false);
        box22.setIcon(img1);
        box22.setBounds(284, 284, 136, 136);

        Result = new JLabel();
        Result.setBounds(90, 550, 400, 75);

        box00.setDisabledIcon(img1);
        box01.setDisabledIcon(img1);
        box02.setDisabledIcon(img1);
        box10.setDisabledIcon(img1);
        box11.setDisabledIcon(img1);
        box12.setDisabledIcon(img1);
        box20.setDisabledIcon(img1);
        box21.setDisabledIcon(img1);
        box22.setDisabledIcon(img1);

        box00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box00.isSelected()) {
                    a++;
                    if(a == 9)
                        Result.setText("Draw");
                    if (a % 2 == 1) // Cross
                    {
                        box00.setEnabled(false);
                        box00.setDisabledIcon(img2);
                        matrix[0][0] = 4;
                        if (check_x() == 1) {
                            Result.setText("Cross Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    } 
                    else // Circle
                    {
                        box00.setEnabled(false);
                        box00.setDisabledIcon(img3);
                        matrix[0][0] = 1;
                        if (check_o() == 1) {
                            Result.setText("Circle Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    }
                }
            }
        });

        box01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box01.isSelected()) {
                    a++;
                    if(a == 9)
                        Result.setText("Draw");
                    if (a % 2 == 1) // Cross
                    {
                        box01.setEnabled(false);
                        box01.setDisabledIcon(img2);
                        matrix[0][1] = 4;
                        if (check_x() == 1) {
                            Result.setText("Cross Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    } 
                    else // Circle
                    {
                        box01.setEnabled(false);
                        box01.setDisabledIcon(img3);
                        matrix[0][1] = 1;
                        if (check_o() == 1) {
                            Result.setText("Circle Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    }
                }
            }
        });

        box02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box02.isSelected()) {
                    a++;
                    if(a == 9)
                        Result.setText("Draw");
                    if (a % 2 == 1) // Cross
                    {
                        box02.setEnabled(false);
                        box02.setDisabledIcon(img2);
                        matrix[0][2] = 4;
                        if (check_x() == 1) {
                            Result.setText("Cross Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    } 
                    else // Circle
                    {
                        box02.setEnabled(false);
                        box02.setDisabledIcon(img3);
                        matrix[0][2] = 1;
                        if (check_o() == 1) {
                            Result.setText("Circle Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    }
                }
            }
        });

        box10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box10.isSelected()) {
                    a++;
                    if(a == 9)
                        Result.setText("Draw");
                    if (a % 2 == 1) // Cross
                    {
                        box10.setEnabled(false);
                        box10.setDisabledIcon(img2);
                        matrix[1][0] = 4;
                        if (check_x() == 1) {
                            Result.setText("Cross Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    } 
                    else // Circle
                    {
                        box10.setEnabled(false);
                        box10.setDisabledIcon(img3);
                        matrix[1][0] = 1;
                        if (check_o() == 1) {
                            Result.setText("Circle Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    }
                }
            }
        });

        box11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box11.isSelected()) {
                    a++;
                    if(a == 9)
                        Result.setText("Draw");
                    if (a % 2 == 1) // Cross
                    {
                        box11.setEnabled(false);
                        box11.setDisabledIcon(img2);
                        matrix[1][1] = 4;
                        if (check_x() == 1) {
                            Result.setText("Cross Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    } 
                    else // Circle
                    {
                        box11.setEnabled(false);
                        box11.setDisabledIcon(img3);
                        matrix[1][1] = 1;
                        if (check_o() == 1) {
                            Result.setText("Circle Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    }
                }
            }
        });

        box12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box12.isSelected()) {
                    a++;
                    if(a == 9)
                        Result.setText("Draw");
                    if (a % 2 == 1) // Cross
                    {
                        box12.setEnabled(false);
                        box12.setDisabledIcon(img2);
                        matrix[1][2] = 4;
                        if (check_x() == 1) {
                            Result.setText("Cross Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    } 
                    else // Circle
                    {
                        box12.setEnabled(false);
                        box12.setDisabledIcon(img3);
                        matrix[1][2] = 1;
                        if (check_o() == 1) {
                            Result.setText("Circle Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    }
                }
            }
        });

        box20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box20.isSelected()) {
                    a++;
                    if(a == 9)
                        Result.setText("Draw");
                    if (a % 2 == 1) // Cross
                    {
                        box20.setEnabled(false);
                        box20.setDisabledIcon(img2);
                        matrix[2][0] = 4;
                        if (check_x() == 1) {
                            Result.setText("Cross Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    } 
                    else // Circle
                    {
                        box20.setEnabled(false);
                        box20.setDisabledIcon(img3);
                        matrix[2][0] = 1;
                        if (check_o() == 1) {
                            Result.setText("Circle Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    }
                }
            }
        });

        box21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box21.isSelected()) {
                    a++;
                    if(a == 9)
                        Result.setText("Draw");
                    if (a % 2 == 1) // Cross
                    {
                        box21.setEnabled(false);
                        box21.setDisabledIcon(img2);
                        matrix[2][1] = 4;
                        if (check_x() == 1) {
                            Result.setText("Cross Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    } 
                    else // Circle
                    {
                        box21.setEnabled(false);
                        box21.setDisabledIcon(img3);
                        matrix[2][1] = 1;
                        if (check_o() == 1) {
                            Result.setText("Circle Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    }
                }
            }
        });

        box22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box22.isSelected()) {
                    a++;
                    if(a == 9)
                        Result.setText("Draw");
                    if (a % 2 == 1) // Cross
                    {
                        box22.setEnabled(false);
                        box22.setDisabledIcon(img2);
                        matrix[2][2] = 4;
                        if (check_x() == 1) {
                            Result.setText("Cross Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    } 
                    else // Circle
                    {
                        box22.setEnabled(false);
                        box22.setDisabledIcon(img3);
                        matrix[2][2] = 1;
                        if (check_o() == 1) {
                            Result.setText("Circle Won");
                            box00.setEnabled(false);
                            box01.setEnabled(false);
                            box02.setEnabled(false);
                            box10.setEnabled(false);
                            box11.setEnabled(false);
                            box12.setEnabled(false);
                            box20.setEnabled(false);
                            box21.setEnabled(false);
                            box22.setEnabled(false);
                        }
                    }
                }
            }
        });

        base.add(box00);
        base.add(box01);
        base.add(box02);
        base.add(box10);
        base.add(box11);
        base.add(box12);
        base.add(box20);
        base.add(box21);
        base.add(box22);
        base.add(c1);
        base.add(c2);
        base.add(r1);
        base.add(r2);
        Panel.add(Result);
        Panel.add(base);
        frame.add(Panel);

        Result.setFont(new Font("Serif", Font.BOLD, 50));

        Panel.setBounds(0, 0, 800, 800);
        Panel.setBackground(Color.white);
        Panel.setLayout(null);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Project p = new Project();
    }
}