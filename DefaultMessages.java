import java.util.Scanner;

public class DefaultMessages {

	
	String  Details[]=new String[10];
	String ans;
	
	public DefaultMessages() {
		Scanner sc=new Scanner(System.in);
		 int greet=(int) (Math.random()*3+1);
		 if(greet==1) {
			System.out.println("Hello and Welcome!! \n  ");
			ans=sc.next();
		 }
		 else if(greet==2) {
			 System.out.println("Hiii!!! \n ");
			 ans=sc.next();
		 }
		 else if(greet==3) {
			 System.out.println("Welcome to Philips!! \n");
			 ans=sc.next();
		 }
		
				
		System.out.println("Please enter your name: \n");
		Details[0]=sc.next();
		System.out.println("Please enter your contact number: \n");
		Details[1]=sc.next();
		System.out.println("Please enter your hospital address: \n");
		Details[2]=sc.next();
	}
}
