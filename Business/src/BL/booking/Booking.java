package BL.booking;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking implements Bookable {
    //Variables

    private final int visitors;
    private final LocalDate bookedDate;
    private final LocalTime bookedTime;
    private final String bookedName;
    private int table;

    //Constructor
    public Booking(LocalDate bookedDate, LocalTime bookedTime, String bookedName, int visitors) {
        //  this.visitors = new ArrayList<>();
        this.bookedTime = bookedTime;
        this.bookedDate = bookedDate;
        this.bookedName = bookedName;
        this.visitors = visitors;


    }

    //Getters
    public int getVisitors() {
        return visitors;
    }


    public LocalDate getBookedDate() {
        return bookedDate;
    }


    public LocalTime getBookedTime() {
        return bookedTime;
    }


    public String getBookedName() {
        return bookedName;
    }


    @Override
    public int getTable() {
        return table;
    }

    //Setters


    public void setTable(int table) {
        this.table = table;
    }

    @Override
    public void resetTable() {
        this.table = 0;
    }


}

