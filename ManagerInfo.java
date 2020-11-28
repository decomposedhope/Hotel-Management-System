package hotel_management_system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerInfo extends JFrame implements ActionListener {

    JTable t1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b1,b2;
    public ManagerInfo(){

        t1 = new JTable();
        t1.setBounds(0,40,1000,470);
        add(t1);

        l1 = new JLabel("Name");
        l1.setBounds(41, 11, 46, 14);
        add(l1);

        l2 = new JLabel("Age");
        l2.setBounds(159, 11, 46, 14);
        add(l2);

        l3 = new JLabel("Gender");
        l3.setBounds(273, 11, 46, 14);
        add(l3);

        l4 = new JLabel("Job");
        l4.setBounds(416, 11, 86, 14);
        add(l4);

        l5 = new JLabel("Salary");
        l5.setBounds(536, 11, 86, 14);
        add(l5);

        l6 = new JLabel("Phone");
        l6.setBounds(656, 11, 86, 14);
        add(l6);

        l7 = new JLabel("Aadhar");
        l7.setBounds(786, 11, 86, 14);
        add(l7);

        l8 = new JLabel("Email");
        l8.setBounds(896, 11, 86, 14);
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
        setBounds(450,180,1000,610);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String emp = "select * from employee where job='Manager'";
            connector c = new connector();
            try{
                ResultSet rs = c.s.executeQuery(emp);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
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
        new ManagerInfo().setVisible(true);
    }
}
