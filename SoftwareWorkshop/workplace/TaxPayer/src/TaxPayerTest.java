
public class TaxPayerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TaxPayer john = new TaxPayer("John Smith", 10000.00, 123);
		TaxPayer mary = new TaxPayer("Mary Smith", 10.00, 124);
		System.out.println("£" + john.payableTax);

		System.out.println(john);

		System.out.println(mary);
	}

}
