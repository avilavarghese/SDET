package org.apache.maven.Answer1;

public class CurrentAccount extends Account {
	
	public CurrentAccount (double balance, double interest){
		super(balance,interest);
	}
	
	public void calculateInterest(){
		System.out.println("Interest is not applicable.");
	}
		
}
