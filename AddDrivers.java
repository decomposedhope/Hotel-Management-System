package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddDrivers extends JFrame implements ActionListener {

    JTextField t1,t2,t5;
    JComboBox t3,t4,t6;
    JButton b1,b2;
    public AddDrivers(){
        JLabel title = new JLabel("Add Drivers");
        title.setBounds(150,10,150,30);
        title.setFont(new Font("Tohoma", Font.BOLD,20));
        add(title);

        JLabel name = new JLabel("Name");
        name.setBounds(60,70,100,30);
        name.setFont(new Font("Tohoma", Font.PLAIN,14));
        add(name);

        t1 = new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);

        JLabel age = new JLabel("Age");
        age.setBounds(60,110,100,30);
        age.setFont(new Font("Tohoma", Font.PLAIN,14));
        add(age);

        t2 = new JTextField();
        t2.setBounds(200,110,150,30);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(60,150,100,30);
        gender.setFont(new Font("Tohoma", Font.PLAIN,14));
        add(gender);

        String Gender[]={"Male","Female","Other"};
        t3 = new JComboBox(Gender);
        t3.setBounds(200,150,150,30);
        t3.setBackground(Color.white);
        add(t3);

        JLabel status = new JLabel("Available");
        status.setBounds(60,190,100,30);
        status.setFont(new Font("Tohoma", Font.PLAIN,14));
        add(status);

        String available[] = {"Available","Not Available"};
        t4 = new JComboBox(available);
        t4.setBounds(200,190,150,30);
        t4.setBackground(Color.white);
        add(t4);

        JLabel location = new JLabel("Location");
        location.setBounds(60,230,100,30);
        location.setFont(new Font("Tohoma", Font.PLAIN,14));
        add(location);

        t5 = new JTextField();
        t5.setBounds(200,230,150,30);
        add(t5);

        JLabel type = new JLabel("Vehicle Type");
        type.setBounds(60,270,100,30);
        type.setFont(new Font("Tohoma", Font.PLAIN,14));
        add(type);

        String Type[] = {"Sedan","Hatchback","Bus"};
        t6 = new JComboBox(Type);
        t6.setBackground(Color.white);
        t6.setBounds(200,270,150,30);
        add(t6);

        b1 = new JButton("Add ");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60,350,130,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(210, 350, 130, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        setLayout(null);
        setBounds(400,200,600,470);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1) {
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String) t3.getSelectedItem();
            String status = (String) t4.getSelectedItem();
            String location = t5.getText();
            String type = (String) t6.getSelectedItem();
            connector c = new connector();
            String str = "INSERT INTO driver values( '" + name + "', '" + age + "', '" + gender + "','" + type +"', '" + status + "', '" + location + "')";

            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Driver Added");
                new Dashboard().setVisible(true);
                this.setVisible(false);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2){

            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }
}
