package simulacro.view;

import java.awt.event.*;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import simulacro.controller.Controller;
import simulacro.controller.GUIController;

public class Menu extends JMenu {

    private GUIController guiController = GUIController.getInstance();

    Menu(Controller controller) {
        super("Menu");

        JMenuItem buyTicket = new JMenuItem("Buy ticket");

        add(buyTicket);
        buyTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.buyTicket();
            }
        });
    }

}
