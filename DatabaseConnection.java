import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		input obj=new input();
		
	//	DatabaseConnection pro= new DatabaseConnection();
		// pro.createConnection(obj);
		
		
	//}
		
	//	void createConnection(input obj) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "hello@vaishu");
				
			//	System.out.println("Database Connection Success");
			/* String types=obj.features[0];
				
				for(int i=0;i<8;i++) {
					System.out.println(obj.features[i]);
					
				}
				
				
				*/
				//System.out.print("SELECT monitor_name FROM monitors where screen_type='"+ obj.features[0] + "' AND screen_size='" + obj.features[1]+ "' AND monitor_type='" +obj.features[2]+ "' AND ECG='" +obj.features[3]+ "' AND SPO2='" +obj.features[4]+ "' AND NIBP='" +obj.features[5]+"' AND RESPIRATION='"+obj.features[6]+"' AND TEMPERATURE='"+obj.features[7]+"'");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("SELECT monitor_name FROM monitors where screen_type='"+ obj.features[0] + "' AND screen_size='" + obj.features[1]+ "' AND monitor_type='" +obj.features[2]+ "' AND ECG='" +obj.features[3]+ "' AND SPO2='" +obj.features[4]+ "' AND NIBP='" +obj.features[5]+"' AND RESPIRATION='"+obj.features[6]+"' AND TEMPERATURE='"+obj.features[7]+"'");
				
				while(rs.next()) {
					
					String monitor_name=rs.getString("monitor_name");
				/*	String monitor_type=rs.getString("monitor_type");
					String screen_type=rs.getString("screen_type");
					Float screen_size=rs.getFloat("screen_size");
					
					String ECG=rs.getString("ECG");
					String SPO2=rs.getString("SPO2");
					String NIBP=rs.getString("NIBP");
					String RESPIRATION=rs.getString("RESPIRATION");
					String TEMPERATURE=rs.getString("TEMPERATURE"); */
					System.out.println("As per your requirements the Suitable Monitor is:" + monitor_name);
				/*	System.out.println(monitor_type);
					System.out.println(screen_type);
					System.out.println(screen_size);
					System.out.println(ECG);
					System.out.println(SPO2);
					System.out.println(RESPIRATION);
					System.out.println(TEMPERATURE); */
					
				}
				
			}catch(ClassNotFoundException ex) {
				Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE,null,ex);
			}catch(SQLException ex) {
				Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE,null,ex);
			}
		}
		
		

	

}
