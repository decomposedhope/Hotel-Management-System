package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class CheckOut extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new CheckOut().setVisible(true);
    }
    Choice c1,c2;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2,b3,b4;
    public CheckOut(){
        setBounds(500, 200, 950, 500);
        setLayout(null);
        JLabel l1 = new JLabel("Check-Out Details");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setBounds(124, 11, 222, 25);
        add(l1);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel_management_system/icons/11.jpg"));
        JLabel l2 = new JLabel(i1);
        l2.setBounds(450,70,476,270);
        add(l2);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setBounds(25, 88, 46, 14);
        add(lblNewLabel);

        c1 = new Choice();
        try{
            connector c = new connector();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        c1.setBounds(248, 85, 140, 20);
        add(c1);


        JLabel l3 = new JLabel("Room Number ");
        l3.setBounds(25, 129, 107, 14);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(248, 126, 140, 20);
        add(t1);

        JLabel l4 = new JLabel("Name ");
        l4.setBounds(25, 174, 97, 14);
        add(l4);

        JLabel l5 = new JLabel("Checked-in ");
        l5.setBounds(25, 216, 107, 14);
        add(l5);

        JLabel l6 = new JLabel("Amount Paid (Rs) ");
        l6.setBounds(25, 261, 107, 14);
        add(l6);

        JLabel l8 = new JLabel("Days Stayed ");
        l8.setBounds(25, 302, 150, 14);
        add(l8);

        JLabel l7 = new JLabel("Pending Amount (Rs) : ");
        l7.setBounds(25, 342, 150, 14);
        add(l7);

        t2 = new JTextField();
        t2.setBounds(248, 171, 140, 20);
        add(t2);

        t3 = new JTextField();
        t3.setBounds(248, 216, 140, 20);
        add(t3);

        t4 = new JTextField();
        t4.setBounds(248, 258, 140, 20);
        add(t4);

        t5 = new JTextField();
        t5.setBounds(248, 299, 140, 20);
        add(t5);

        t6 = new JTextField();
        t6.setBounds(248, 339, 140, 20);
        add(t6);

        b1 = new JButton("Checkout");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(120,400,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(350,400,120,30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i12 = new ImageIcon((ClassLoader.getSystemResource("hotel_management_system/icons/9.png")));
        Image i2 = i12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3= new JButton(i3);
        b3.setBounds(400,85,20,20);
        b3.addActionListener(this);
        add(b3);

        b4= new JButton(i3);
        b4.setBounds(400,298,20,20);
        b4.addActionListener(this);
        add(b4);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1){
            connector c = new connector();
            String Id=c1.getSelectedItem();
            String room = t1.getText();
            String str1 = "delete from customer where number = '"+Id+"'";
            String str2 = "update room set availability ='Available' where room_number = '"+room+"'";
            try{
                c.s.executeUpdate(str1);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Check-Out Successful");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b3){
            connector c = new connector();
            String Id=c1.getSelectedItem();

            String str2="select * from customer where number = '"+Id+"'";
            try{
                ResultSet rs=c.s.executeQuery(str2);
                while (rs.next()) {
                    t1.setText(rs.getString("room_number"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));

                }

            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b4){
            connector c = new connector();
            String room = t1.getText();
            String pending;
            int rate,total;
            int days = Integer.parseInt(t5.getText());
            int previous = Integer.parseInt(t4.getText());
            String str2="select * from room where room_number = '"+room+"'";
            try{
                ResultSet rs=c.s.executeQuery(str2);
                while (rs.next()) {
                    rate= Integer.parseInt(rs.getString("price"));
                    total = previous - (rate*days);
                    pending = Integer.toString(total);
                    t6.setText(pending);
                }

            }catch(Exception ee){
                System.out.println(ee);
            }
        }
        }
    }


