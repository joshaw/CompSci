import java.awt.*;
import javax.swing.*;

public class PredictiveGUI {
	private static void initGUI() {
		JFrame frame = new JFrame("Predictive");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel(new GridLayout(3,4));

		JLabel label = new JLabel("");
		JButton b1 = new JButton("Button");
		JButton b2 = new JButton("Button");
		JButton b3 = new JButton("Button");
		JButton b4 = new JButton("Button");
		JButton b5 = new JButton("Button");
		JButton b6 = new JButton("Button");
		JButton b7 = new JButton("Button");
		JButton b8 = new JButton("Button");
		JButton b9 = new JButton("Button");

		frame.getContentPane().add(label);
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		frame.getContentPane().add(b3);
		frame.getContentPane().add(b4);
		frame.getContentPane().add(b5);
		frame.getContentPane().add(b6);
		frame.getContentPane().add(b7);
		frame.getContentPane().add(b8);
		frame.getContentPane().add(b9);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initGUI();
			}
		});
	}
}
