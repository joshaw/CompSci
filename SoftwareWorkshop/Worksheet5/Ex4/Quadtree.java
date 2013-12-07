/** A Quadtree is a representation of a data structure with exactly 4 children
 * for each node. This class holds an instance of a Quadtree.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 5
 * Exercise  : 4
 * File name : Quadtree.java
 * @version 2013-12-07
 */
import java.util.InputMismatchException;

public class Quadtree {

	private int value;
	private boolean isValue;
	private Quadtree lu, ll, ru, rl;

	public Quadtree(Quadtree lu, Quadtree ll, Quadtree ru, Quadtree rl) {
		this.lu = lu;
		this.ll = ll;
		this.ru = ru;
		this.rl = rl;
	}

	/** Create a base level Quadtree with a single value, rather than a sub
	 * Quadtree as the contents.
	 *
	 * @param value the number stored in the Quadtree
	 */
	public Quadtree(int value) {

		/* Quadtrees can be used to store images, so a value outside the 0-255
		 * greyscale range would not be accepted. */
		if (value >= 0 && value < 256) {
			this.value = value;
			this.isValue = true;
		} else {
			throw new InputMismatchException("Value must be between 0 and " +
					"255. Found " + value);
		}
	}

	public Quadtree getLU() {
		return lu;
	}
	public void setLU(Quadtree lu) {
		this.lu = lu;
	}

	public Quadtree getLL() {
		return ll;
	}
	public void setLL(Quadtree ll) {
		this.ll = ll;
	}

	public Quadtree getRU() {
		return ru;
	}
	public void setRU(Quadtree ru) {
		this.ru = ru;
	}

	public Quadtree getRL() {
		return rl;
	}
	public void setRL(Quadtree rl) {
		this.rl = rl;
	}

	public boolean isValue() {
		return isValue;
	}

	/** toString works by calling itself on each sub Quadtree in order. The
	 * elements are listed as [lu, ll, ru, rl], where each of lu, ll, ru, rl is
	 * an element, each of which can, itself, be a Quadtree.
	 *
	 * @return a string representing the whole of the Quadtree.
	 */
	@Override
	public String toString() {
		if (isValue) {
			return value + "";
		} else {
			return "[" + getLU().toString() + ", " + getLL().toString() + ", "
				+ getRU().toString() + ", " + getRL().toString() + "]";
		}
	}

	/** Rotates a Quadtree by 90 degrees.
	 *
	 * @param qt the Quadtree to be rotated
	 * @param direction the direction the Quadtree should be rotated. Allowed
	 * either "counter" for anti-clockwise (default) or "clock" for clockwise
	 * directions.
	 * @return a new Quadtree which is the original rotated by 90 degrees.
	 */
	public static Quadtree rot(Quadtree qt, String direction) {
		if (!(direction.equals("clock") || direction.equals("counter"))) {
			throw new InputMismatchException("Availible manipulations are " +
					"\"counter\" or \"clock\". Found " + direction);
		}

		// lu -> ll -> rl -> ru -> lu
		/* If the Quadtree contains just a value, then it can't be rotated. */
		if (qt.isValue()) {
			return qt;
		} else {

			/* Otherwise, using a temp variable, move each of the elements to
			 * the position next to it in the direction specified. */
			Quadtree temp;
			if (direction.equals("clock")) {
				temp = qt.getLU();
				qt.setLU(rot(qt.getLL(), "clock"));
				qt.setLL(rot(qt.getRL(), "clock"));
				qt.setRL(rot(qt.getRU(), "clock"));
				qt.setRU(rot(temp));
			} else if (direction.equals("counter")) {
				temp = qt.getLU();
				qt.setLU(rot(qt.getRU(), "counter"));
				qt.setRU(rot(qt.getRL(), "counter"));
				qt.setRL(rot(qt.getLL(), "counter"));
				qt.setLL(rot(temp));
			}
		}
		return qt;
	}

	/** Rotates a Quadtree by 90 degrees anti-clockwise.
	 *
	 * @param qt the Quadtree to be rotated
	 * @return a new Quadtree which is the original rotated by 90 degrees.
	 */
	public static Quadtree rot(Quadtree qt) {
		return rot(qt, "counter");
	}

	/** Rotates a Quadtree by 90 degrees.
	 *
	 * @param direction the direction the Quadtree should be rotated. Allowed
	 * either "counter" for anti-clockwise (default) or "clock" for clockwise
	 * directions.
	 * @return a new Quadtree which is the original rotated by 90 degrees.
	 */
	public Quadtree rot(String direction) {
		return rot(this, direction);
	}

	/** Rotates a Quadtree by 90 degrees anti-clockwise.
	 *
	 * @return a new Quadtree which is the original rotated by 90 degrees.
	 */
	public Quadtree rot() {
		return rot(this, "counter");
	}

}
