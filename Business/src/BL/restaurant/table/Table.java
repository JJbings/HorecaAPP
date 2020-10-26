package BL.restaurant.table;

import BL.restaurant.table.interfacesExtraSeats.ExtraSeatsBehavior;

import java.io.Serializable;

public abstract class Table implements Serializable {
    private final int maxSeats;
    private final int minSeats;
    private int avgSeats;
    private final int tableNr;
    protected ExtraSeatsBehavior extraSeatsBehavior;


    //constructor
    public Table(int maxSeats, int minSeats, int tableNr) {
        this.maxSeats = maxSeats;
        this.minSeats = minSeats;
        this.tableNr = tableNr;


    }



    //Setters


    public final void setAvgSeats(int avgSeats) {
        this.avgSeats = avgSeats;
    }

    //Getters
    public final int getMinSeats() {
        return minSeats;
    }

    public final int getMaxSeats() {
        return maxSeats;
    }

    public final int getAvgSeats() {
        return avgSeats;
    }

    public final int getTableNr() {
        return tableNr;
    }


    //Methoden
    public final int getExtraSeats() {
        return extraSeatsBehavior.getExtraSeats();
    }


    @Override
    public final String toString() {
        return "Tafelnummer: " + this.tableNr;
    }
}
