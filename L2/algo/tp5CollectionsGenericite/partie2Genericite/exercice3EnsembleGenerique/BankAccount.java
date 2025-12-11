package tp5CollectionsGenericite.partie2Genericite.exercice3EnsembleGenerique;

public class BankAccount implements Comparable<BankAccount> {
	// Etat : les attributs
	private double balance;

	// Comportement : les méthodes et les constructeurs
	// Constructeurs
	public BankAccount() {
		this.balance = 0;
	}

	public BankAccount(double balance) {
		this.balance = balance;
	}

	// Méthodes
	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}

	public void withdraw(double amount) {
		this.balance = this.balance - amount;
	}

	public void transfer(BankAccount anOtherAccount, double amount) {
		// this.balance = this.balance - amount;
		this.withdraw(amount);
		// anOtherAccount.balance = anOtherAccount.balance + amount;
		anOtherAccount.deposit(amount);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + "]";
	}

	@Override
	public int compareTo(BankAccount o) {
		return (int) (this.balance - o.getBalance());
	}
}
