package BL.algorithm;

import BL.booking.Bookable;
import BL.restaurant.table.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class MaxMinCondition extends IAlgorithmBase {


    @Override
    public boolean checkCondition(Table table, Bookable booking) {
        if (booking.getVisitors() <= table.getMaxSeats() && booking.getVisitors() >= table.getMinSeats()) {
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




/*
    @Override
    public void doMagic(LocalDate bookingDate, ArrayList<Bookable> bookings, ArrayList<Table> tables) {
        super.templateMethod(bookings, tables, bookingDate);
    }*/
}


   /*
        public void doMagic2(LocalDate bookingDate) {
            ArrayList<Bookable> filteredBookings = super.filterBookingsByDate();//todo helper gebruiken


            for (int bookingNr = 0; bookingNr < filteredBookings.size(); bookingNr++) {  //loop door bookings


                for (Integer key : bookingsAndTables.keySet()) { // loop through tables and times to check if its free

                    if (super.tables.get(key).getMaxSeats() < filteredBookings.get(bookingNr).getVisitors())
                        continue;//check if booking does not exceed max seats ----first strategy


                    int startTime = getStartingTime(bookings.get(bookingNr)); //get the starting time
                    if (checkIfTimesAreFree(key, startTime, getReservationDuration(filteredBookings.get(bookingNr)))) { //check is ftimes are freee

                        for (int i = startTime; i < getReservationDuration(bookings.get(bookingNr)); i++) {

                            bookingsAndTables.get(key).put(i, filteredBookings.get(bookingNr)); // set booking to the times

                        }

                        filteredBookings.get(bookingNr).setTable(tables.get(key).getTableNr());// link table to booking
                        break;
                    }
                }
            }

        }
    */