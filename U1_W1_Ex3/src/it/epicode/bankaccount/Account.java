package it.epicode.bankaccount;

public class Account {
	String owner;
	int moviments;
	final int maxMovements = 50;
	double balance;

	Account(String owner, double balance) {
		this.owner = owner;
		this.balance = balance;
		moviments = 0;
	}

	void withdraw(double amount) {
		if (moviments < maxMovements)
			balance = balance - amount;
		else
			balance = balance - amount - 0.50;
		moviments++;
	}

	double getBalance() {
		return balance;
	}

}
