package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener {


    JButton b1,b2;
    JTextField t1,t2,t5,t6,t7,t8;
    JComboBox t3,t4;
    public AddEmployee(){
        JLabel name = new JLabel("NAME");
       name.setFont(new Font("Tohoma",Font.PLAIN,17));
       name.setBounds(60,30,120,30);
       add(name);

       t1 = new JTextField();
       t1.setBounds(200,30,150,30);
       add(t1);

        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tohoma",Font.PLAIN,17));
        age.setBounds(60,80,120,30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(200,80,150,30);
        add(t2);

        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tohoma",Font.PLAIN,17));
        gender.setBounds(60,130,120,30);
        add(gender);

        String Gender[]={"Male","Female","Other"};
        t3 = new JComboBox(Gender);
        t3.setBounds(200,130,150,30);
        t3.setBackground(Color.white);
        add(t3);

        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Tohoma",Font.PLAIN,17));
        job.setBounds(60,180,120,30);
        add(job);

        String Job[] ={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
         t4 = new JComboBox(Job);
        t4.setBounds(200,180,150,30);
        t4.setBackground(Color.white);
        add(t4);

        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Tohoma",Font.PLAIN,17));
        salary.setBounds(60,230,120,30);
        add(salary);

        t5 = new JTextField();
        t5.setBounds(200,230,150,30);
        add(t5);

        JLabel phone = new JLabel("PHONE NO.");
        phone.setFont(new Font("Tohoma",Font.PLAIN,17));
        phone.setBounds(60,280,120,30);
        add(phone);

        t6 = new JTextField();
        t6.setBounds(200,280,150,30);
        add(t6);

        JLabel aadhar = new JLabel("AADHAR NO.");
        aadhar.setFont(new Font("Tohoma",Font.PLAIN,17));
        aadhar.setBounds(60,330,120,30);
        add(aadhar);

        t7 = new JTextField();
        t7.setBounds(200,330,150,30);
        add(t7);

        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tohoma",Font.PLAIN,17));
        email.setBounds(60,380,120,30);
        add(email);

        t8 = new JTextField();
        t8.setBounds(200,380,150,30);
        add(t8);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(60,430,130,30);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(200,430,130,30);
        b2.addActionListener(this);
        add(b2);
        setLayout(null);
        setBounds(400,100,600,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b1) {
           String name = t1.getText();
           String age = t2.getText();
           String gender = (String) t3.getSelectedItem();
           String job = (String) t4.getSelectedItem();
           String salary = t5.getText();
           String phone = t6.getText();
           String aadhar = t7.getText();
           String email = t8.getText();
           connector c = new connector();
           String str = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "','" + aadhar + "', '" + email + "')";

           try {
               c.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null, "New Employee Added");
               this.setVisible(false);
           } catch (Exception e) {
               System.out.println(e);
           }
       }
       else if(ae.getSource()==b2){
           this.setVisible(false);
       }
    }

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }
}
