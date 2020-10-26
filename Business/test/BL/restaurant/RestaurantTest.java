package BL.restaurant;

import BL.restaurant.table.Table;
import BL.restaurant.table.TableType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RestaurantTest {

    @Test
    void getTablesArray() {

        //Arrange
        Restaurant restaurant = new Restaurant("Mcdonalds", "Markt 4", 1);
        ArrayList<Table> tables = new ArrayList<>();

        //Act

        ArrayList<Table> result = restaurant.getTablesArray();

        //Assert
        assertEquals(tables, result);
    }

    @Test
    void addTable() {

        //Arrange
        Restaurant restaurant = new Restaurant("Mcdonalds", "Markt 4", 1);

        //Act
        restaurant.addTable(TableType.ROUND_TABLE, 4, 1, 1);

        //Assert
        assertEquals(1, restaurant.getTablesArray().size());
        assertEquals(1, restaurant.getTablesArray().get(0).getTableNr());

    }

    @Test
    void doMagic() {

        //Arrange

        //Act

        //Assert
    }

    @Test
    void deleteTable() {
        //Arrange
        Restaurant restaurant = new Restaurant("Mcdonalds", "Markt 4", 1);
        restaurant.addTable(TableType.ROUND_TABLE, 4, 1, 1);
        //Act
        restaurant.deleteTable(restaurant.getTablesArray().get(0));
        //Assert
        assertTrue(restaurant.getTablesArray().isEmpty());

    }

    @Test
    void setiAlgorithm() {

        //Arrange

        //Act

        //Assert
    }
}