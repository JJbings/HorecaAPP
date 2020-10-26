package BL.booking;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingTest {

    @Test
    void getVisitors() {

        //Arrange
        Booking booking = new Booking(LocalDate.parse("2020-01-01"), LocalTime.parse("16:00"), "Joco", 5);
        //Act

        //Assert
        assertEquals(5, booking.getVisitors());
    }

    @Test
    void getBookedDate() {

        //Arrange
        Booking booking = new Booking(LocalDate.parse("2020-01-01"), LocalTime.parse("16:00"), "Joco", 5);
        //Act

        //Assert
        assertEquals(LocalDate.parse("2020-01-01"), booking.getBookedDate());
    }

    @Test
    void getBookedTime() {

        //Arrange
        Booking booking = new Booking(LocalDate.parse("2020-01-01"), LocalTime.parse("16:00"), "Joco", 5);
        //Act

        //Assert
        assertEquals(LocalTime.parse("16:00"), booking.getBookedTime());
    }

    @Test
    void getBookedName() {

        //Arrange
        Booking booking = new Booking(LocalDate.parse("2020-01-01"), LocalTime.parse("16:00"), "Joco", 5);
        //Act

        //Assert
        assertEquals("Joco", booking.getBookedName());
    }

    @Test
    void getTable() {

        //Arrange
        Booking booking = new Booking(LocalDate.parse("2020-01-01"), LocalTime.parse("16:00"), "Joco", 5);
        booking.setTable(1);
        //Act

        //Assert
        assertEquals(1, booking.getTable());
    }

    @Test
    void setTable() throws NoSuchFieldException, IllegalAccessException {

        //Arrange
        Booking booking = new Booking(LocalDate.parse("2020-01-01"), LocalTime.parse("16:00"), "Joco", 5);

        //Act
        booking.setTable(5);
        //Assert
        assertEquals(5, booking.getTable());
        final Field field = booking.getClass().getDeclaredField("table");
        field.setAccessible(true);
        assertEquals(5, field.get(booking) );
    }

    @Test
    void resetTable() {

        //Arrange
        Booking booking = new Booking(LocalDate.parse("2020-01-01"), LocalTime.parse("16:00"), "Joco", 5);
        booking.setTable(5);
        //Act
        booking.resetTable();
        //Assert
        assertEquals(0,booking.getTable());
    }
}