/**
 * The GUI class creates the GUI
 * which has different panels
 * and calls other classes
 * and methods in order to do the
 * back-end work.
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GUI {
    public GUI() { //constructor
        
        Holder h = new Holder();
        Player p = new Player();
        Dealer d = new Dealer();
        //initialises the different construcotrs
        
        //creates the frame and the different buttons and labels
        JFrame f = new JFrame("Blackjack");
        JButton buttonExit = new JButton("Exit");
        JButton buttonHit = new JButton("Hit");
        JButton buttonStand = new JButton("Stand");

        buttonExit.setLayout(null);
        buttonExit.setBounds(475, 400, 50, 40);
        buttonHit.setBounds(400, 400, 50, 40);
        buttonStand.setBounds(550, 400, 50, 40);
        
        f.add(buttonExit);
        f.add(buttonHit);
        f.add(buttonStand);

        buttonExit.addActionListener(e -> { //when exit button is clicked, it saves the progress of the account and the prices
            System.exit(0); //and exits the program
        });

        buttonHit.addActionListener(e -> { //when reset button is clicked, it resets the balance and asset held by the account
            p.getCard();
        });

        //properties of the frame
        f.setSize(1000,500);
        f.setLayout(null);  
        f.setVisible(true);
           
    }
}