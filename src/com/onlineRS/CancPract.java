
package com.onlineRS;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class CancPract implements ActionListener, ItemListener {
    
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,imgL1,imgL2;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice h;
    List li;
    ImageIcon img1, img2;
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    Statement st;
    
    
    CancPract(){
        conn=JavaConnect.ConnecrDb();
        
        f=new JFrame("Cancellation");
        f.getContentPane().setLayout(null);
        f.getContentPane().setBackground(Color.green);
        img1= new ImageIcon("C:\\Users\\MCOPHEMMZ\\Desktop\\tech\\Java practice\\images (2).jpg");
        imgL1= new JLabel(img1);
        imgL1.setBounds(300, 0, 225, 225);
        img2=new ImageIcon("C:\\Users\\MCOPHEMMZ\\Desktop\\tech\\Java practice\\images (5).jpg");
        imgL2=new JLabel(img2);
        imgL2.setBounds(400, 300, 268, 188);
        
        l1= new JLabel("PNR no");
        l1.setBounds(50, 90, 100, 30);
        h = new Choice();
        h.setBounds(150, 90, 100, 30);
        h.addItemListener(this);
        
        l2= new JLabel("Train no");
        l2.setBounds(50, 120, 100, 30);
        t1= new JTextField(10);
        t1.addActionListener(this);
        t1.setBounds(150, 120, 100, 30);
        
        l3=new JLabel("Train Name");
        l3.setBounds(50, 150, 100, 30);
        t2=new JTextField(10);
        t2.addActionListener(this);
        t2.setBounds(150, 150, 100, 30);
        
        l4=new JLabel("Class");
        l4.setBounds(50, 180, 100, 30);
        t3= new JTextField(10);
        t3.addActionListener(this);
        t3.setBounds(150, 180, 100, 30);
        
        l5=new JLabel("Date of journey");
        l5.setBounds(50, 210, 100, 30);
        t4= new JTextField(10);
        t4.addActionListener(this);
        t4.setBounds(150, 210, 100, 30);
        
        l6=new JLabel("From");
        l6.setBounds(50, 240, 100, 30);
        t5= new JTextField(10);
        t5.addActionListener(this);
        t5.setBounds(150, 240, 100, 30);
        
        l7=new JLabel("To");
        l7.setBounds(300, 240, 100, 30);
        t6=new JTextField(10);
        t6.setBounds(350, 240, 100, 30);
        
        l8= new JLabel("Boarding at");
        l8.setBounds(50, 270, 100, 30);
        t7= new JTextField(10);
        t7.setBounds(150, 270, 100, 30);
        
        l9= new JLabel("Name of Passenger");
        l9.setBounds(70, 360, 130, 30);
        l10= new JLabel("Age");
        l10.setBounds(230, 360, 100, 30);
        l11= new JLabel("Gender");
        l11.setBounds(290, 360, 100, 30);
        
        
        li = new List(5, true);
        li.setBounds(50, 400, 320, 100);
        
        b1= new JButton("OK");
        b1.setBackground(Color.yellow);
        b1.addActionListener(this);
        b1.setBounds(50, 550, 100, 30);
        b1.setMnemonic('O');
        
        b2=new JButton("Back");
        b2.setBackground(Color.yellow);
        b2.addActionListener(this);
        b2.setBounds(200, 550, 100, 30);
        b2.setMnemonic('B');
        
        
        
        
        
        f.getContentPane().add(l1);
        f.getContentPane().add(l2);
        f.getContentPane().add(l3);
        f.getContentPane().add(l4);
        f.getContentPane().add(l5);
        f.getContentPane().add(l6);
        f.getContentPane().add(l7);
        f.getContentPane().add(l8);
        f.getContentPane().add(l9);
        f.getContentPane().add(l10);
        f.getContentPane().add(l11);
        f.getContentPane().add(h);
        f.getContentPane().add(t1);
        f.getContentPane().add(t2);
        f.getContentPane().add(t3);
        f.getContentPane().add(t4);
        f.getContentPane().add(t5);
        f.getContentPane().add(t6);
        f.getContentPane().add(imgL1);
        f.getContentPane().add(imgL2);
        f.getContentPane().add(t7);
        f.getContentPane().add(li);
        f.getContentPane().add(t1);
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
//        f.getContentPane().add(t1);
//        f.getContentPane().add(t1);
//        f.getContentPane().add(t1);
//        f.getContentPane().add(t1);
//        f.getContentPane().add(t1);
//        f.getContentPane().add(t1);


        f.setSize(1300, 1000);
        f.setDefaultCloseOperation(2);
        f.setVisible(true);
        start();
    }
    
    public void start(){
        try{
            st=conn.createStatement();
            rs=st.executeQuery("select * from Reservation");
            while(rs.next()){
            h.add(rs.getString(1));
        }
    }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void itemStateChanged(ItemEvent e){
        System.out.println((String)h.getSelectedItem());
        try{
            li.removeAll();
            pst=conn.prepareStatement("select * from Reservation where PNR_No=?");
            pst.setString(1, h.getSelectedItem());
            rs=pst.executeQuery();
            rs.next();
            t1.setText(rs.getString(2));
            t2.setText(rs.getString(3));
            t3.setText(rs.getString(4));
            t4.setText(rs.getString(5));
            t5.setText(rs.getString(6));
            t6.setText(rs.getString(7));
            t7.setText(rs.getString(8));
            pst.close();
            rs.close();
            
            pst=conn.prepareStatement("select * from Passenger where PNR_No");
            pst.setString(1, h.getSelectedItem());
            rs=pst.executeQuery();
            
            while(rs.next()){
                li.add(rs.getString(2)+"                                    "+rs.getString(3)+"                                  "+rs.getString(4));            
            }
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null, e1);
        }
     
    }
    
    public void actionPerformed(ActionEvent e){
        
        
        }
    
    
    
    
    
    public static void main(String[]args){
    new CancPract();
    }    
    
}
