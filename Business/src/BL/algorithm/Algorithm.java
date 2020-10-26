package BL.algorithm;


/*public class Algorithm {
    // in het kort met behulp van een Array van Tafels en Bookingen kunnen deze bookingen worden ingedeeld naar de beschikbare tafels.


    private HashMap<Integer, Boolean> boolPerBox;//een werkdag is verdeeld in tijdvakken van 15m de tijdvakken zijn wel of niet bezet
    private HashMap<Integer, HashMap<Integer, Boolean>> boolPerBoxPerTable;//tijdvakken gelinkt aan tafels, iedere tafel heeft zijn tijdvakken
    private HashMap<Integer, HashMap<Integer, Booking>> bookPerBoxPerTable;//tijdvakken gelinkt aan tafels waarbij je kunt aangeven welke BOOKING erbij hoort
    private HashMap<Table, TreeMap<LocalTime, Bookable>> tablesAndBookings;
    private int conditions;
    private BookingDataProvider bookingdData;

    // constructor
    public Algorithm(BookingDataProvider bookingdData) {
        this.boolPerBox = new HashMap<>(fillDayBool());
        this.boolPerBoxPerTable = new HashMap<>();
        this.bookPerBoxPerTable = new HashMap<>();
        this.tablesAndBookings = new HashMap<>();
        this.bookingdData = bookingdData;


    }


    public HashMap<Integer, Boolean> fillDayBool() {  // fill the day with boxes/ vult de dag met tijdvakken in dit geval 24 van 16:00 tot 21:45
        HashMap<Integer, Boolean> a = new HashMap<>();
        for (int i = 0; i < 24; i++) {
            a.put(i + 1, true);
        }

        return a;
    }

    public void setAvail(int start, int avg, int table, Booking booking) {               // Set availability to false/ zet de beschikbaarheid van een tafel op bezet


        for (int i = start; i < (start + avg); i++) {
            boolPerBoxPerTable.get(table).put(i, false);
            bookPerBoxPerTable.get(table).put(i, booking);
        }
    }


    //new method
    public boolean checkTime(Bookable booking, LocalTime startTime, LocalTime endTime) {
        if (booking.getBookedTime().isAfter(startTime) && booking.getBookedTime().isBefore(endTime)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkMinSeat(Bookable booking, Table table) {
        if (booking.getVisitors() <= table.getMinSeats()) {
            return false;
        } else {
            return true;
        }

    }

    public boolean checkMaxSeat(Bookable booking, Table table) {
        if (booking.getVisitors() >= table.getMaxSeats()) {
            return false;
        } else {
            return true;
        }

    }


    public void checkFreeTable(Bookable booking, HashMap<Table, HashMap<Integer, Bookable>> tablesAndBookings) {

        for (int i = 0; i < tablesAndBookings.size(); i++) {
            switch (conditions) {
                //case 1:checkMinSeat(booking, tablesAndBookings);
                case 2:
                case 3:

            }

            for (int ii = 0; ii < tablesAndBookings.get(i).size(); ii++) {

            }

        }
    }

    // old methods
    public ArrayList<Integer> checkAv(int start, int avg, ArrayList<Table> tables, Booking booking, int condition) {                              // check free boxes

        int check = 0;
        int total = start + avg;
        ArrayList<Integer> usedTables = new ArrayList<Integer>();


        if (start > 24)
            return usedTables;                                               // if booking is after 21:45 return 0
        // check if booking start +avg exceeds 21:45
        for (int ii = 0; ii < this.boolPerBoxPerTable.size(); ii++) {                // iterate over tables

            if (booking.getVisitors() > tables.get(ii).getMaxSeats()) continue; // smaller than max seats
            if (condition == 1 && booking.getVisitors() < tables.get(ii).getMinSeats())
                continue; // more than min seats
            if (condition == 2 && booking.getVisitors() != tables.get(ii).getMaxSeats())
                continue; // exactly max seats


            for (int i = start; i <= 24; i++) {
                if (this.boolPerBoxPerTable.get(ii + 1).get(i) == false) {
                    check = 0;
                    break;
                } else {
                    check++;
                }
                if (total > 24 && start == 24) {
                    usedTables.add(ii + 1);
                    check = 0;
                    break;
                }
                if (check == avg) {
                    usedTables.add(ii + 1);
                    check = 0;
                }
            }


        }


        return usedTables;
    }


    public void fillBool(ArrayList<Table> array) {                    //fill an map according to tables array with numbers
        for (int i = 0; i < array.size(); i++) {
            this.boolPerBoxPerTable.put(i + 1, new HashMap<>(fillDayBool()));
        }
    }

    public void fillBook(ArrayList<Table> array) {         //fill the day with null values for Book
        for (int i = 0; i < array.size(); i++) {
            this.bookPerBoxPerTable.put(i + 1, new HashMap<Integer, Booking>(fillDayBook()));
        }
    }

    public HashMap<Integer, Booking> fillDayBook() {
        HashMap<Integer, Booking> a = new HashMap<>();
        for (int i = 0; i < 24; i++) {
            a.put(i + 1, null);
        }

        return a;
    }
}*/


