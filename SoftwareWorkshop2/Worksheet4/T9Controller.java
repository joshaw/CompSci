import java.awt.*;
import java.awt.event.*;

public class T9Controller {

    private T9Model model;
    private T9View view;

    public T9Controller(T9Model model, T9View view) {
        this.model = model;
        this.view = view;

        view.addButtonListner(new ButtonListener());
    }

    class ButtonListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		System.out.println(e.getActionCommand());
    		view.setTextArea(e.getActionCommand());
    	}
    }

}
