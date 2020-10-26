package DataAccess;

import BL.booking.Bookable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataWriter {

    public boolean writeToData(ArrayList<Bookable> booking)  throws IOException {

        FileWriter writer = new FileWriter("text.txt");

        for (int i = 0; i < booking.size(); i++) {
            writer.write(booking.get(i).getBookedDate() + " ");
            writer.write(booking.get(i).getBookedTime() + " ");
            writer.write(booking.get(i).getBookedName() + " ");
            writer.write(booking.get(i).getVisitors() + "\n");
        }


        writer.close();
        return true;
    }
}
