/** Main method for the T9 Predictive Text GUI. Initiates a model instance and
 * a view instance and sets the application to be visible.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : SoftwareWorkshop2
 * Exercise  : Worksheet4
 * File name : T9PanelMain.java
 * @version 2014-02-19
 */
import javax.swing.UIManager;

class T9PanelMain {
	public static void main(String[] args) {

		try {
        	UIManager.setLookAndFeel(
        			"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    	} catch(Exception e){
    		System.err.println("Java Look and Feel, \"Nimbus\" not availible");
    	}

		T9Model model = new T9Model();
		T9View view = new T9View(model);
		model.addObserver(view);

		view.setVisible(true);
	}
}
