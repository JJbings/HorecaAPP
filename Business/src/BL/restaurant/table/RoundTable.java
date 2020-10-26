package BL.restaurant.table;

import BL.restaurant.table.interfacesExtraSeats.ExtraSeatsRoundTable;

public class RoundTable extends Table {

    public RoundTable(int maxSeats, int minSeats, int tableNr) {
       super(maxSeats,minSeats,tableNr);
       extraSeatsBehavior = new ExtraSeatsRoundTable();


    }

}
