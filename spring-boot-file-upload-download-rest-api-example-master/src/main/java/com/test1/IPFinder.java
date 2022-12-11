package com.test1;
import javax.swing.*;  
import java.awt.event.*;  
import java.net.*;  
public class IPFinder extends JFrame implements ActionListener{  
    JLabel l;  
    JTextField tf;  
    JButton b;  
IPFinder(){  
    super("IP Finder Tool");  
    l=new JLabel("Enter URL:");  
    l.setBounds(50,70,150,20);;  
    tf=new JTextField();  
    tf.setBounds(50,100,200,20);  
      
    b=new JButton("Find IP");  
    b.setBounds(50,150,80,30);  
    b.addActionListener(this);  
    add(l);  
    add(tf);  
    add(b);  
    setSize(300,300);  
    setLayout(null);  
    setVisible(true);  
}  
public void actionPerformed(ActionEvent e){  
    String url=tf.getText();  
    try {  
        InetAddress ia=InetAddress.getByName(url);  
        String ip=ia.getHostAddress();  
        JOptionPane.showMessageDialog(this,ip);  
    } catch (UnknownHostException e1) {  
        JOptionPane.showMessageDialog(this,e1.toString());  
    }  
}  

public static void ip1()throws Exception
{
	String url="whatismyipaddress.com"; 
	//www.codespeedy.com=104.21.85.98
    try {  
        InetAddress ia=InetAddress.getByName(url);  
        String ip=ia.getHostAddress();  
        System.out.println(ip);  
    } catch (UnknownHostException e1) { e1.printStackTrace();  
    } 
}

public static void ip2()throws Exception
{
  URL url =new URL ("https://www.youtube.com/shorts/bj0ZkKeGchc");/*This is the url it can be diffrent*/    
  System.out.println("protocol:"+url.getProtocol());/*This line gives the protocol of any Url*/
    System.out.println("Host name:"+url.getHost());/* This methos gives the host address of the url*/
      System.out.println("port:"+url.getPort());/*This methos gives the port number of the url*/
        System.out.println("filename"+url.getFile());/*
        This methos gives the File name of the url*/
}

public static void main(String[] args) {  
   // new IPFinder();
	try {
		ip1();
		ip2();
		
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}  
} 