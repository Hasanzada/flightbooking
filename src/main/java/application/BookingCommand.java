package application;

import console.Menu;
import controller.BookingController;
import entity.Booking;
import entity.Passenger;

import java.util.*;

public class BookingCommand {

    public static void searchFlight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("city");
        String city = sc.nextLine();
        System.out.println("date");
        String sdate = sc.nextLine();
        System.out.println("ticket");
        int ticket_count = sc.nextInt();
        Menu.showSearchedFlight(city, sdate);
        Menu.showBookingYesNo();
        int s = sc.nextInt();
        //System.out.println(orderBooking(s,ticket_count));
        if(orderBooking(s,ticket_count) != null){
            BookingController bookingController = new BookingController();
            bookingController.addBooking(orderBooking(s,ticket_count) );
            Commands.commands();
        }else {
            Commands.commands();
        }
    }

    public static Booking orderBooking(int k, int ticket_count) {

        int count = 0;
        if (k == 1) {
            System.out.println("Enter flight id");
            Scanner sc = new Scanner(System.in);
            int flight_id =sc.nextInt();
            List<Passenger>passengers = new ArrayList<>();
            for (int i = 0; i < ticket_count; i++) {
                sc = new Scanner(System.in);
                System.out.println("enter passenger name ");
                String name = sc.nextLine();
                System.out.println("enter passenger surname ");
                String surname = sc.nextLine();
                passengers.add( new Passenger(++count,name,surname));
            }
            return  new Booking(1,passengers,flight_id);

        } else {
            Menu.showMenu();
            return null;
        }
    }
}
