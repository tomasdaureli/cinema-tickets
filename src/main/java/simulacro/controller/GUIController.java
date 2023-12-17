package simulacro.controller;

public class GUIController {

    private Controller controller = Controller.getInstance();

    private static GUIController instance;

    private GUIController() {
    }

    public static GUIController getInstance() {
        if (instance == null) {
            instance = new GUIController();
        }
        return instance;
    }

    public void buyTicket() {
        
    }

}
