/*#############################################################################
#                                    Model                                    #
#############################################################################*/

import java.util.Observable;
public final class T9Model {

	private static final String INITIAL_VALUE = "0";
	private int total;

	T9Model() {
		reset();
	}

	public void reset() {
		total = 0;
	}

	public void setValue(String val) {
		System.out.println("Value = " + val);
	}

    public void printValue(int val) {
        System.out.println("Int = " + val);
    }
}
