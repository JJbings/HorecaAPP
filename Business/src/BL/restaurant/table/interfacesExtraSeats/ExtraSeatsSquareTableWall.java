package BL.restaurant.table.interfacesExtraSeats;

import java.io.Serializable;

public class ExtraSeatsSquareTableWall implements ExtraSeatsBehavior, Serializable {

    @Override
    public int getExtraSeats() {
        return 1;
    }
}
