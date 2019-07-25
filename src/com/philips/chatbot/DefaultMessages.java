package com.philips.chatbot;

import java.util.Scanner;

public class DefaultMessages {
    
	String  Details[]=new String[10];
	String ans;
	
	public String[] defaultMessages() {
		 int greet=(int) (Math.random()*3+1);
		 Scanner sc=new Scanner(System.in);
			if(greet==1) {
			System.out.println("C:Hello and Welcome!!");
			System.out.print("You:");	
                        ans=sc.next();
		 }
		 else if(greet==2) {
			System.out.println("C:Hiii!!!");
			System.out.print("You:");	
                        ans=sc.next();
		 }
		 else if(greet==3) {
			System.out.println("C:Hi there! Welcome to Philips!!");
			System.out.print("You:");	
                        ans=sc.next();
		 }
		System.out.println("\nC:Please enter your name: ");
		System.out.print("You:");	
		Details[0]=sc.next();
		System.out.println("\nC:Please enter your contact number:");
		System.out.print("You:");	
		Details[1]=sc.next();
		System.out.println("\nC:Please enter your hospital address:");
		System.out.print("You:");	
		Details[2]=sc.next();
                
                return Details;
	}
}
