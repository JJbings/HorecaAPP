package BL.algorithm;

import BL.booking.Bookable;
import BL.restaurant.table.Table;

import java.time.LocalDate;
import java.util.ArrayList;


// THIS IS THE STRATEGY PATTERN IMPLEMENTATION
public interface IAlgorithmStrategy {
    public void doMagic(ArrayList<Bookable> bookings, ArrayList<Table> tables, LocalDate date);
}
