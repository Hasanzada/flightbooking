package utils;

import entity.Flight;


import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class Utils {
    public static String getRandomCountry(){
        List<String> countries = CountryList.getAllCountries();
        Random r = new Random();
        return countries.get((int)(Math.random()*countries.size()));
    }

    public static int generateRandomNumber(){
        return (int)(Math.random()*100);
    }

    public static Flight getFlights(int id){
        Collection<Flight> flights = new ArrayList<>();
            Flight flight = new Flight(id, getRandomCountry(),getRandomCountry(),LocalDateTime.now()
                    .plusHours((int)(Math.random()*24+1))
                    .format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")), generateRandomNumber());

        return flight;
    }

}
