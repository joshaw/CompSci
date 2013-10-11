
public class TaxPayer{

	String name;
	double income;
	int taxNumber;
	double payableTax;
	double taxRate;

	/**
	 * @param name
	 * @param income
	 * @param taxNumber
	 */
	public TaxPayer(String name, double income, int taxNumber) {
		this.name = name;
		this.income = income;
		this.taxNumber = taxNumber;
		this.taxRate = 0.2;
		this.payableTax = this.income * this.taxRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public int getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(int taxNumber) {
		this.taxNumber = taxNumber;
	}

	public double getPayableTax() {
		return payableTax;
	}

	public void setPayableTax(double payableTax) {
		this.payableTax = payableTax;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	@Override
	public String toString() {
		return name + " = [income=" + income + ", taxNumber=" + taxNumber +
			", payableTax=" + payableTax + "]";
	}

}
