
package com.onlineRS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

        

public class PassPract extends JavaConnect implements ActionListener {
    
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;
    
    
    Checkbox c1,c2,c3,c4,c5;
    CheckboxGroup cbg;
    JTextArea ta;
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    Statement st;
    int pno;
    JLabel imgL;
    ImageIcon img;
       
    
    PassPract(int p){
    
    pno=p;
    int EXIT_ON_CLOSE = 2;
    img = new ImageIcon("C:\\Users\\MCOPHEMMZ\\Desktop\\tech\\Java practice\\Online Reservation System Project Code\\Reservation\\LOGO2.jpg");
    imgL = new JLabel(img);
    imgL.setBounds(500, 300, 400, 200); 
            
    f= new JFrame("Passenger");
    f.getContentPane().setLayout(null);
    f.getContentPane().setBackground(Color.green);
    
    l1 = new JLabel("PId");
    l1.setBounds(50, 50, 100, 30);
    t1 = new JTextField(10);
    t1.setBounds(170, 50, 100, 30);
    
    l2 = new JLabel("Name of Passenger");
    l2.setBounds(50, 80, 120, 30);
    t2= new JTextField(10);
    t2.setBounds(170,80,100,30);
    
    l3= new JLabel("Age");
    l3.setBounds(50,110,100,30);
    t3 = new JTextField(10);
    t3.setBounds(170,110,50,30);
    
    l4 = new JLabel("Gender");
    l4.setBounds(50, 140, 50, 30);
        
    l5 = new JLabel("Address");
    l5.setBounds(50, 200, 100, 30);
    ta = new JTextArea(5,10);
    ta.setBounds(170,200,130,70);
    
    l6 = new JLabel("Category");
    l6.setBounds(50, 270, 70, 70);
    
    b1 = new JButton("More");
    b1.setBackground(Color.yellow);
    b1.addActionListener(this);
    b1.setBounds(50, 380, 100, 30);
    
    b2 = new JButton("Save");
    b2.setBackground(Color.yellow);
    b2.addActionListener(this);
    b2.setBounds(170, 380, 100, 30);
    
    b3 = new JButton("Back");
    b3.setBackground(Color.yellow);
    b3.addActionListener(this);
    b3.setBounds(290, 380, 100, 30);
    
    b1.setMnemonic('M');
    b2.setMnemonic('S');
    b3.setMnemonic('B');
    
    cbg = new CheckboxGroup();
    c1 = new Checkbox("Male", cbg, true);
    c1.setBounds(170,140,100,30);
    
    c2 = new Checkbox("Female", cbg, false);
    c2.setBounds(170,170,100,30);
    
    c3 = new Checkbox("General");
    c3.setBounds(170,270,100,30);
    
    c4 = new Checkbox("Senior Citizen");
    c4.setBounds(170,300,100,30);
    
    c5 = new Checkbox("Ex-serviceman");
    c5.setBounds(170,330,100,30);
    
       
    
    f.getContentPane().add(imgL);
    f.getContentPane().add(l1);
    f.getContentPane().add(t1);
    f.getContentPane().add(l2);
    f.getContentPane().add(t2);
    f.getContentPane().add(l3);
    f.getContentPane().add(t3);
    f.getContentPane().add(l4);
    f.getContentPane().add(l5);
    f.getContentPane().add(ta);
    f.getContentPane().add(l6);
    f.getContentPane().add(b1);
    f.getContentPane().add(b2);
    f.getContentPane().add(b3);
    f.getContentPane().add(c1);
    f.getContentPane().add(c2);
    f.getContentPane().add(c3);
    f.getContentPane().add(c4);
    f.getContentPane().add(c5);
//    f.getContentPane().add(c2);
//    f.getContentPane().add(c2);
    f.setVisible(true);
    f.setSize(1300, 1000); 
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    
    
    
    
    }
    
    public void actionPerformed(ActionEvent e){
    if(e.getSource()==b1){
    try{
    String cat="";
    pst = conn.prepareStatement("insert into TempPassenger values(?,?,?,?,?)");
    pst.setString(1, t1.getText());
    pst.setString(2, t2.getText());
    pst.setString(3, t3.getText());
    pst.setString(4, cbg.getSelectedCheckbox().getLabel());
    pst.setString(5, ta.getText());
    if(c3.getState()){
    cat+=c3.getLabel()+",";
    }
    if(c4.getState()){
    cat+=c4.getLabel()+",";
    }
    if(c5.getState()){
    cat+=c5.getLabel()+",";
    }
    pst.setString(6, cat);
    pst.setInt(7, pno);
    pst.executeUpdate();
    pst.close();
    
    PassPract P = new PassPract(pno);
    st = conn.createStatement();
    rs = st.executeQuery("select * from PassengerID");
    rs.next();
    int x = rs.getInt(1);
    P.t1.setText(String.valueOf(x));
    st.close();
    
    pst=conn.prepareStatement("update PassengerID set PID=? where PID=?");
    pst.setInt(1, (x+1));
    pst.setInt(2, x);
    pst.executeUpdate();
    pst.close();    
    }
    catch(Exception e1){
    JOptionPane.showMessageDialog(null, e1);
    }    
    }
    
    if(e.getSource()==b2){
    try{
    String cat="";
    pst=conn.prepareStatement("insert into TempPassenger values(?,?,?,?,?,?,?)");
    pst.setString(1, t1.getText());
    pst.setString(2, t2.getText());
    pst.setString(3, t3.getText());
    pst.setString(4, cbg.getSelectedCheckbox().getLabel());
    pst.setString(5, ta.getText());
    if(c3.getState()){
    cat+=c3.getLabel()+",";
    }
    if(c4.getState()){
    cat+=c4.getLabel()+",";
    }
    if(c5.getState()){
    cat+=c5.getLabel()+",";
    }    
    pst.setString(6, cat);
    pst.setInt(7, pno);
    pst.executeUpdate();
    pst.close();
    
    st=conn.createStatement();
    rs=st.executeQuery("select * from TempPassenger");
    while(rs.next()){
    pst=conn.prepareStatement("insert into Passenger values (?,?,?,?,?,?,?)");
    pst.setString(1, rs.getString(1));
    pst.setString(2, rs.getString(2));
    pst.setString(3, rs.getString(3));
    pst.setString(4, rs.getString(4));
    pst.setString(5, rs.getString(5));
    pst.setString(6, rs.getString(6));
    pst.setString(7, rs.getString(7));
    pst.executeUpdate();
    pst.close();
    }
    st=conn.createStatement();
    st.executeUpdate("delete from TempPassenger");
    JOptionPane.showMessageDialog(null, "Record Saved");
    b2.setEnabled(false);
    b1.setEnabled(false);
    st.close();  
    }
    catch(Exception e1){
        JOptionPane.showMessageDialog(null, e1);
    }       
    }
    if(e.getSource()==b3){
    f.setVisible(false);
    new Respract();
    }
    }
    
    
    public static void main(String[]args){
    new PassPract(0);
    }
}
