package bank.management.system;


import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
    

public class SignupTwo extends JFrame implements ActionListener{
   
    JComboBox religion,Category,income,occup,education;
    JTextField Pan,aadhar;
    JButton next;
    JRadioButton sncs,sno,yes,no;
    String formno;
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
   
        setTitle("New Account Application Page 2:");
       
        /*Personal Details*/
        
        JLabel Additional=new JLabel("Page 2:Additional Details");
        Additional.setFont(new Font("Railway",Font.BOLD,22));
        Additional.setBounds(290,80,400,30);
        add(Additional);
        
        JLabel name=new JLabel("Religion");
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] ={"Hindu","Muslim","Sikh","Christian","others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Railway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String[] valCategory = {"General", "OBC", "SC", "ST"};
        Category = new JComboBox(valCategory);
        Category.setBounds(300,190,400,30);
        Category.setBackground(Color.WHITE);
        add(Category);
        
        /*fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Railways",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        */
        JLabel Income=new JLabel("Income:");
        Income.setFont(new Font("Railway",Font.BOLD,20));
        Income.setBounds(100,240,200,30);
        add(Income);
        
        String[] valincome = {"Null", "<1,50,000", "< 2,00,000", "<2,50,00","< 3,00,00","< 3,50,00","<4,00,000"," > 4,00,000"};
        income = new JComboBox(valincome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
   
        
        
        JLabel Educational=new JLabel("Educational");
        Educational.setFont(new Font("Railway",Font.BOLD,20));
        Educational.setBounds(100,290,200,30);
        add(Educational);
        
        
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Railway",Font.BOLD,20));
        qualification.setBounds(100,320,200,30);
        add(qualification);
        
        String[] valEducation = {"Non-Graducation", "Graducation", "Pg", "others"};
        education = new JComboBox(valEducation);
        education.setBounds(300,320,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
       
        
        
        JLabel occupation=new JLabel("Occupication:");
        occupation.setFont(new Font("Railway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        String[] valOccupation = {"Salaried", "Self Employeed", "Business", "Student","Other"};
        occup = new JComboBox(valOccupation);
        occup.setBounds(300,390,400,30);
        occup.setBackground(Color.WHITE);
        add(occup);
     
        
        JLabel pan=new JLabel("Pan No:");
        pan.setFont(new Font("Railway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        Pan=new JTextField();
        Pan.setFont(new Font("Railways",Font.BOLD,14));
        Pan.setBounds(300,440,400,30);
        add(Pan);
        
        
        JLabel Aadhar=new JLabel("Aadhar no:");
        Aadhar.setFont(new Font("Railway",Font.BOLD,20));
        Aadhar.setBounds(100,490,200,30);
        add(Aadhar);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Railways",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        
        JLabel senior=new JLabel("Senior citizen:");
        senior.setFont(new Font("Railway",Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);
        
       sncs=new JRadioButton("Yes");
       sncs.setBounds(300,540,100,30);
       sncs.setBackground(Color.WHITE);
       add(sncs);
       
       sno=new JRadioButton("No");
       sno.setBounds(450,540,100,30);
       sno.setBackground(Color.WHITE);
       add(sno);
     
       ButtonGroup m=new ButtonGroup();
       m.add(sncs);
       m.add(sno);
    
        
        JLabel exisiting=new JLabel("Exisiting Account:");
        exisiting.setFont(new Font("Railway",Font.BOLD,20));
        exisiting.setBounds(100,590,200,30);
        add(exisiting);
        
       yes=new JRadioButton("Yes");
       yes.setBounds(300,590,100,30);
       yes.setBackground(Color.WHITE);
       add(yes);
       
       no=new JRadioButton("No");
       no.setBounds(450,590,100,30);
       no.setBackground(Color.WHITE);
       add(no);
     
       ButtonGroup e=new ButtonGroup();
       e.add(yes);
       e.add(no);
        
        
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railways",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)Category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occup.getSelectedItem();
        String senior=null;
        if(sncs.isSelected()){
            senior="Yes";
        }
        else if(sno.isSelected()){
            senior="No";
        }
        
        String exist = null;
        if(yes.isSelected()){
            exist ="Yes";
        }
        else if(no.isSelected()){
            exist ="No";
        }
        
        String pan=Pan.getText();
        String saadhar=aadhar.getText();
       
        try{
           
                Conn c=new Conn();
                String query= "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+senior+"','"+exist+"','"+pan+"','"+saadhar+"')";
                c.s.executeUpdate(query);
            if(ae.getSource() == next){

                setVisible(false);
                new SignupThree(formno);
}
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupTwo("");
    }

}
    

