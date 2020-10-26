package DataAccess;

import BL.booking.Bookable;
import BL.booking.Booking;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {
    public ArrayList<Bookable> readFromData() throws IOException {
        ArrayList<Bookable> bookings = new ArrayList<>();
        File inputFile = new File("text.txt");
        FileReader reader = new FileReader("text.txt");
        Scanner sc = new Scanner(inputFile);

        while (sc.hasNext()) {

            bookings.add(new Booking(LocalDate.parse(sc.next()), LocalTime.parse(sc.next()), sc.next(), Integer.parseInt(sc.next())));




        }
        reader.close();
        return bookings;
    }
}
