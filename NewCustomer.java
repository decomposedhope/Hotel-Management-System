package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.*;

public class NewCustomer extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    Choice ch1;
    JComboBox c1,c2,c3;
    
    public NewCustomer(){

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel_management_system/icons/8.jpg"));
        Image i3 = i1.getImage().getScaledInstance(900, 1200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l8 = new JLabel(i2);
        l8.setBounds(440,10,340,600);
        add(l8);

        setBounds(500,100,800,600);
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40,50,100,30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(190,50,150,30);
        add(t1);
        
         JLabel l2 = new JLabel("UserID");
        l2.setBounds(40,100,100,30);
        add(l2);

        String id[]= {"Aadhar card", "Driving License", "Passport"};
        c1 = new JComboBox(id);
        c1.setBounds(190,100,150,30);
        c1.setBackground(Color.white);
        add(c1);

        JLabel l9 = new JLabel("UserID number");
        l9.setBounds(40,150,100,30);
        add(l9);

        t4 = new JTextField();
        t4.setBounds(190,150,150,30);
        add(t4);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(40,200,100,30);
        add(l3);

        String gender[]= {"Male","Female","Others"};
        c2 = new JComboBox(gender);
        c2.setBounds(190,200,150,30);
        c2.setBackground(Color.white);
        add(c2);
        
        JLabel l4 = new JLabel("Address");
        l4.setBounds(40,250,100,30);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(190,250,240,30);
        add(t2);
        
        JLabel l5 = new JLabel("Room No.(Allocated)");
        l5.setBounds(40,300,150,30);
        add(l5);
        
        ch1 = new Choice();
        try{
            connector c = new connector();
            String str = "select * from room where availability = 'Available'";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                ch1.add(rs.getString("room_number"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        ch1.setBounds(190,305,150,30);
        ch1.setBackground(Color.white);
        add(ch1);

        JLabel l12 = new JLabel("Price");
        l12.setBounds(40,350,150,30);
        add(l12);
        t5 = new JTextField();
        ImageIcon i12 = new ImageIcon((ClassLoader.getSystemResource("hotel_management_system/icons/9.png")));
        Image i21 = i12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i31 = new ImageIcon(i21);
        b3= new JButton(i31);
        b3.setBounds(350,305,20,20);
        b3.addActionListener(this);
        add(b3);
        
        t5.setBounds(190,355,150,30);
        t5.setBackground(Color.white);
        add(t5);

        JLabel l6 = new JLabel("Checked In");
        l6.setBounds(40,400,150,30);
        add(l6);

        c3 = new JComboBox(new String[]{"CheckedIn","CheckedOut"});
        c3.setBounds(190,400,150,30);
        c3.setBackground(Color.white);
        add(c3);


        JLabel l7 = new JLabel("Money Deposited");
        l7.setBounds(40,450,150,30);
        add(l7);
        
        t3 = new JTextField();
        t3.setBounds(190,450,150,30);
        add(t3);
        
        b1 = new JButton("Add");
        b1.setBounds(130,500,100,30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(250,500,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){

            String s1 = (String)c1.getSelectedItem();
            String s2 = t4.getText();
            String s3 = t1.getText();
            String s4 = (String)c2.getSelectedItem();
            String s5 = t2.getText();
            String s6 = ch1.getSelectedItem();
            String s7 = (String)c3.getSelectedItem();
            String s8 = t3.getText();
            String insert = "insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
            String update = "update room set availability = 'Occupied' where room_number = "+s6;
            try{
                connector c = new connector();
                c.s.executeUpdate(insert);
                c.s.executeUpdate(update);
                JOptionPane.showMessageDialog(null,"New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);

            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b3){
            connector c = new connector();
            String rate = (String)ch1.getSelectedItem();
            String str = "select * from room where room_number='"+rate+"'";

            try{
                ResultSet rs=c.s.executeQuery(str);
                while (rs.next()) {
                    t5.setText(rs.getString("price"));
                }

            }catch(Exception ee){
                System.out.println(ee);
            }
        }
    }
    
    public static void main(String args[]){
        new NewCustomer();
    }
}

























































