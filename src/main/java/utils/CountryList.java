package utils;

import java.util.ArrayList;
import java.util.List;

public class CountryList {
    public static List<String> getAllCountries(){
        List<String> countries = new ArrayList<String>();
        for(Country country : Country.values()){
            countries.add(country.name());
        }
        return countries;
    }
}
