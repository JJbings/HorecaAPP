package BL.algorithm.helpers;

import BL.booking.Bookable;
import BL.restaurant.table.RoundTable;
import BL.restaurant.table.Table;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SeatingHelperTest {

    @Test
    void convertTable() {
        //Arrange
        ArrayList<Table> tables = new ArrayList<>();
        for (int i = 0; i < 5; i++) tables.add(new RoundTable(5, 1, i));

        //Act
        HashMap<Integer, HashMap<Integer, Bookable>> result;
        result = SeatingHelper.convertTable(tables);
        //assert
        assertEquals(5,result.size() );
        for(int i=0;i<24;i++) assertEquals(null,result.get(0).get(i));
    }

    @Test
    void fillBookTest() {


        //arrange
        HashMap<Integer, Bookable> a = new HashMap<>();
        a = SeatingHelper.fillBooking();
        Set<Integer> b = a.keySet();


        //Act
        Set<Integer> result = Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);


        //assert
        assertEquals(result, b);




    }
    @Test
    void fillBookTest2(){
        //arrange
        HashMap<Integer, Bookable> a = new HashMap<>();
        a = SeatingHelper.fillBooking();

        //act

       //assert
        assertEquals(a.size(),24);
        for(int i=0;i<24;i++) assertEquals(null,a.get(i));
    }
}