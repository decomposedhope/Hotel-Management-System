package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddRooms extends JFrame implements ActionListener {
    JTextField t1,t2;
    JComboBox c1,c2;
    JButton b1,b2;
    public AddRooms(){
        setBounds(350,80,1024,664);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel_management_system/icons/5.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1024,664);
        add(l1);
        JLabel l2 = new JLabel("Add Rooms");
        l2.setFont(new Font("Tohoma",Font.BOLD,20));
        l2.setBounds(380,40,500,20);
        l1.add(l2);
        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("Tahoma", Font.BOLD, 16));
        room.setBounds(180, 190, 500, 22);
        l1.add(room);
        t1 = new JTextField();
        t1.setBackground(Color.lightGray);
        t1.setBounds(300,185,120,30);
        l1.add(t1);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma", Font.BOLD, 16));
        available.setBounds(180, 230, 500, 22);
        l1.add(available);
        c1 = new JComboBox(new String[]{"Available","Occupied"});

        c1.setBounds(300,230,120,30);
        c1.setBackground(Color.lightGray);
        l1.add(c1);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma", Font.BOLD, 16));
        price.setBounds(180, 280, 500, 22);
        l1.add(price);

        t2 = new JTextField();
        t2.setBounds(300,280,120,30);
        t2.setBackground(Color.lightGray);
        l1.add(t2);

        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Tahoma", Font.BOLD, 16));
        type.setBounds(180, 330, 500, 22);
        l1.add(type);

        c2 = new JComboBox(new String[]{"Single","Double"});
        c2.setBounds(300,330,120,30);
        c2.setBackground(Color.lightGray);
        l1.add(c2);

        b1 = new JButton("Add Room");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(300,380,120,30);
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setBounds(440,380,120,30);
        b2.addActionListener(this);
        l1.add(b2);

        setLayout(null);//using no layout managers

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1) {
            String room = t1.getText();
            String available = (String) c1.getSelectedItem();
            String price = t2.getText();
            String type = (String) c2.getSelectedItem();

            connector c = new connector();
            String str = "INSERT INTO room (room_number,availability,price,bed_type) values( '" + room + "', '" + available + "','" + price + "', '" + type + "')";

            try {

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room Added");
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

        new AddRooms().setVisible(true);
    }
}

