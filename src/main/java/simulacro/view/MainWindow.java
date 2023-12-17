package simulacro.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainWindow extends JFrame {

    public void showGUI() {

        JFrame frame = new JFrame("Simulacro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Click me!");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Hello world!");
            }
        });

        frame.getContentPane().add(button);

        frame.setSize(300, 200);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

}
