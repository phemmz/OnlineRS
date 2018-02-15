
package com.onlineRS;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Respract implements ActionListener,FocusListener {
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JTextArea ta;
    JButton b1,b2,b3;
    JLabel imgL;
    ImageIcon img;
    Choice h;
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    Statement st;
    int x;
    
    
    
    void disable(){
    t1.setEnabled(false);
    t2.setEnabled(false);
    t3.setEnabled(false);
    t4.setEnabled(false);
    t5.setEnabled(false);
    t6.setEnabled(false);
    t7.setEnabled(false);
    h.setEnabled(false);
    b2.setEnabled(false);
    }
    
    void enable(){
    t1.setEnabled(true);
    t2.setEnabled(true);
    t3.setEnabled(true);
    t4.setEnabled(true);
    t5.setEnabled(true);
    t6.setEnabled(true);
    t7.setEnabled(true);
    h.setEnabled(true);
    b2.setEnabled(true);
    }
    
    Respract(){
    conn=JavaConnect.ConnecrDb();
    img=new ImageIcon("C:\\Users\\MCOPHEMMZ\\Desktop\\tech\\Java practice\\images (2).jpg");
    imgL = new JLabel(img);
    imgL.setBounds(0,320,500,250);
    
    f=new JFrame("Reservation");
    f.getContentPane().setLayout(null);
    f.getContentPane().setBackground(Color.green);
    
    l1=new JLabel("PNR no");
    l1.setBounds(50,50,100,30);
    t1= new JTextField(10);
    t1.setBounds(170,50,120,30);
    
    l2=new JLabel("Train no");
    l2.setBounds(50,80,100,30);
    t2= new JTextField(10);
    t2.setBounds(170,80,120,30);
    t2.addFocusListener(this);
    
    l3=new JLabel("Train name");
    l3.setBounds(50,110,100,30);
    t3= new JTextField(10);
    t3.setBounds(170,110,120,30);
    
    l4=new JLabel("Class");
    l4.setBounds(50,140,100,30);
    h= new Choice();
    h.setBounds(170,140,120,30);
    h.add("First Class");
    h.add("Second Class");

    
    
    l5=new JLabel("Date of Journey");
    l5.setBounds(50,170,100,30);
    t5= new JTextField(10);
    t5.setBounds(170,170,120,30);
    
    l6=new JLabel("From");
    l6.setBounds(50,200,100,30);
    t6= new JTextField(10);
    t6.setBounds(170,200,120,30);
    
    l7=new JLabel("To");
    l7.setBounds(350,200,50,30);
    t7= new JTextField(10);
    t7.setBounds(400,200,120,30);
    
    l8 = new JLabel("Boarding at");
    l8.setBounds(50,230,100,30);
    t4= new JTextField(10);
    t4.setBounds(170, 230, 120, 30);
    
    b1= new JButton("Insert");
    b1.setBackground(Color.yellow);
    b1.setBounds(50,270,100,30);
    b1.setMnemonic('I');
    b1.addActionListener(this);
    
    b2= new JButton("Next");
    b2.setBackground(Color.yellow);
    b2.setBounds(170, 270, 100, 30);
    b2.setMnemonic('N');
    b2.addActionListener(this);
    
    b3= new JButton("Menu");
    b3.setBackground(Color.yellow);
    b3.setBounds(290, 270, 100, 30);
    b3.setMnemonic('M');
    b3.addActionListener(this);
    
    
    
    
    
    
    
    f.getContentPane().add(l1);
    f.getContentPane().add(l2);
    f.getContentPane().add(l3);
    f.getContentPane().add(l4);
    f.getContentPane().add(l5);
    f.getContentPane().add(l6);
    f.getContentPane().add(l7);
    f.getContentPane().add(l8);
    f.getContentPane().add(t1);
    f.getContentPane().add(t2);
    f.getContentPane().add(t3);
    f.getContentPane().add(h);
    f.getContentPane().add(t5);
    f.getContentPane().add(t6);
    f.getContentPane().add(t7);
    f.getContentPane().add(t4);
    f.getContentPane().add(b1);
    f.getContentPane().add(b2);
    f.getContentPane().add(b3);
    f.getContentPane().add(imgL);
    f.setSize(1300,1000);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    disable();
//    f.getContentPane().add(b1);
//    f.getContentPane().add(b1);
//    f.getContentPane().add(b1);
//    f.getContentPane().add(b1);
//    f.getContentPane().add(b1);
//    f.getContentPane().add(b1);
    f.setVisible(true);    
    
   
    }
    

    public void focusGained(FocusEvent e){
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
        enable();
        b1.setEnabled(false);
        try{
            pst= conn.prepareStatement("select * from PNR");
            rs=pst.executeQuery();
            rs.next();
            x=rs.getInt(1);
            t1.setText(String.valueOf(x));

            rs.close();
            pst.close();
                
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null, e1);
        }
    }
      
    if(e.getSource()==b2){
        
        try{
        pst=conn.prepareStatement("insert into Reservation values(?,?,?,?,?,?,?,?)");
        pst.setString(1, t1.getText());
        pst.setString(2, t2.getText());
        pst.setString(3, t3.getText());
        pst.setString(4, h.getSelectedItem());
        pst.setString(5, t5.getText());
        pst.setString(6, t6.getText());
        pst.setString(7, t7.getText());
        pst.setString(8, t4.getText());
        pst.execute();
        //rs.close();
        pst.close();
        
        //update PNR no
        pst=conn.prepareStatement("update PNR set PNR_No=? where PNR_No=?");
        pst.setInt(1, (x+1));
        pst.setInt(2, x);
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Record Saved");
        
        b1.setEnabled(true);
        b2.setEnabled(false);
        f.setVisible(false);
//        PassPract P = new PassPract();
        //rs.close();
        pst.close();

             
        }
        catch(Exception e1){
        JOptionPane.showMessageDialog(null, e1);
        }
        try{
//        st=conn.prepareStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        st=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        rs=st.executeQuery("select * from Reservation");
        rs.next();
        x=rs.getInt(1);       
        PassPract P = new PassPract(x);
       // rs.close();
        pst.close();
        
        st=conn.createStatement();
        rs=st.executeQuery("select * from PassengerID");
        rs.next();
        x=rs.getInt(1);
//        rs.close();
//        pst.close();
        P.t1.setText(String.valueOf(x));
      
        
        pst=conn.prepareStatement("update PassengerId set PID=? where PID=?");
        pst.setInt(1, (x+1));
        pst.setInt(2, x);
        
        pst.executeUpdate(); 
        rs.close();
        pst.close();
        }
        catch(Exception e1){
        JOptionPane.showMessageDialog(null, e1);
        }
    }
    if(e.getSource()==b3){
        f.setVisible(false);
        new MainPract();
    }
//     f.setDefaultCloseOperation(4);
    
    
    }
        public void focusLost(FocusEvent e){
        if(t2.getText().length()!=0){
        try{
            pst = conn.prepareStatement("select Train_Name from Train where Train_No=?");
            pst.setString(1, t2.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                t3.setText(rs.getString(1));
            }        
            rs.close();
            pst.close();
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null, e1);
        }        
        }  
        
    
    }
        
    
    
    public static void main(String []args){
    new Respract();
    
    }
    
    
    
}
