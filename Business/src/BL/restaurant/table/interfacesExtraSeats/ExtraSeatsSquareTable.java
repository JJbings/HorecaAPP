package BL.restaurant.table.interfacesExtraSeats;

import java.io.Serializable;

public class ExtraSeatsSquareTable implements ExtraSeatsBehavior, Serializable {

    @Override
    public int getExtraSeats() {
        return 2;
    }
}
