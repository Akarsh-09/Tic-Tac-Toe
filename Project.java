import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project {

    Frame frame;
    JPanel Panel;
    JPanel base;
    JPanel c1, c2, r1, r2;

    int x, y, size = 3;

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

    JCheckBox box[][] = new JCheckBox[3][3];

    JButton Restart;

    JLabel Result;

    ImageIcon img1 = new ImageIcon("BluePanel.jpg");
    ImageIcon img2 = new ImageIcon("Cross.jpg");
    ImageIcon img3 = new ImageIcon("Round.jpg");

    int a = 0;

    public void Click(ActionEvent e, int i, int j) {
        if (box[i][j].isSelected()) {
            a++;
            if (a == 9)
                Result.setText("Draw");
            if (a % 2 == 1) // Cross
            {
                box[i][j].setEnabled(false);
                box[i][j].setDisabledIcon(img2);
                matrix[i][j] = 4;

                if (check_x() == 1) {
                    Result.setText("Cross Won");
                    for (int x = 0; x < 3; x++)
                        for (int y = 0; y < 3; y++)
                            box[x][y].setEnabled(false);
                }
            }

            else // Circle
            {
                box[i][j].setEnabled(false);
                box[i][j].setDisabledIcon(img3);
                matrix[i][j] = 1;

                if (check_o() == 1) {
                    Result.setText("Circle Won");
                    for (int x = 0; x < 3; x++)
                        for (int y = 0; y < 3; y++)
                            box[x][y].setEnabled(false);
                }
            }
        }
    }

    Project() {

        frame = new Frame();
        Panel = new JPanel();

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                box[i][j] = new JCheckBox();
                box[i][j].setFocusable(false);
                box[i][j].setIcon(img1);
                box[i][j].setDisabledIcon(img1);
                box[i][j].setBounds(142 * j, 142 * i, 136, 136);
            }

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

        Restart = new JButton("Restart");
        Restart.setBounds(400, 550, 100, 35);

        Result = new JLabel();
        Result.setBounds(90, 550, 280, 75);

        for (x = 0; x < 3; x++)
            for (y = 0; y < 3; y++) {
                int finalX = x, finalY = y;
                box[x][y].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Click(e, finalX, finalY);
                    }
                });
            }

        Restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Restart) {
                    a = 0;
                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++)
                            matrix[i][j] = -1;

                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++)
                            box[i][j].setEnabled(true);

                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++)
                            box[i][j].setSelected(false);

                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++)
                            box[i][j].setDisabledIcon(img1);

                    Result.setText("");

                }
            }
        });

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                base.add(box[i][j]);

        base.add(c1);
        base.add(c2);
        base.add(r1);
        base.add(r2);

        Panel.add(Restart);
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
        new Project();
    }
}