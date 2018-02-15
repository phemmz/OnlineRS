
package com.onlineRS;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainPract implements ActionListener{
    JFrame f;
    JButton b1,b2,b3,b4;
    JLabel imgL;
    ImageIcon img;
    Respract r;
    PnrPract p;
    CancPract c;
    
    
    MainPract(){
        img = new ImageIcon("C:\\Users\\MCOPHEMMZ\\Desktop\\tech\\Java practice\\Online Reservation System Project Code\\Reservation\\Indian-Railway-network.jpg");
        imgL = new JLabel(img);
        imgL.setBounds(0, 0, 1300, 1000);
        
        f = new JFrame("Main");
        f.getContentPane().setLayout(null);
        f.getContentPane().setBackground(Color.BLUE);
        
        b1 = new JButton("Reservation Form");
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b1.setBounds(150, 390, 210, 60);
        b1.setBackground(Color.green);
        b1.setMnemonic('R');
        
        b2 = new JButton("PNR Enquiry");
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        b2.setBounds(150, 490, 210, 60);
        b2.setBackground(Color.green);
        b2.setMnemonic('P');
        
        b3 = new JButton("Cancellation Form");
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        b3.setBounds(580, 390, 210, 60);
        b3.setBackground(Color.green);
        b3.setMnemonic('C');
        
        b4 = new JButton("Exit");
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        b4.setBounds(580, 490, 210, 60);
        b4.setBackground(Color.green);
        b4.setMnemonic('E');
        
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        f.getContentPane().add(b3);
        f.getContentPane().add(b4);
        f.getContentPane().add(imgL);
        f.setSize(1300, 1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            f.setVisible(false);
            r = new Respract();
        }
        if(e.getSource()==b2){
            f.setVisible(false);
            p = new PnrPract();
        }
        if(e.getSource()==b3){
            f.setVisible(false);
            c = new CancPract();
        }
        if(e.getSource()==b4){
            f.setVisible(false);
            System.exit(0);        
        }
    
    }
}

