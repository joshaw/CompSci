public class GoldCardTest {
	public static void main(String[] args) {

		System.out.println("Credit Card");
		CreditCard ccTest = new CreditCard("TestCard", "1234abcd", 1000, 5000);

		System.out.println(ccTest);

		System.out.println("Gold Card");
		GoldCard gcTest = new GoldCard("TestGold", "9876zyxw", 2000, 10000, 200);

		System.out.println(gcTest);

	}
}
