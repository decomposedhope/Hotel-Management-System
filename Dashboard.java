package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JMenuBar men;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    public Dashboard(){

        JLabel l1 = new JLabel("HOTEL NEPTUNE WELCOMES YOU");
        l1.setBounds(550,80,500,30);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Tohoma",Font.BOLD,28));
        add(l1);

        men = new JMenuBar();
        add(men);
        m1 = new JMenu("Hotel Management");
        men.add(m1);
        m2 = new JMenu("Admin Work");
        men.add(m2);

        i1 = new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);
        i2 = new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);
        i3 = new JMenuItem("Add Rooms");
        i3.addActionListener(this);
        m2.add(i3);
        i4 = new JMenuItem("Add Drivers");
        i4.addActionListener(this);
        m2.add(i4);
        men.setBounds(0,0,1950,30);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management_system/icons/3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(0,0,1950,1000);
        add(j1);

        setLayout(null);
        setBounds(0,0,1950,1000);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Reception")){
            new Reception().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee().setVisible(true);
        }
        else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRooms().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Drivers")){
            new AddDrivers().setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Dashboard().setVisible(true);
    }
}
