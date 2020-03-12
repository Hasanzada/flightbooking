package application;

import console.Menu;
import controller.Controller;
import controller.FlightController;


public class BookingApp {
    public static void main(String[] args) {
        //main
        Menu.showMenu();
        Controller controller = new Controller();
        controller.controlApp();

    }
}
