package org.apache.maven.Answer1;

public class Main {
	
	public static void main(String[] args){
		
		SavingsAccount savingsAccount = new SavingsAccount(3000,3.5);
		savingsAccount. displayBalance();
		savingsAccount. calculateInterest();
		savingsAccount. displayBalance();
		
		CurrentAccount currentAccount = new CurrentAccount (2000,2.5);
		currentAccount. displayBalance();
		currentAccount. calculateInterest();
	}

}
