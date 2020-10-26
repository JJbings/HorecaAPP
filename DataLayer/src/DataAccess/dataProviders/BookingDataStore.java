package DataAccess.dataProviders;

import BL.booking.Bookable;
import BL.dataProviders.Interface.BookingDataProvider;
import DataAccess.DataWriterReader;

import java.io.IOException;
import java.util.ArrayList;

//import DataAccess.data.Booking;

public class BookingDataStore implements BookingDataProvider {

    private ArrayList<Bookable> bookings;

    public BookingDataStore() throws IOException {


        bookings = new DataWriterReader().readFromData();
    }

    @Override
    public ArrayList<Bookable> getAllBookings() {
        return bookings;
    }

    @Override
    public void addBooking(Bookable booking) {
        bookings.add(booking);
    }

    @Override
    public void resetBookings() {
        for (int i = 0; i < bookings.size(); i++) {
            bookings.get(i).resetTable();
        }
    }

    @Override
    public void saveBookings() {
        DataWriterReader dataWriterReader = new DataWriterReader();
        try {
            dataWriterReader.writeToData(bookings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
