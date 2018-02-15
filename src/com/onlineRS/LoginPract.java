
package com.onlineRS;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginPract implements ActionListener{
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    MainPract m;
    
    LoginPract(){
        f = new JFrame("Login");
        f.getContentPane().setLayout(null);
        f.getContentPane().setBackground(Color.pink);
        
        l1 = new JLabel("Username");
        l1.setForeground(Color.yellow);
        l1.setBounds(50, 50, 100, 30);
        
        l2 = new JLabel("Password");
        l2.setForeground(Color.yellow);
        l2.setBounds(50, 80, 100, 30);
        
        t1 = new JTextField(10);
        t1.setForeground(Color.blue);
        t1.setBounds(150, 50, 100, 30);
    
        p1 = new JPasswordField(10);
        p1.setForeground(Color.blue);
        p1.setEchoChar('*');
        p1.setBounds(150, 80, 100, 30);
        
        b1 = new JButton("OK");
        b1.setForeground(Color.blue);
        b1.addActionListener(this);
        b1.setBounds(50, 120, 100, 30);
        
        b2 = new JButton("Cancel");
        b2.setForeground(Color.blue);
        b2.addActionListener(this);
        b2.setBounds(180, 120, 100, 30);
        
        b1.setMnemonic('O');
        b2.setMnemonic('C');
        
        f.getContentPane().add(l1);
        f.getContentPane().add(l2);
        f.getContentPane().add(t1);
        f.getContentPane().add(p1);
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        
        f.setBounds(300, 300, 300, 200);
        f.setResizable(true);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            if(t1.getText().length()==0 || p1.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Fields are Empty");
            }
            else if(t1.getText().equals("phemmz") && p1.getText().equals("1234")){
                f.setVisible(false);
                JOptionPane.showMessageDialog(null, "Welcome");
                m = new MainPract();            
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        
        }
    
    }
}

