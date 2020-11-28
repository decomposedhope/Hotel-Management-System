
package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class SearchRoom extends JFrame implements ActionListener {

    JCheckBox c2;
    JButton b1,b2;
    JComboBox c1;
    JTable t1;
    JLabel l1,l2,l3,l4,l6,l7;
    SearchRoom(){
        l1=new JLabel("Search Room");
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        l1.setBounds(400,30,300,30);
        l1.setForeground(Color.black);
        add(l1);
        l2=new JLabel("Bed Type");
        l2.setBounds(80,80,200,20);
        add(l2);
        l3=new JLabel("Room No");
        l3.setBounds(100,145,300,30);
        add(l3);
        l4=new JLabel("Availability");
        l4.setBounds(330,145,200,30);
        add(l4);

        l6=new JLabel("Price");
        l6.setBounds(600,145,200,30);
        add(l6);
        l7=new JLabel("Bed Type");
        l7.setBounds(830,145,300,30);
        add(l7);

        String btype[]={"Single","Double"};
        c1=new JComboBox(btype);
        c1.setBounds(150,80,200,20);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2=new JCheckBox("Only Show Available Rooms");
        c2.setBounds(420,80,200,30);
        add(c2);

        t1=new JTable();
        t1.setBounds(0,170,1000,350);
        add(t1);
        b1 = new JButton("Submit");
        b1.setBounds(300,550,120,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(500,550,120,30);
        b2.addActionListener(this);
        add(b2);

        setLayout(null);
        setBounds(500,200,1000,650);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {if(ae.getSource()==b1){
    String type =(String)c1.getSelectedItem();
    String str1="select * from room where bed_type ='"+type+"'";
    String str2="select * from room where availability ='Available' AND bed_type ='"+type+"'";
     try{
            connector x1 = new connector();
            ResultSet rs;
            if(c2.isSelected())
            {
                rs= x1.s.executeQuery(str2);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else{
                rs= x1.s.executeQuery(str1);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            }catch(Exception e){
         System.out.println(e);
     }
            
}else if(ae.getSource()==b2){
    new Reception().setVisible(true);
    this.setVisible(false);

}}
    public static void main(String[] args) {
    new SearchRoom().setVisible(true);

}
}
