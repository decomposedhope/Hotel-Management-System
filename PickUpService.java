package hotel_management_system;

import java.awt.*;

import java.sql.*;
import javax.swing.*;


import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class PickUpService extends JFrame {


    JTable table;
    JLabel L1,L2,name,lblNewLabel,lblAvailable,lblAirport,lblDateOfThe,lblTypeOfDriver,lblGender;
    JButton btnExit,btnRegister;
    JComboBox c1;

    public PickUpService()
    {

        setBounds(530, 200, 800, 600);
        setLayout(null);

        L1 = new JLabel("Pick Up Service");
        L1.setFont(new Font("Tahoma", Font.BOLD, 20));
        L1.setBounds(300, 11, 158, 25);
        add(L1);

        L2 = new JLabel("Type of Vehicle");
        L2.setBounds(32, 97, 89, 14);
        add(L2);

        btnRegister = new JButton("Display");
        btnRegister.setBounds(200, 500, 120, 30);
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setForeground(Color.WHITE);

        btnExit = new JButton("Back");
        btnExit.setBounds(420, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);

        add(btnRegister);
        add(btnExit);


        table = new JTable();
        table.setBounds(0, 233, 800, 250);
        add(table);

        name = new JLabel("Name");
        name.setBounds(30, 208, 46, 14);
        add(name);

        lblNewLabel = new JLabel("Age");
        lblNewLabel.setBounds(175, 208, 46, 14);
        add(lblNewLabel);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(300, 208, 46, 14);
        add(lblGender);

        lblTypeOfDriver = new JLabel("Vehicle type");
        lblTypeOfDriver.setBounds(430, 208, 80, 14);
        add(lblTypeOfDriver);

        lblDateOfThe = new JLabel("Available");
        lblDateOfThe.setBounds(570, 208, 105, 14);
        add(lblDateOfThe);

        lblAirport = new JLabel("Location");
        lblAirport.setBounds(700, 208, 86, 14);
        add(lblAirport);

        String Type[] = {"Sedan","Hatchback","Bus"};
        c1 = new JComboBox(Type);
        c1.setBackground(Color.white);
        c1.setBounds(123, 94, 150, 25);
        add(c1);


        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String SQL = "select * from driver where vehicleType = '"+(String)c1.getSelectedItem()+"'";
                try{

                    connector c = new connector();
                    ResultSet rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));


                }catch (Exception ss)
                {
                    System.out.println(ss);;
                }


            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });


    }
    public static void main(String[] args)
    {
        new PickUpService().setVisible(true);
    }


}