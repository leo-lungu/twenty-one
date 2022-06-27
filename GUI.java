/**
 * The GUI class creates the GUI
 * which has different panels
 * and calls other classes
 * and methods in order to do the
 * back-end work.
 */

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
        JLabel l = new JLabel();
        l.setText(p.totalScore());
    
        buttonExit.setLayout(null);
        buttonExit.setBounds(475, 400, 50, 40);
        buttonHit.setBounds(400, 400, 50, 40);
        buttonStand.setBounds(550, 400, 50, 40);
        l.setBounds(50, 50, 150, 50);
        
        f.add(buttonExit);
        f.add(buttonHit);
        f.add(buttonStand);
        f.add(l);


        buttonExit.addActionListener(e -> { //when exit button is clicked, it saves the progress of the account and the prices
            System.exit(0); //and exits the program
        });

        buttonHit.addActionListener(e -> { //when reset button is clicked, it resets the balance and asset held by the account
            p.setCardArray(p.getCard());
            System.out.println(p.getCardArray());
            p.totalScore();
            if (p.checkTotal() == 21) {
                while (h.checkGame(p.checkTotal(), d.checkTotal(), d) == false) {
                    h.checkGame(p.checkTotal(), d.checkTotal(), d);
                }
                JDialog win = new JDialog(f, "dialog Box");
            } else if (p.checkTotal() > 21) {
                System.out.println("Lost");
                JDialog lose = new JDialog(f, "dialog Box");
                JLabel ll = new JLabel("this is a dialog box");
                lose.add(ll);
                lose.setSize(100, 100);
                lose.setVisible(true);
                JButton buttonReset = new JButton("Stand");
                buttonReset.setBounds(550, 400, 50, 40);
                lose.add(buttonReset);
                buttonHit.addActionListener(ev -> {
                    p.resetTotal();
                    d.resetTotal();
                });
            }
        });

        //properties of the frame
        f.setSize(1000,500);
        f.setLayout(null);  
        f.setVisible(true);
    }
}