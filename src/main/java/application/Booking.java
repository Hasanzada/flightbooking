package application;

import console.Menu;
import controller.Controller;


public class Booking {
    public static void main(String[] args) {
        //main
        Menu.showMenu();
        Controller controller = new Controller();
        controller.controlApp();
    }
}
