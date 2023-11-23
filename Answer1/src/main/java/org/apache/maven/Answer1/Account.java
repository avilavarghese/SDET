package org.apache.maven.Answer1;

public class Account {
	
	protected double interest;
	protected double balance;

	public Account(double balance, double interest){
		this.balance = balance;
		this.interest = interest;
	}

	public void calculateInterest(){
		double interestPercent = balance*interest/100;
		balance += interestPercent;
	}
	
	public void deposit(double amount){
		balance +=amount;
	}

	public void withdraw(double amount){
		if(amount<=balance){
			balance -= amount;
		}
		else{
			System.out.println("Insufficient balance.");
		}
	}

	public void displayBalance(){
		System.out.println("Account balance: $" + balance);
	}

}
