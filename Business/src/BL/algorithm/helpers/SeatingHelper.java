package BL.algorithm.helpers;

import BL.booking.Bookable;
import BL.restaurant.table.Table;

import java.util.ArrayList;
import java.util.HashMap;

public class SeatingHelper {



    public static HashMap<Integer, HashMap<Integer, Bookable>> convertTable(ArrayList<Table> tables) {

       HashMap<Integer, HashMap<Integer,Bookable>> tablesBooking = new HashMap<>();
        for (int i = 0; i < tables.size(); i++) {
            tablesBooking.put(i,new HashMap<>(fillBooking()));
        }

        return tablesBooking;
    }
    public  static HashMap<Integer, Bookable> fillBooking() {
        HashMap<Integer, Bookable> a = new HashMap<>();
        for (int i = 0; i < 24; i++) {
            a.put(i, null);
        }

        return a;
    }



}
