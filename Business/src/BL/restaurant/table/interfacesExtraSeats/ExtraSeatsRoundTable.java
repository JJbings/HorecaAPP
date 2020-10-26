package BL.restaurant.table.interfacesExtraSeats;

import java.io.Serializable;

public class ExtraSeatsRoundTable implements ExtraSeatsBehavior, Serializable {
    @Override
    public int getExtraSeats() {
        return 3;

    }
}
