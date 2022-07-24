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
import javax.swing.JDialog;
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
        JButton buttonStand = new JButton("Std");
        JLabel playerScore = new JLabel();
        playerScore.setText(p.totalScore());
        JLabel dealerScore = new JLabel();
        dealerScore.setText(d.totalScore());
    
        buttonExit.setLayout(null);
        buttonExit.setBounds(475, 400, 70, 40);
        buttonHit.setBounds(400, 400, 70, 40);
        buttonStand.setBounds(550, 400, 70, 40);
        playerScore.setBounds(50, 100, 150, 50);
        dealerScore.setBounds(50, 200, 150, 50);
        
        f.add(buttonExit);
        f.add(buttonHit);
        f.add(buttonStand);
        f.add(playerScore);
        f.add(dealerScore);

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                playerScore.setText(p.totalScore());
                dealerScore.setText(d.totalScore());
            }
        };

        Timer timer = new Timer(1000, taskPerformer); //taskPerformer will run every 1 second in the background
        timer.start();

        buttonExit.addActionListener(e -> { //when exit button is clicked, it saves the progress of the account and the playerScores
            System.exit(0); //and exits the program
        });

        buttonHit.addActionListener(e -> { //when reset button is clicked, it resets the balance and asset held by the account
            p.setCardArray(p.getCard());
            System.out.println(p.getCardArray());
            System.out.println(p.totalScore());
            Boolean playerEnd = p.playerEnd(p.checkTotal(), d.checkTotal(), d);
            if (playerEnd == true) {
                System.out.println("Lost");
                JDialog lose = new JDialog(f, "Dialog Lost");
                JLabel ll = new JLabel("Label Lost");
                lose.add(ll);
                lose.setSize(100, 100);
                lose.setVisible(true);
                JButton buttonReset = new JButton("Reset");
                buttonReset.setBounds(550, 400, 50, 40);
                lose.add(buttonReset);
                buttonHit.addActionListener(ev -> {
                    p.resetTotal();
                    d.resetTotal();
                });
            }
        });

        buttonStand.addActionListener(e -> { //when reset button is clicked, it resets the balance and asset held by the account
            System.out.println(d.getCardArray());
            System.out.println(d.totalScore());
            Boolean dealerAbove16 = p.dealerAbove16(p.checkTotal(), d.checkTotal(), d);
            System.out.println("Std");
            while (dealerAbove16 == false) {
                System.out.println("DEALER ABOVE 16: " + dealerAbove16);
                System.out.println("card added: " + d.getCard());
                d.setCardArray(d.getCard());
                int total = d.checkTotal();
                System.out.println("total" + d.getCardArray());
                dealerAbove16 = p.dealerAbove16(p.checkTotal(), total, d);
                System.out.println(p.checkTotal());
            }

            JDialog lose = new JDialog();
            JLabel ll =  new JLabel();
            if (d.dealerEnd(p.checkTotal(), d.checkTotal(), d) == true) {
                lose = new JDialog(f, "Win");
                ll = new JLabel("Win");
            } else if (h.checkGame(p.checkTotal(), d.checkTotal(), d) == false) {
                if (h.checkDraw(p.checkTotal(), d.checkTotal(), d) == true) {
                    lose = new JDialog(f, "Draw");
                    ll = new JLabel("Draw");
                } else {
                    lose = new JDialog(f, "Win");
                    ll = new JLabel("Win");
                }
            } else {
                lose = new JDialog(f, "Lost");
                ll = new JLabel("Lost");
            }
            lose.add(ll);
                lose.setSize(100, 100);
                lose.setVisible(true);
                buttonStand.addActionListener(ev -> {
                p.resetTotal();
                d.resetTotal();
                });
        });
        //properties of the frame
        f.setSize(1000,500);
        f.setLayout(null);  
        f.setVisible(true);
    }
}