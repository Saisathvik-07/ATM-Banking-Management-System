package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pinnumber) {

        setTitle("Mini Statement");

        setLayout(null);

        // Bank Name
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 200, 20);
        add(bank);

        // Card Number
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        // Transactions
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        // Balance
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {

            Conn c = new Conn();

            // Fetch Card Number
            ResultSet rs = c.s.executeQuery(
                "select * from login where pin = '" + pinnumber + "'"
            );

            while (rs.next()) {

                card.setText(
                    "Card Number: " +
                    rs.getString("cardnumber").substring(0, 4)
                    + "XXXXXXXX"
                    + rs.getString("cardnumber").substring(12)
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {

            int bal = 0;

            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery(
                "select * from bank where pin = '" + pinnumber + "'"
            );

            while (rs.next()) {

                mini.setText(
                    mini.getText()
                    + "<html>"
                    + rs.getString("date")
                    + "&nbsp;&nbsp;&nbsp;&nbsp;"
                    + rs.getString("type")
                    + "&nbsp;&nbsp;&nbsp;&nbsp;"
                    + rs.getString("amount")
                    + "<br><br><html>"
                );

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

            balance.setText("Your Current Balance is Rs " + bal);

        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
    }

    public static void main(String[] args) {

        new MiniStatement("");
    }
}