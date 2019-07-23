package chatbot;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class DatabaseConnection {

    public static void main(String[] args) {
        String features[] = new String[10];

        DefaultMessages dm = new DefaultMessages();
        dm.defaultMessages();
        Scanner sc = new Scanner(System.in);

        int choice[] = new int[10];

        for (int i = 5; i < 10; i++) {
            features[i] = "No";
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/chatbot?autoReconnect=true&useSSL=false", "root", "1234");
            Statement stmt = con.createStatement();
            
            boolean flag = false;
            
            //Fetching no. of distinct monitor types-------------------
            ResultSet rs = stmt.executeQuery("SELECT COUNT(distinct monitor_type) as rowcount FROM monitors");
            rs.next();
            int no_of_monitors = rs.getInt("rowcount");

            //Selecting monitor type from db-------------------
            String qry1 = "SELECT distinct monitor_type FROM monitors";
            rs = stmt.executeQuery(qry1);
            SelectClassification:
            for (int i = 0; i < 1; i++) {
                String monitor_array[] = new String[no_of_monitors];
                int m = 0;
                if (rs.next() == false) {
                    System.out.println("\nC:Sorry! No monitors available.");
                } else {
                    System.out.println("\nC:Which type of monitor you want :");
                    do {
                        String monitor_type = rs.getString("monitor_type");
                        System.out.println((m + 1) + "." + monitor_type);
                        monitor_array[m] = monitor_type;
                        m++;
                    } while (rs.next());
                }
                
              System.out.print("You:");
                choice[2] = sc.nextInt();

                for (int c = 0; c < m; c++) {
                    if ((choice[2] - 1) == c) {
                        features[2] = monitor_array[c];
                        flag = true;
                        break;
                    }
                }

                if (flag == false) {
                    i = -1;
                    System.out.println("\nC:Invalid input. Please select the monitor classification again.");
                    rs = stmt.executeQuery(qry1);//fetch monitors again
                    continue SelectClassification;
                }
            }

            //Fetching no. of distinct screen types-------------------
            rs = stmt.executeQuery("SELECT COUNT(distinct screen_type) as rowcount FROM monitors where monitor_type='" + features[2] + "'");
            rs.next();
            int no_of_screens = rs.getInt("rowcount");

            //Selecting screen type from db-------------------
            String qry2 = "SELECT distinct screen_type FROM monitors where monitor_type='" + features[2] + "'";
            rs = stmt.executeQuery(qry2);
            flag=false;
            
            SelectType:
            for (int i = 0; i < 1; i++) {
                String screen_array[] = new String[no_of_screens];
                int m = 0;
                if (rs.next() == false) {
                    System.out.println("\nC:Sorry! No monitors available.");
                } else {
                    System.out.println("\nC:Which screen type you want for your monitor:");
                    do {
                        String screen_type = rs.getString("screen_type");
                        System.out.println((m + 1) + "." + screen_type);
                        screen_array[m] = screen_type;
                        m++;
                    } while (rs.next());
                }

                System.out.print("You:");
                choice[3] = sc.nextInt();
                
                for (int c = 0; c < m; c++) {
                    if ((choice[3] - 1) == c) {
                        features[3] = screen_array[c];
                        flag = true;
                        break;
                    }
                }

                if (flag == false) {
                    i = -1;
                    System.out.println("\nC:Invalid input. Please select the screen type again.");
                       rs = stmt.executeQuery(qry2);
                    continue SelectType;
                }
            }

            //Fetching no. of distinct screen sizes for a particular screen type-------------------
            rs = stmt.executeQuery("SELECT COUNT(distinct screen_size) as rowcount FROM monitors where monitor_type='" + features[2] + "' and screen_type='" + features[3] + "'");
            rs.next();
            int no_of_sizes = rs.getInt("rowcount");

            //Selecting screen type from db-------------------
            String qry3 = "SELECT distinct screen_size FROM monitors where monitor_type='" + features[2] + "' and screen_type='" + features[3] + "'";
            rs = stmt.executeQuery(qry3);
            flag=false;
            
            SelectSize:
            for (int i = 0; i < 1; i++) {
                String size_array[] = new String[no_of_sizes];
                int m = 0;
                if (rs.next() == false) {
                    System.out.println("\nC:Sorry! No monitors available.");
                } else {
                    System.out.println("\nC:Which screen size you want for your monitor:");
                    do {
                        String screen_size = rs.getString("screen_size");
                        System.out.println((m + 1) + "." + screen_size);
                        size_array[m] = screen_size;
                        m++;
                    } while (rs.next());
                }

                System.out.print("You:");
                choice[4] = sc.nextInt();
                for (int c = 0; c < m; c++) {
                    if ((choice[4] - 1) == c) {
                        features[4] = size_array[c];
                        flag = true;
                        break;
                    }
                }

                if (flag == false) {
                    i = -1;
                    System.out.println("\nC:Invalid input. Please select the screen size again.");
                       rs = stmt.executeQuery(qry3);
                    continue SelectSize;
                }
            }
            
            
            
            
            //Static questions-----------            
            SelectECG: for (int i = 0; i < 1; i++) {
				System.out.println("\nC:Do you want to have the ECG module?\n 1. Yes \n 2. No");
				System.out.print("You:");	
                                choice[5] = sc.nextInt();
				switch (choice[5]) {
				case 1:
					features[5] = "Yes";
					break;
				case 2:
					features[5] = "No";
					break;
				default:
					i = -1;
					System.out.println("\nC:Invalid input. Please select your choice again.");
					continue SelectECG;
				}

			}

			SelectSPO2: for (int i = 0; i < 1; i++) {
				System.out.println("\nC:Do you want to have the SPO2 module?\n 1. Yes \n 2. No");
				System.out.print("You:");	
                                choice[6] = sc.nextInt();
				switch (choice[6]) {
				case 1:
					features[6] = "Yes";
					break;
				case 2:
					features[6] = "No";
					break;
				default:
					i = -1;
					System.out.println("\nC:Invalid input. Please select your choice again.");
					continue SelectSPO2;
				}

			}

			SelectNIBP: for (int i = 0; i < 1; i++) {
				System.out.println("\nC:Do you want to have the NIBP module?\n 1. Yes \n 2. No\n");
				System.out.print("You:");	
                                choice[7] = sc.nextInt();
				switch (choice[7]) {
				case 1:
					features[7] = "Yes";
					break;
				case 2:
					features[7] = "No";
					break;
				default:
					i = -1;
					System.out.println("\nC:Invalid input. Please select your choice again.");
					continue SelectNIBP;
				}

			}

			SelectResp: for (int i = 0; i < 1; i++) {
				System.out.println("\nC:Do you want to have the Respiration module?\n 1. Yes \n 2. No");
				System.out.print("You:");	
                                choice[8] = sc.nextInt();
				switch (choice[8]) {
				case 1:
					features[8] = "Yes";
					break;
				case 2:
					features[8] = "No";
					break;
				default:
					i = -1;
					System.out.println("\nC:Invalid input. Please select your choice again.");
					continue SelectResp;
				}

			}

			SelectTemperature: for (int i = 0; i < 1; i++) {
				System.out.println("\nC:Do you want to have the Temperature module?\n 1. Yes \n 2. No");
				System.out.print("You:");	
                                choice[9] = sc.nextInt();
				switch (choice[9]) {
				case 1:
					features[9] = "Yes";
					break;
				case 2:
					features[9] = "No";
					break;
				default:
					i = -1;
					System.out.println("\nC:Invalid input. Please select your choice again.");
					continue SelectTemperature;
				}

			}
            
            
            
            

            //Answering user-------------------
            String qry4 = "SELECT monitor_name FROM monitors where monitor_type='" + features[2] + "' and screen_type='" + features[3] + "' and screen_size='" + features[4] + "'";
            rs = stmt.executeQuery(qry4);
            if (rs.next() == false) {
                System.out.println("\nC:Sorry! No monitors available.");
            } else {
                System.out.println("\nC:As per your preferences, recommended monitor(s) is/are:");
                do {
                    String monitor_name = rs.getString("monitor_name");
                    System.out.println(monitor_name);
                } while (rs.next());
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
