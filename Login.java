package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {

    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    public Login(){

        setBounds(500,250,612,408);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management_system/icons/2.jpg"));
        JLabel l3 = new JLabel(i1);
        l3.setBounds(0,0,612,408);
        add(l3);
        l1=new JLabel("Username");
        l1.setBounds(50,60,100,30);
        l1.setForeground(Color.white);
        l3.add(l1);
        l2=new JLabel("Password");
        l2.setForeground(Color.white);
        l2.setBounds(50,100,100,30);
        l3.add(l2);

        t1= new JTextField();
        t1.setBounds(170,60,150,30);
        l3.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(170,100,150,30);
        l3.add(t2);

        b1= new JButton("Login");
        b1.setBackground(Color.darkGray);
        b1.setForeground(Color.white);
        b1.setBounds(170,143,150,32);
        b1.addActionListener(this);
        l3.add(b1);

        setLayout(null);//using no layout managers

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String username = t1.getText();
        String password = t2.getText();
        connector c1= new connector();
        String str = "select * from login where username = '"+username+"'and password = '"+password+"'";
        try {
            ResultSet rs= c1.s.executeQuery(str);

            if(rs.next()){
                new Dashboard().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
            }
            this.setVisible(false);
        }catch(SQLException e){
            System.out.println(e);;
        }
        }
    public static void main(String[] args) {
        new Login();
    }
}
