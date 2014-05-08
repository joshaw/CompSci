/* Created : Mon 05 May 2014 04:43 PM
 * Modified: Mon 05 May 2014 06:37 PM
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class ActionPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    JButton down = new JButton("down");
    JButton up = new JButton("up");
    int num = 0;
    JTextField number = new JTextField("" + num);

    public ActionPanel() {
        add(down);
        add(number);
        add(up);
        down.addActionListener(new Listener());
        up.addActionListener(new Listener());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ActionPanel2");
        JPanel pane = new ActionPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(pane);
        frame.pack();
        frame.setVisible(true);
    }

    public class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == down) {
                num--;
            } else if (e.getSource() == up) {
                num++;
            }
            number.setText("" + num);
        }

    }
}
