package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
  //JFrame provides window to do operation
    public HotelManagementSystem(){
        setBounds(200,50,1013,768); //Dimensions and position for our Window
        ImageIcon t1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management_system/icons/1.jpg"));
        JLabel j1 = new JLabel(t1);
        j1.setBounds(0,0,1013,768);
        add(j1);
        JLabel j2 = new JLabel("Hotel Neptune Management System");
        j2.setBounds(20,300,350,825);
        j2.setForeground(Color.CYAN);
        j2.setFont(new Font("Serif",Font.ITALIC,23));
        j1.add(j2);
        JButton b1 = new JButton("Next");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.CYAN);
        b1.setBounds(870,700,100,30);
        b1.addActionListener(this);
        j1.add(b1);
        setVisible(true);
        setLayout(null);//using no layout managers


    }
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);//because in frame set visible is by default false
        this.setVisible(false);//because we have to close our main window when login window opens
    }
    public static void main(String[] args) {

        new HotelManagementSystem();
    }
}
