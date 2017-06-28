/**
 * Created by jli on 6/28/2017.
 */

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextField;

public class Test extends JFrame {
    public void Test() {
        setLayout(new FlowLayout());
        JTextField field = new JTextField(20);
        add(field, BorderLayout.SOUTH);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        Test foo = new Test();
    }

}
