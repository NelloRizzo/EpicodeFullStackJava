package it.epicode.bankaccount;

public class OnLineAccount extends Account {
	double maxAmount;

	OnLineAccount(String titolare, double saldo, double maxAmount) {
		super(titolare, saldo);
		this.maxAmount = maxAmount;
	}

	void withdraw(double amount) {
		if (amount <= maxAmount) {
			super.withdraw(amount);
		}
	}

}
