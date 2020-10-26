package BL.algorithm.helpers;

import BL.booking.Bookable;
import BL.booking.Booking;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BookableHelperTest {


    @Test
    void bookablesPerDate() {
        //arrange
        ArrayList<Bookable> bookings = new ArrayList<>();

        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("16:00"), "joco", 4);
        Bookable booking2 = new Booking(LocalDate.now(), LocalTime.parse("16:00"), "joco", 4);
        Bookable booking3 = new Booking(LocalDate.parse("2020-01-10"), LocalTime.parse("16:00"), "joco", 4);
        bookings.add(booking);
        bookings.add(booking2);
        bookings.add(booking3);
        ArrayList<Bookable> bookingsActual = new ArrayList<>();
        bookingsActual.add(booking);
        bookingsActual.add(booking2);
        //act
        bookings = BookableHelper.bookablesPerDate(bookings, LocalDate.now());
        //assert
        assertEquals(2, bookings.size());
    }

    @Test
    void startingBox() {

        //arrange
        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("16:00"), "joco", 4);
        //act
        int result = BookableHelper.startingBox(booking);
        //assert
        assertEquals(0, result);
    }

    @Test
    void StartingBoxEnd() {

        //Arrange
        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 4);

        //act
        int result = BookableHelper.startingBox(booking);
        //assert
        assertEquals(23, result);

    }
}