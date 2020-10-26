package BL.algorithm;

import BL.booking.Bookable;
import BL.booking.Booking;
import BL.restaurant.table.RoundTable;
import BL.restaurant.table.Table;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class MaxMinConditionTest {

    @Test
    void checkCondition() {
        //arrange

        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 2);
        MaxMinCondition maxMinCondition= new MaxMinCondition();
        Table table = new RoundTable(4, 3, 1);

        //act
        boolean result = maxMinCondition.checkCondition(table, booking);

        //assert
        assertEquals(false,result);
    }

    @Test
    void checkCondition2() {
        //arrange

        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 2);
       MaxMinCondition maxMinCondition= new MaxMinCondition();
        Table table = new RoundTable(4, 3, 1);

        //act
        boolean result = maxMinCondition.checkCondition(table, booking);

        //assert
        assertEquals(false,result);
    }

    @Test
    void checkCondition3() {
        //arrange

        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 3);
        MaxMinCondition maxMinCondition= new MaxMinCondition();
        Table table = new RoundTable(4, 3, 1);

        //act
        boolean result = maxMinCondition.checkCondition(table, booking);

        //assert
        assertEquals(true,result);
    }
}