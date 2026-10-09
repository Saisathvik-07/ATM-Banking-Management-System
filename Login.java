
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton SignUp,Login,Clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("Automated Teller Machine");/*Used for title*/
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        /*  Welcome*/
        JLabel text=new JLabel("Welcome in ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);
        text.setBounds(200,40,400,40);
 
        /*Card Name*/
        
         JLabel card=new JLabel("Card No:");
        card.setFont(new Font("Railway",Font.BOLD,28));
       
        add(card);
        card.setBounds(120,150,150,30);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,30);
        add(cardTextField);
        
        /*Pin*/
         JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Railway",Font.BOLD,26));
        add(pin);
        pin.setBounds(120,220,250,40);
        
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        add(pinTextField);
        
        /*Button*/
        Login=new JButton("Sign In");
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.setBounds(300,300,100,30);
        Login.addActionListener(this);
        add(Login);
        
        Clear=new JButton("Clear");
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.setBounds(430,300,100,30);
        Clear.addActionListener(this);
        add(Clear);
        
        SignUp=new JButton("Sign Up");
        SignUp.setBackground(Color.BLACK);
        SignUp.setForeground(Color.WHITE);
        SignUp.setBounds(300,350,230,30);
        SignUp.addActionListener(this);
        add(SignUp);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);/*Size of the tab*/
        setVisible(true);/*Used for visible for users*/
        setLocation(350,200);/*This helps to open the border from center*/
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Clear){
            cardTextField.setText("Enter Your Card Number");
        }
        else if(ae.getSource() == Login){

    Conn conn = new Conn();

    String cardnumber = cardTextField.getText();
    String pinnumber = String.valueOf(pinTextField.getPassword());

    try{

        String query = "select * from login where cardnumber='"+cardnumber+"' and pin = '"+pinnumber+"'";

        ResultSet rs = conn.s.executeQuery(query);

        if(rs.next()){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
        }

    } catch(Exception e){
        System.out.println(e);
    }
        }

        else if(ae.getSource() == SignUp){
        
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    
    }
    public static void main(String args[]){
        new Login();
        
    }

}
