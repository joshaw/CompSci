public class Invoice {

	private int accountNumber;
	private int sortCode;
	private double amount;

	public Invoice(int accountNumber, int sortCode, double amount) {
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
		this.amount = amount;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setSortCode(int sortCode) {
		this.sortCode = sortCode;
	}

	public int getSortCode() {
		return sortCode;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public double getMeasure() {
		return amount;
	}
}
