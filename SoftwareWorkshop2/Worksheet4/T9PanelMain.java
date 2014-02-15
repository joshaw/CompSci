import javax.swing.*;

class T9PanelMain {
    public static void main(String[] args) {
	JFrame frame = new JFrame("CounterPanel");
	JPanel pane = new T9Panel();
	JFrame.setDefaultLookAndFeelDecorated(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setContentPane(pane);
	frame.pack();
	frame.setResizable(false);
	frame.setVisible(true);
    }
}
