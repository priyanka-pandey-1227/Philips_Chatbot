package com.philips.chatbot.db;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class DatabaseConnection {

    String choice[] = new String[10];
    // boolean flag = false;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/chatbot?autoReconnect=true&useSSL=false", "root", "1234");
            stmt = con.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] showMonitorTypes() {
        String monitor_array[] = null;
        try {
            // Fetching no. of distinct monitor types-------------------
            ResultSet rs = stmt.executeQuery("SELECT COUNT(distinct monitor_type) as rowcount FROM monitors");
            rs.next();
            int no_of_monitors = rs.getInt("rowcount");
            monitor_array = new String[no_of_monitors];
            // Selecting monitor type from db-------------------
            String qry1 = "SELECT distinct monitor_type FROM monitors";
            rs = stmt.executeQuery(qry1);
            int m = 0;
            if (rs.next() == false) {
                System.out.println("\nPhilia: Sorry! No monitors available.");
            } else {
                do {
                    String monitor_type = rs.getString("monitor_type");
                    monitor_array[m++] = monitor_type;
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return monitor_array;
    }

    public String[] showScreenTypes(String monitor) {
        String screen_array[] = null;
        try {
            // Fetching no. of distinct screen types-------------------
            rs = stmt.executeQuery("SELECT COUNT(distinct screen_type) as rowcount FROM monitors where monitor_type='"
                    + monitor + "'");
            rs.next();
            int no_of_screens = rs.getInt("rowcount");

            // Selecting screen type from db-------------------
            String qry2 = "SELECT distinct screen_type FROM monitors where monitor_type='" + monitor + "'";
            rs = stmt.executeQuery(qry2);

            screen_array = new String[no_of_screens];
            int m = 0;
            if (rs.next()== false) {
            	 System.out.println("\nPhilia: Sorry! No monitors available.");
            	
               
            } else {
            	 do {
                     String screen_type = rs.getString("screen_type");
                     screen_array[m++] =screen_type;
                   
                 } while (rs.next());
               
            	
            }
       
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return screen_array;
    }

    public String[] showScreenSizes(String monitor, String screen_type) {
        String size_array[] = null;
        try {
            // Fetching no. of distinct screen types-------------------
            rs = stmt.executeQuery("SELECT COUNT(distinct screen_size) as rowcount FROM monitors where monitor_type='"
                    + monitor + "' and screen_type='" + screen_type + "'");
            rs.next();
            int no_of_sizes = rs.getInt("rowcount");

            // Selecting screen type from db-------------------
            String qry2 = "SELECT distinct screen_size FROM monitors where monitor_type='" + monitor
                    + "' and screen_type='" + screen_type + "'";
            rs = stmt.executeQuery(qry2);

            size_array = new String[no_of_sizes];
            int m = 0;
            if (rs.next() == false) {
                System.out.println("\nPhilia: Sorry! No monitors available.");
            } else {
                do {
                    String screen_size = rs.getString("screen_size");
                 
                    size_array[m++] =screen_size;
                    
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size_array;
    }

   
    public String[] getMonitors(String m_choice, String s_choice, String size_choice) {
        int i=0;  String monitor_name[]=new String[10];
        try {
            // Answering user-------------------
            String qry4 = "SELECT monitor_name FROM monitors where monitor_type='" + m_choice + "' and screen_type='"
                    + s_choice + "' and screen_size='" + size_choice + "'";
            rs = stmt.executeQuery(qry4);
            if (rs.next() == false) {
                System.out.println("\nPhilia: Sorry! No monitors available.");
            } else {
                System.out.println("\nPhilia: As per your preferences, recommended monitor(s) is/are:");
                do {
                     
					monitor_name[i++] = rs.getString("monitor_name");
                   // System.out.println(monitor_name);
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return monitor_name;
    }

}
