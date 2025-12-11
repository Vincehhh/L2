package tp5CollectionsGenericite.partie1Collections.exercice1aManipulationListDeSetEtDeTreeSet;

// import java.util.Comparator;

/**
 * A bank account has a balance that can be
 * changed by deposits and withdrawals.
 *
 * @author authorName
 */
public class BankAccount implements Comparable<BankAccount> {
	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount() {
		balance = 0;
	}

	/**
	 * Constructs a bank account with a given balance.
	 * @param initialBalance the initial balance
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}

	/**
	 * Deposits money into the bank account.
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {
		double newBalance = balance + amount;
		balance = newBalance;
	}

	/**
	 * Withdraws money from the bank account.
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {
		double newBalance = balance - amount;
		balance = newBalance;
	}

	/**
	 * Gets the current balance of the bank account.
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}

	public String toString() {
		return "BankAccount_balance=" + balance;
	}

	private double balance;

	@Override
	public int compareTo(BankAccount b) {
		if (this.balance < b.getBalance())
			return -1;
		if (this.balance > b.getBalance())
			return 1;
		return 0;
	}

	/*@Override
	public int compareTo(BankAccount b) {
		if (this.getBalance() > b.getBalance())
			return 1;
		if (this.getBalance() < b.getBalance())
			return -1;
		return 0;
	}*/

	/*@Override
	public int compareTo(BankAccount b) {
		return (int) (this.balance - b.getBalance());
	}*/
}
