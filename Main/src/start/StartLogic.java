package start;

import BL.dataProviders.Interface.BookingDataProvider;
import BL.restaurant.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StartLogic {
    User user;

    public StartLogic() {

    }

    public User makeUser() {
        user = new User("joco", "joco");

        return user;

    }


    public User startUser(BookingDataProvider bookingDataProvider) {

        ObjectInputStream oi = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("User.ser");
            oi = new ObjectInputStream(fi);
            user = (User) oi.readObject();

            oi.close();
        } catch (FileNotFoundException e) {
            user = makeUser();

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }


        return user;

    }


}
