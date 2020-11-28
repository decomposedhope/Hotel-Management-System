package hotel_management_system;

import javax.swing.*;
import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener{

	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	public static void main(String[] args) {

		new Reception();
	}
	
	public Reception(){
		
		setBounds(530, 150, 800, 550);

		setLayout(null);
		b1 = new JButton("New Customer Form");
		b1.setBounds(10, 50, 200, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Room Info");
		b2.setBounds(10, 100, 200, 30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("All Employee Info");
		b3.setBounds(10, 150, 200, 30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		add(b3);
		
		b4 = new JButton("Customer Info");
		b4.setBounds(10, 200, 200, 30);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.addActionListener(this);
		add(b4);
		
		b5 = new JButton("Manager Info");

		b5.setBounds(10, 250, 200, 30);
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.addActionListener(this);
		add(b5);
		
		b6 = new JButton("Check Out");
		b6.setBounds(10, 300, 200, 30);
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.addActionListener(this);
		add(b6);
		
		b7 = new JButton("Pick up Service");
		b7.setBounds(10, 350, 200, 30);
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.addActionListener(this);
		add(b7);

		b8 = new JButton("Search Room");
		b8.setBounds(10, 400, 200, 30);
		b8.setBackground(Color.BLACK);
		b8.setForeground(Color.WHITE);
		b8.addActionListener(this);
		add(b8);
		
		b9 = new JButton("Log Out");
		b9.setBounds(10, 450, 200, 30);
		b9.setBackground(Color.BLACK);
		b9.setForeground(Color.WHITE);
		b9.addActionListener(this);
		add(b9);

		ImageIcon i1 = new ImageIcon((ClassLoader.getSystemResource("hotel_management_system/icons/6.jpg")));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(250,30,500,450);
		add(l1);
		setBackground(Color.WHITE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
			new NewCustomer().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b2){
			new RoomsInfo().setVisible(true);
			this.setVisible(false);
		}

		else if(ae.getSource()==b3){
			new EmployeeInfo().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b4){
			new CustomerInfo().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b5){
			new ManagerInfo().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b6){
			new CheckOut().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b7){
			new PickUpService().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b8){
			new SearchRoom().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b9){
			new Login().setVisible(true);
			setVisible(false);
		}



	}
}


