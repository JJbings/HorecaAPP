package BL.algorithm;

import BL.booking.Bookable;
import BL.restaurant.table.Table;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxPlusExtraSeats extends IAlgorithmBase {
    @Override
    public ArrayList<Bookable> sortBookings(ArrayList<Bookable> filteredBookings) {
        filteredBookings.sort(Comparator.comparing(Bookable::getVisitors).reversed());
        return filteredBookings;
    }

    @Override
    public boolean checkCondition(Table table, Bookable booking) {
        if (booking.getVisitors() <= (table.getMaxSeats()+table.getExtraSeats()) && booking.getVisitors() >= table.getMinSeats()) {
            return true;

        } else {
            return false;
        }
    }
}
