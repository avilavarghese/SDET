package org.apache.maven.Answer1;

public class SavingsAccount extends Account {
	
	public SavingsAccount (double balance, double interest){
		super(balance,interest);
	}

	public void withdraw(double amount){
		if(amount <= balance){
			balance -= amount;
		}
		else{
			System.out.println("Insufficient balance.");
		}
	}
	}

