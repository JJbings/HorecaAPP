package BL.algorithm;

import BL.booking.Bookable;
import BL.booking.Booking;
import BL.restaurant.table.RoundTable;
import BL.restaurant.table.Table;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConditionTest {

    @Test
    void checkCondition() {
        //arrange

        Bookable booking = new Booking(LocalDate.now(), LocalTime.parse("21:45"), "joco", 5);
        MaxCondition maxCondition = new MaxCondition();
        Table table = new RoundTable(4, 1, 1);

        //act
        boolean result = maxCondition.checkCondition(table, booking);

        //assert
        assertEquals(false,result);
    }
}