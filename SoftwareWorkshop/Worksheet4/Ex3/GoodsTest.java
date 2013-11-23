public class GoodsTest {
	public static void main(String[] args) {
		PerishableGood pg = new PerishableGood("Name", 1, 2, true, new Day(2, 5, 2013));

		pg.setBestBefore(new Day(3, 5, 2013));
	}
}
