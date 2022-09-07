package banking;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private static LinkedHashMap<Long, Account> accounts = new LinkedHashMap();
	private Long accountNumber = 0L;

	public Bank() {
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		this.accountNumber = accountNumber+1;
		Account newAccount = new CommercialAccount(company, accountNumber,pin, startingDeposit);
		//accounts = new LinkedHashMap<>();
		accounts.put(accountNumber,newAccount);
		//System.out.print(accounts.get(accountNumber));

		return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		this.accountNumber = accountNumber+1;
		Account newAccount = new ConsumerAccount(person,accountNumber ,pin, startingDeposit);
		//accounts = new LinkedHashMap<>();
		accounts.put(accountNumber,newAccount);
		//System.out.print("PRNT consumer ACOUNT DETAILS" + accounts.get(accountNumber).toString() + accountNumber);
        return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		if(getAccount(accountNumber).validatePin(pin)) {
			return true;
		}else return false;
	}

	public double getBalance(Long accountNumber) {
		// completed
		 return getAccount(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// completed
		this.getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// completed
		//true if amount could be withdrawn; otherwise, return false.
		System.out.print("PRINT MAP" +accounts.keySet() + "Account number to look "+accountNumber
		+ " Amount is deducting "+ amount
		+ " Account has balance "+getAccount(accountNumber).getBalance() +"------");

		//if(Double.compare(getAccount(accountNumber).getBalance(), amount) > 0){
		//if(getAccount(accountNumber).getBalance() > amount){
		double balance = getBalance(accountNumber) - amount;
		System.out.print(" BALANCE before debit "+ getBalance(accountNumber));

		System.out.print(" DO MINUS "+ balance);
		if(balance >= 0.0){
			return true;
		} else{
			return false;
		}
	}
}
