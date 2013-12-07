import org.junit.Test;
import static org.junit.Assert.*;

public class MeasurableTest {

	public static void main(String[] args) {

		Invoice i = new Invoice(123456, 654321, 100.00);
		System.out.println(i.getMeasure());

		Patient p = new Patient("Mr Smith", 35, 70.0);
		System.out.println(p.getMeasure());

	}

	@Test
	public void testInvoice() {
		Invoice i = new Invoice(123456, 654321, 100.00);
		assertEquals(100.0, i.getMeasure(), 0.0001);
	}

	@Test
	public void testPatient() {
		Patient p = new Patient("Mr Smith", 35, 70.0);
		assertEquals(70.0, p.getMeasure(), 0.0001);
	}

}
