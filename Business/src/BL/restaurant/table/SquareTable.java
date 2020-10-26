package BL.restaurant.table;

import BL.restaurant.table.interfacesExtraSeats.ExtraSeatsSquareTable;

public class SquareTable extends Table {


    public SquareTable(int maxSeats, int minSeats, int tableNr) {
        super(maxSeats, minSeats, tableNr);
        extraSeatsBehavior = new ExtraSeatsSquareTable();
    }
}
