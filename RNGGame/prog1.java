import java.awt.Color;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class prog1 extends JFrame{

    static String num;
    static int plc;
    JLabel j1 = new JLabel();
    
    static Random r = new Random();
    static int rng;
    static int count = 0;

    public static void numgen() {
        rng = r.nextInt(1,101);
    }

    public static void gameLogic(JLabel j1) {
        plc = Integer.parseInt(num);
        if(plc > rng) {
            if(plc-rng<=15) {
                j1.setText("A bit High. Try Again");
            }
            else {
                j1.setText("Too High. Try Again");
            }
        }
        else if(plc < rng) {
            if(rng-plc<=15) {
                j1.setText("A bit Low. Try Again");
            }
            else {
                j1.setText("Too Low. Try Again");
            }
        }
        else if(plc == rng) {
            j1.setForeground(Color.GREEN);
            j1.setText("Correct Guess!");
        }
    }

    prog1() {
        setTitle("Random Number Game");
        getContentPane().setBackground(Color.DARK_GRAY);
        JLabel j2 = new JLabel("Enter User Guess: ");
        JLabel j3 = new JLabel("Number Generated!");
        JLabel j4 = new JLabel("Score : "+count);
        j4.setBounds(20, 20, 300, 20);
        j3.setBounds(20, 200, 300, 20);
        j2.setBounds(20, 50, 300, 20);
        j1.setBounds(20, 80, 300, 20);
        JButton b1 = new JButton("Submit");
        b1.setBounds(140, 140, 100, 30);
        JButton b2 = new JButton("New Game");
        b2.setBounds(20, 140, 100, 30);
        JTextField t1 = new JTextField();
        t1.setBounds(200, 50, 100, 20);

        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLACK); 
        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.BLACK); 
        j2.setForeground(Color.WHITE);
        j3.setForeground(Color.WHITE);
        j4.setForeground(Color.WHITE);
        j1.setForeground(Color.RED);

        setLayout(null);
        setSize(350,350);
        add(j2); add(t1); add(j1); add(b1); add(b2); add(j4); add(j3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        numgen();
        b1.addActionListener((ActionEvent e) -> {
            num = t1.getText();
            gameLogic(j1);
            count++;
            j4.setText("Score : "+count);
            j3.setVisible(false);
        });
        b2.addActionListener((ActionEvent e) -> {
            numgen();
            j3.setVisible(true);
            j1.setText("");
            count = 0;
            j4.setText("Score : "+count);
            j1.setForeground(Color.RED);
        });
    }

    public static void main(String[] args) {
        prog1 obj = new prog1();
    }
}