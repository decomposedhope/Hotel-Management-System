package hotel_management_system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RoomsInfo extends JFrame implements ActionListener{
    private JButton b1, b2;
    private JTable t1;
    private JMenuBar mb1;
    JLabel l1,l2,l3,l4;
    RoomsInfo(){
        ImageIcon i1 = new ImageIcon((ClassLoader.getSystemResource("hotel_management_system/icons/7.jpg")));
        JLabel l5 = new JLabel(i1);
        l5.setBounds(0,0,900,675);
        add(l5);
        t1 = new JTable();
        t1.setOpaque(false);
        t1.setBounds(0,40,900,470);
        l5.add(t1);

        l1 = new JLabel("Room Number");
        l1.setBounds(60, 15, 100, 14);
        l5.add(l1);

        l2 = new JLabel("Availability");
        l2.setBounds(330, 15, 100, 14);
        l5.add(l2);

        l3 = new JLabel("Price");
        l3.setBounds(556, 15, 100, 14);
        l5.add(l3);

        l4 = new JLabel("Bed Type");
        l4.setBounds(780, 15, 100, 14);
        l5.add(l4);

        b1 = new JButton("View");
        b1.setBounds(300,590,120,30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        l5.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(550,590,120,30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        l5.add(b2);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(450,140,900,675);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent E){
        if(E.getSource()==b1){
            String room = "select * from room";
            connector c = new connector();
            try{
                ResultSet rs = c.s.executeQuery(room);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(E.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String args[]){

        new RoomsInfo().setVisible(true);
    }
}




















