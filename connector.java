package hotel_management_system;

import java.sql.*;

public class connector {
    Connection c;
    Statement s;

    public connector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        try {
            c=DriverManager.getConnection("jdbc:mysql:///HMS","root","@$hutosh1");
            s=c.createStatement();
        }
        catch (SQLException ee){
            ee.printStackTrace();
        }
    }
}
