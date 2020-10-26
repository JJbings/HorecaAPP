package BL.restaurant;

import BL.dataProviders.Interface.BookingDataProvider;

import java.io.Serializable;
import java.util.ArrayList;


public class User implements Serializable {
    private final String userName;
    private final ArrayList<Restaurant> restaurants;
    private final String password;
    private transient BookingDataProvider bookingDataProvider;




    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.restaurants = new ArrayList<Restaurant>();





    }


    //Getters

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public BookingDataProvider getBookingDataProvider() {
        return bookingDataProvider;
    }
    //Setters


    public void setBookingDataProvider(BookingDataProvider bookingDataProvider) {
        this.bookingDataProvider = bookingDataProvider;

    }



    //Methoden
    public ArrayList<Restaurant> addRestaurant(String name, String adress) {


        // Maakt een nieuwe restaurat object aan met opgegeven naam en adres

        this.restaurants.add(new Restaurant(name, adress, restaurants.size() + 1));
        return this.restaurants;

    }


    public void deleteRestaurant(Restaurant restToDelete) {
        restaurants.remove(restToDelete);

    }


}
