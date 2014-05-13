/* Created : Mon 05 May 2014 04:43 PM
 * Modified: Fri 09 May 2014 07:59 PM
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class SimpleGUI extends JPanel {

    private static final long serialVersionUID = 1L;

    JButton down = new JButton("d");
    JButton up = new JButton("u");
    int num = 0;
    JTextField number = new JTextField("" + num, 3);

    public SimpleGUI() {
        add(down);
        add(number);
        add(up);
        down.addActionListener(new Listener());
        up.addActionListener(new Listener());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SimpleGUI");
        JPanel pane = new SimpleGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(pane);
        frame.pack();
        frame.setVisible(true);
    }

    public class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == down) {
                num--;
                // model.dec();
            } else if (e.getSource() == up) {
                num++;
                // model.inc();
            }
            number.setText("" + num);
        }

    }
}
