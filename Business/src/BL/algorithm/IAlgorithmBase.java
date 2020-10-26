package BL.algorithm;

import BL.algorithm.helpers.SeatingHelper;
import BL.booking.Bookable;
import BL.restaurant.table.Table;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class IAlgorithmBase implements IAlgorithmStrategy {
    protected final LocalTime endTime;
    protected final LocalTime startingTime;
    protected final int averageSeatingTime;
    protected HashMap<Integer, HashMap<Integer, Bookable>> bookingsAndTables;


    //Constructor
    public IAlgorithmBase() {
        this.endTime = LocalTime.parse("21:45");
        this.startingTime = LocalTime.parse("16:00");
        this.averageSeatingTime = 8;
        this.bookingsAndTables = new HashMap<>();
    }


    //RECIPE TEMPLATE METHOD PATTERN *****HOLLYWOOD PRINCIPAL*******
    // 1. Filter obv datum  ---                 SAME
    // 2. Sort the bookings ---               DIFFERENT
    // 3. Loop door bookings ----               SAME
    // 4. Loop through tables   ---             SAME
    // 5. Check if seats condition match ----   DIFFERENT
    // 6. Get the starting time-box --           SAME
    // 7. Get reservation duration              SAME
    // 8. Check if all times are free  --       SAME
    // 9. Set the times as taken ---            SAME
    // 10. Link booking with table ---           SAME

    //Template Method

    @Override
    public final void doMagic(ArrayList<Bookable> bookings, ArrayList<Table> tables, LocalDate date) {

        bookingsAndTables = SeatingHelper.convertTable(tables);
        // 1. Filter
        bookings = filterBookingsByDate(bookings, date);
        // 2. Sort
        bookings = sortBookings(bookings); //abstract

        // 3. Loop bookings
        for (Bookable booking : bookings) {

            // 4. Loop Tables
            for (Integer key : bookingsAndTables.keySet()) {

                // 5. Check condition
                if (!checkCondition(tables.get(key), booking)) continue; // abstract

                // 6. Get starting time
                int startingTime = getStartingTime(booking);

                // 7. Get Duration
                int duration = getReservationDuration(booking);

                // 8. Check if all times are free
                if (checkIfTimesAreFree(key, startingTime, duration)==true) {

                    // 9. Set the times as taken
                    setBookings(key, startingTime, duration, booking);

                    //10. Link booking and table
                    linkBooking(booking, tables.get(key).getTableNr());
                    break;
                }

            }


        }


    }


    //Step 1
    public ArrayList<Bookable> filterBookingsByDate(ArrayList<Bookable> bookings, LocalDate date) {
        ArrayList<Bookable> filteredBookings = new ArrayList<>();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookedDate().equals(date)) {
                filteredBookings.add(bookings.get(i));
            }
        }
        return filteredBookings;
    }

    //Step 2 (abstract)
    public abstract ArrayList<Bookable> sortBookings(ArrayList<Bookable> filteredBookings);

    //Step 5 (abstract)
    public abstract boolean checkCondition(Table table, Bookable booking);

    //Step 6
    public int getStartingTime(Bookable booking) {
        int startTime;
        if (booking.getBookedTime() == LocalTime.parse("16:00")) {
            startTime = 0;
        } else {
            startTime = (int) ChronoUnit.MINUTES.between(startingTime, booking.getBookedTime()) / 15;
        }
        return startTime;
    }

    //Step 7
    public int getReservationDuration(Bookable booking) {
        long reservationDuration;

        if (booking.getBookedTime().isBefore(endTime.minusMinutes((averageSeatingTime - 2) * 15))) {
            return averageSeatingTime;

        } else if (booking.getBookedTime() == LocalTime.parse("21:45")) {
            return 1;

        } else {
            reservationDuration = ChronoUnit.MINUTES.between(booking.getBookedTime(), endTime) / 15;
            return (int) reservationDuration + 1;
        }


    }

    //Step 8
    public boolean checkIfTimesAreFree(int tableNumber, int startingTime, int duration) {
        for (int i = startingTime; i < duration + startingTime; i++) {
            if (bookingsAndTables.get(tableNumber).get(i) != null) return false;
        }
        return true;
    }

    //Step 9
    public void setBookings(int tableNumber, int startingTime, int duration, Bookable booking) {
        for (int i = startingTime; i < duration + startingTime; i++) {
            bookingsAndTables.get(tableNumber).put(i, booking);
        }


    }

    //Step 10
    public void linkBooking(Bookable booking, int tableNumber) {
        booking.setTable(tableNumber);
    }


}