package BL.algorithm;

import BL.algorithm.helpers.SeatingHelper;
import BL.booking.Bookable;
import BL.booking.Booking;
import BL.restaurant.table.RoundTable;
import BL.restaurant.table.Table;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IAlgorithmBaseTest {

    @Test
    void filterBookingsByDate() {
        //arrange
        Bookable booking = new Booking(LocalDate.parse("2020-06-18"), LocalTime.parse("21:45"), "joco", 4);
        Bookable booking2 = new Booking(LocalDate.parse("2020-06-18"), LocalTime.parse("21:45"), "joco", 6);
        Bookable booking3 = new Booking(LocalDate.parse("2020-06-19"), LocalTime.parse("21:45"), "joco", 8);
        MaxCondition maxCondition = new MaxCondition();
        ArrayList<Bookable> bookings = new ArrayList<>();
        bookings.add(booking);
        bookings.add(booking2);
        bookings.add(booking3);

        // act
        bookings = maxCondition.filterBookingsByDate(bookings, LocalDate.parse("2020-06-19"));


        // assert
        assertEquals(1, bookings.size());
    }

    @Test
    void sortBookings() {
        //Arrange
        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 4);
        Bookable booking2 = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 6);
        Bookable booking3 = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 8);
        MaxCondition maxCondition = new MaxCondition();
        ArrayList<Bookable> bookings = new ArrayList<>();
        bookings.add(booking);
        bookings.add(booking2);
        bookings.add(booking3);


        //Act
        maxCondition.sortBookings(bookings);

        //Assert
        assertEquals(8, bookings.get(0).getVisitors());
    }


    @Test
    void getStartingTime() {
        //arrange
        MaxCondition maxCondition = new MaxCondition();
        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 4);
        //act
        int result = maxCondition.getStartingTime(booking);

        //assert
        assertEquals(23, result);
    }

    @Test
    void getReservationDuration() {
        //arrange
        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("16:00"), "joco", 4);
        MaxCondition maxCondition = new MaxCondition();
        //act
        int result = maxCondition.getReservationDuration(booking);
        //assert
        assertEquals(8, result);
    }

    @Test
    void getReservationDurationIs2145() {
        //arrange
        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 4);
        MaxCondition maxCondition = new MaxCondition();
        //act
        int result = maxCondition.getReservationDuration(booking);
        //assert
        assertEquals(1, result);
    }

    @Test
    void getReservationDurationIs2100() {
        //arrange
        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:00"), "joco", 4);
        MaxCondition maxCondition = new MaxCondition();
        //act
        int result = maxCondition.getReservationDuration(booking);
        //assert
        assertEquals(4, result);
    }

    @Test
    void checkIfTimesAreFree() {
        //Arrange
        MaxCondition maxCondition = new MaxCondition();
        ArrayList<Table> tables = new ArrayList<>();
        tables.add(new RoundTable(4, 1, 1));

        maxCondition.bookingsAndTables = SeatingHelper.convertTable(tables);
        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 4);

        for (int i = 0; i < 10; i++) maxCondition.bookingsAndTables.get(0).put(i, booking);


        //Act
        boolean result = maxCondition.checkIfTimesAreFree(0, 0, 8);


        //Assert
        assertEquals(false, result);

    }

    @Test
    void setBookings() {
        //arrange
        MaxCondition maxCondition = new MaxCondition();
        ArrayList<Table> tables = new ArrayList<>();
        tables.add(new RoundTable(4, 1, 1));
        maxCondition.bookingsAndTables = SeatingHelper.convertTable(tables);
        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 4);


        //act
        maxCondition.setBookings(0, 0, 8, booking);


        //Assert
        assertEquals(booking, maxCondition.bookingsAndTables.get(0).get(0));
        assertEquals(booking, maxCondition.bookingsAndTables.get(0).get(7));
    }

    @Test
    void linkBooking() {
        //arrange
        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 4);
        MaxCondition maxCondition = new MaxCondition();

        //act
        maxCondition.linkBooking(booking,1);


        //assert

        assertEquals(1,booking.getTable());
    }
}