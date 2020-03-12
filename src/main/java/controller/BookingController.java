package controller;

import entity.Booking;
import entity.Flight;
import service.BookingService;

import java.util.Collection;

public class BookingController {

    BookingService bookingService = new BookingService();

    public Collection<Booking> getAllBooking(){
        return bookingService.getBookings();
    }

    public Booking getBook(int id){
        return bookingService.getBooking(id);
    }

    public void addBooking(Booking booking){
        bookingService.create(booking);
    }

}
