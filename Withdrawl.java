package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    Withdrawl(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Maximum Withdrawal is Rs 10,000");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        JLabel text2 = new JLabel("Please Enter your amount");
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System", Font.BOLD, 16));
        text2.setBounds(170, 330, 400, 20);
        image.add(text2);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 370, 320, 25);
        image.add(amount);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == withdraw) {

            String number = amount.getText();

            java.util.Date date = new java.util.Date();

            if (number.equals("")) {

                JOptionPane.showMessageDialog(null, "Please enter amount");

            } else {

                try {

                    Conn conn = new Conn();

                    ResultSet rs = conn.s.executeQuery(
                            "select * from bank where pin = '" + pinnumber + "'");

                    int balance = 0;

                    while (rs.next()) {

                        if (rs.getString("type").equals("Deposit")) {

                            balance += Integer.parseInt(rs.getString("amount"));

                        } else {

                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(number)) {

                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    String query = "insert into bank(pin, date, type, amount) values('"
                            + pinnumber + "','"
                            + date + "','Withdrawl','"
                            + number + "')";

                    conn.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Withdraw Successful");

                    setVisible(false);

                    new Transactions(pinnumber).setVisible(true);

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e);
                }
            }

        } else if (ae.getSource() == back) {

            setVisible(false);

            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {

        new Withdrawl("");
    }
}