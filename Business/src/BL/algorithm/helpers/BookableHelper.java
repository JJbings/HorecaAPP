package BL.algorithm.helpers;

import BL.booking.Bookable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class BookableHelper {

    static ArrayList<Bookable> bookingsPerDay;
    static LocalTime startTime = LocalTime.parse("16:00");

    //Create
    public static ArrayList<Bookable> bookablesPerDate(ArrayList<Bookable> bookings, LocalDate bookingDate) {
        bookingsPerDay = new ArrayList<>();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookedDate().equals(bookingDate)) {
                bookingsPerDay.add(bookings.get(i));
            }
        }

        return bookingsPerDay;

    }


    public static int startingBox(Bookable booking) {
        long startBox;
        if (booking.getBookedTime() == startTime) {
            startBox=0;
        } else {
            startBox = ChronoUnit.MINUTES.between(startTime, booking.getBookedTime());

        }

        return (int) startBox/15;
    }

}








