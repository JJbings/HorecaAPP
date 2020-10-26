package BL.restaurant;

import BL.algorithm.IAlgorithmStrategy;
import BL.dataProviders.Interface.BookingDataProvider;
import BL.restaurant.table.RoundTable;
import BL.restaurant.table.SquareTable;
import BL.restaurant.table.Table;
import BL.restaurant.table.TableType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Restaurant implements Serializable {
    private final String restaurantName;
    private final String restaurantAddress;
    private final int restaurantNumber;
    private final ArrayList<Table> tablesArray;
    transient private BookingDataProvider bookings;
    transient private IAlgorithmStrategy iAlgorithmStrategy;


    public Restaurant(String restaurantNaam, String restaurantAdress, int restaurantNumber) {
        this.restaurantName = restaurantNaam;
        this.restaurantAddress = restaurantAdress;
        this.restaurantNumber = restaurantNumber;
        this.tablesArray = new ArrayList<Table>();
        this.bookings = bookings;


    }

    @Override
    public String toString() {
        return this.restaurantName;
    }


//Getters


    public String getRestaurantName() {
        return restaurantName;
    }

    public ArrayList<Table> getTablesArray() {

        return tablesArray;
    }


    //Setter

    public void setBookings(BookingDataProvider bookings) {
        this.bookings = bookings;
    }


// methods

    public boolean addTable(TableType type, int maxSeats, int minSeats, int tableNumber) {
        if (checkTableNumber(tableNumber)) {

            switch (type) {
                case SQUARE_TABLE:
                    this.tablesArray.add(new SquareTable(maxSeats, minSeats, tableNumber));
                    break;
                case ROUND_TABLE:

                    this.tablesArray.add(new RoundTable(maxSeats, minSeats, tableNumber));
                    break;
            }
        }
        return false;


    }


    public void setiAlgorithmStrategy(IAlgorithmStrategy strategy) {
        this.iAlgorithmStrategy = strategy;
    }


    public void deleteTable(Table table1) {
        for (Iterator<Table> itr = tablesArray.iterator(); itr.hasNext(); ) {
            Table table = itr.next();
            if (table.equals(table1)) {
                itr.remove();
            }


        }
    }


    public void doMagic(LocalDate bookingDate) {

        iAlgorithmStrategy.doMagic(bookings.getAllBookings(), tablesArray, bookingDate);

    }


    public boolean checkTableNumber(int nummer) {

        for (int i = 0; i < tablesArray.size(); i++) {
            if (tablesArray.get(i).getTableNr() == nummer) {

                return false;
            }


        }
        return true;
    }

}

