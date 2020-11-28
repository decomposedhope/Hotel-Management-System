package hotel_management_system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable t1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b1,b2;
    public CustomerInfo(){

        t1 = new JTable();
        t1.setBounds(0,40,1100,470);
        add(t1);

        l1 = new JLabel("UserID");
        l1.setBounds(35, 11, 46, 14);
        add(l1);

        l2 = new JLabel("ID Number");
        l2.setBounds(160, 11, 86, 14);
        add(l2);

        l3 = new JLabel("Name");
        l3.setBounds(293, 11, 46, 14);
        add(l3);

        l4 = new JLabel("Gender");
        l4.setBounds(446, 11, 46, 14);
        add(l4);

        l5 = new JLabel("Address");
        l5.setBounds(576, 11, 56, 14);
        add(l5);

        l6 = new JLabel("Room Number");
        l6.setBounds(716, 11, 86, 14);
        add(l6);

        l7 = new JLabel("CheckedIn");
        l7.setBounds(846, 11, 106, 14);
        add(l7);

        l8 = new JLabel("Money Deposited");
        l8.setBounds(986, 11, 106, 14);
        add(l8);

        b1 = new JButton("Load data");
        b1.setBounds(350,530,120,30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(530,530,120,30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        add(b2);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(400,180,1110,610);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String emp = "select * from customer";
            connector c = new connector();
            try{
                ResultSet rs = c.s.executeQuery(emp);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(SQLException e){
                System.out.println(e);
            }

        }
        else if(ae.getSource()==b2)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {

        new CustomerInfo().setVisible(true);
    }
}
