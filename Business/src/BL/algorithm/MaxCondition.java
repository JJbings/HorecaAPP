package BL.algorithm;

import BL.booking.Bookable;
import BL.restaurant.table.Table;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxCondition extends IAlgorithmBase {


    @Override
    public boolean checkCondition(Table table, Bookable booking) {
        if (table.getMaxSeats() >= booking.getVisitors()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Bookable> sortBookings(ArrayList<Bookable> filteredBookings) {
        filteredBookings.sort(Comparator.comparing(Bookable::getVisitors).reversed());
        return filteredBookings;
    }




}
