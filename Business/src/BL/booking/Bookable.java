package BL.booking;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Bookable {
    LocalDate getBookedDate();

    LocalTime getBookedTime();

    int getVisitors();

    int getTable();

    String getBookedName();

    void setTable(int table);

    void resetTable();
}
