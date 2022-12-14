package banking;

/**
 * Abstract bank account class.<br>
 * <br>
 *
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account implements AccountInterface{
	private AccountHolder accountHolder;
	private Long accountNumber;
	private int pin;
	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
		// complete the constructor
		this.accountHolder=accountHolder;
		this.accountNumber=accountNumber;
		this.pin=pin;
		this.balance=startingDeposit;
	}

    public Account() {
    }

	public AccountHolder getAccountHolder() {
		// complete the function
        return this.accountHolder;
	}

	public boolean validatePin(int attemptedPin) {
		// complete the function
        return this.pin == attemptedPin;
	}

	public double getBalance() {
		// complete the function
		System.out.println("Account"+this.balance);
        return this.balance;
	}

	public Long getAccountNumber() {
		// complete the function
        return this.accountNumber;
	}

	public void creditAccount(double amount) {
		// complete the function
		this.balance += amount;
	}

	public boolean debitAccount(double amount) {
		// complete the function
		if(this.balance > amount) {
			this.balance -= amount;
			return true;
		}else return false;
	}

	@Override
	public String toString() {
		return "Account{" +
				"accountHolder=" + accountHolder +
				", accountNumber=" + accountNumber +
				", pin=" + pin +
				", balance=" + balance +
				'}';
	}
}
