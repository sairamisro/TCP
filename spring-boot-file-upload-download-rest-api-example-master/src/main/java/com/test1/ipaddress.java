package com.test1;
// java.net.InetAddress class provides method to get ip address
import java.net.*; 
import java.io.*; 
 public class ipaddress
{ 
    public static void main(String args[]) throws Exception 
    { 
        // Returns the instance of InetAddress containing 
        // local host name and address 
        InetAddress localhost = InetAddress.getLocalHost(); 
        System.out.println("System IP Address : " + 
                      (localhost.getHostAddress()).trim()); 
  
        // Find public IP address 
        String systemipaddress = ""; 
        try
        { 
            URL url_name = new URL("http://bot.whatismyipaddress.com"); 
      InputStreamReader sr =new InputStreamReader(url_name.openStream());
            BufferedReader sc =   new BufferedReader(sr); 
  
            // reads system IPAddress 
            systemipaddress = sc.readLine().trim(); 
        } 
        catch (Exception e) 
        { 
        	e.printStackTrace();
            systemipaddress = "Cannot Execute Properly"; 
        } 
        System.out.println("Public IP Address: " + systemipaddress +"\n"); 
    } 
}