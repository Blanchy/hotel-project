import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class ReceiptTester {

    public static void main(String[] args) {

    JFrame mainFrame = new JFrame("Receipt Choice");

        JButton simple = new JButton("Simple Receipt");
        JButton comprehensive = new JButton("Comprehensive Receipt");

        simple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleReceipt receipt = new SimpleReceipt();

            }
        });

        comprehensive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComprehensiveReceipt receipt = new ComprehensiveReceipt();

            }
        });


        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(simple);
        buttonPanel.add(comprehensive);

        mainFrame.setSize(400,400);

        mainFrame.add(buttonPanel);

        mainFrame.setVisible(true);



    }
}
