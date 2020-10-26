package BL.dataProviders.Interface;

import BL.booking.Bookable;

import java.util.ArrayList;

public interface BookingDataProvider {

    ArrayList<Bookable> getAllBookings();

    void addBooking(Bookable booking);

    void resetBookings();

    void saveBookings();


}
