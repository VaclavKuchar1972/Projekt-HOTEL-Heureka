import com.projekt.hotel.Booking;
import com.projekt.hotel.BookingManager;
import com.projekt.hotel.Guest;
import com.projekt.hotel.Room;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public static void main(String[] args) {
        // Pomocné proměnné
        int i = 0; int j = 0; int k = 0;
        int helpBookingNumer = 0;
        String hotel1Name = "HEUREKA";

        List<Room> roomsList = new ArrayList<>();
        roomsList.add(new Room(1, 1, true, true, new BigDecimal("1000")));
        roomsList.add(new Room(2, 1, true, true, new BigDecimal("1000")));
        roomsList.add(new Room(3, 3, false, true, new BigDecimal("2400")));

        List<Guest> guestsList = new ArrayList<>();
        guestsList.add(new Guest(false, "", 0,
                "Adéla", "Malíková", LocalDate.of(1993, 3, 13)));
        guestsList.add(new Guest(false, "", 0,
                "Jan", "Dvořáček", LocalDate.of(1995, 5, 5)));
        guestsList.add(new Guest(false, "", 0,
                "Karel", "Dvořák", LocalDate.of(1990, 5, 15)));
        guestsList.add(new Guest(false, "", 0,
                "Karel", "Dvořák", LocalDate.of(1979, 1, 3)));
        guestsList.add(new Guest(true, "ABC Relax", 60192755,
                "", "zatím neznámý", null));
        guestsList.add(new Guest(false, "", 0,
                "Alena", "Krásová", LocalDate.of(1970, 12, 24)));
        guestsList.add(new Guest(true, "CK Doom Day", 38526596,
                "", "zatím neznámý", null));

        List<Booking> bookingsList = new ArrayList<>();
        bookingsList.add(new Booking(roomsList.get(0), guestsList.subList(0, 1),
                LocalDate.of(2021, 7, 19),
                LocalDate.of(2021, 7, 26), false));
        bookingsList.add(new Booking(roomsList.get(2), guestsList.subList(0, 2),
                LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 9, 14), true));
        bookingsList.add(new Booking(roomsList.get(2), guestsList.subList(2, 3),
                LocalDate.of(2023, 6, 1),
                LocalDate.of(2023, 6, 7), true));
        bookingsList.add(new Booking(roomsList.get(1), guestsList.subList(3, 4),
                LocalDate.of(2023, 8, 18),
                LocalDate.of(2023, 8, 21), false));
        j = 6; k = 1;
        for (i = 1; i <= 30; i++) {
            k = k + 1; if (i == 30) {j = 7; k = 1;}
            bookingsList.add(new Booking(roomsList.get(1), guestsList.subList(4, 5),
                    LocalDate.of(2023, 6, i), LocalDate.of(2023, j, k), false));
        }
        for (i = 1; i <= 7; i++) {
            bookingsList.add(new Booking(roomsList.get(0), guestsList.subList(5, 6),
                    LocalDate.of(2023, i + 5, 1),
                    LocalDate.of(2023, i + 5, 6), true));
        }
        for (i = 1; i <= 22; i += 7) {
            bookingsList.add(new Booking(roomsList.get(1), guestsList.subList(4, 5),
                    LocalDate.of(2023, 8, i),
                    LocalDate.of(2023, 8, i + 3), true));
        }
        bookingsList.add(new Booking(roomsList.get(2), guestsList.subList(6, 7),
                LocalDate.of(2023, 12, 24),
                LocalDate.of(2024, 1, 1), false));


        System.out.println();
        System.out.println("SEZNAM POKOJŮ hotelu " + hotel1Name + ":");
        for (Room room : roomsList) {
            System.out.println("         Pokoj číslo " + room.getRoomNumber());
            System.out.println("            Počet lůžek: " + room.getNumberOfBeds());
            System.out.println("                 Balkon: " + room.getTheBalconyText());
            System.out.println("         Výhled na moře: " + room.getSeaViewText());
            System.out.println("      Cena za jednu noc: " + room.getPricePerNight() + ",- Kč");
        }

        System.out.println();
        System.out.println("SEZNAM HOSTŮ hotelu " + hotel1Name + ":");
        for (Guest guest : guestsList) {
            if (guest.getCommercialGuest() == false) {
                System.out.println("   " + guest.getFullName());
                System.out.println("      Datum narození: " + guest.getDateBirth());
            } else {
                System.out.println("   " + guest.getCompanyName());
                System.out.println("                 IČO: " + guest.getCompanyVatNumber());
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("SEZNAM REZERVACÍ hotelu " + hotel1Name + ":");
        helpBookingNumer = 0;
        for (Booking booking : bookingsList) {
            System.out.println();
            helpBookingNumer = helpBookingNumer + 1;
            System.out.println("        Čislo rezervace: " + helpBookingNumer);
            for (Guest guest : booking.getGuests()) {
                if (guest.getCommercialGuest() == false) {
                    System.out.println("                   Host: " + guest.getFullName());
                    System.out.println("                         " + "*" + guest.getDateBirth());
                } else {
                    System.out.println("                  FIRMA: " + guest.getCompanyName());
                    System.out.println("                   Host: " + guest.getFullName());
                    if (guest.getLastName() != "zatím neznámý") {
                        System.out.println("                         " + "*" + guest.getDateBirth());
                    }
                }
            }
            System.out.println("              V termínu: " + booking.getBookingRange());
            System.out.println("             Počet nocí: " + booking.getDaysNumber());
            System.out.println("             Typ pobytu: " + booking.getWorkStay());
            System.out.println("            Pokoj číslo: " + booking.getRoom().getRoomNumber());
            System.out.println("            Počet lůžek: " + booking.getRoom().getNumberOfBeds());
            System.out.println("                 Balkon: " + booking.getRoom().getTheBalconyText());
            System.out.println("         Výhled na moře: " + booking.getRoom().getSeaViewText());
            System.out.println("      Cena za jednu noc: " + booking.getRoom().getPricePerNight() + ",- Kč");
            System.out.println("CELKOVÁ CENA Objednávky: " + booking.getTotalPrice() + ",- Kč");
        }

        BookingManager bookingManager = new BookingManager();

        // Provázání bookingsList s bookingListBM v BookingManageru. Vypadá to ale, že mám zbytečně nalitý dva Listy...
        for (Booking booking : bookingsList) {bookingManager.addBooking(booking);}

        List<String> allBookingsInOneLine = bookingManager.getAllBookingsInOneLine();
        List<String> first8BookingsInOneLine = bookingManager.getFirst8BookingsInOneLine();

        System.out.println();
        System.out.println();
        System.out.println("SEZNAM REZERVACÍ hotelu " + hotel1Name + " tak jak ho chce Martin:");
        for (String bookingsInOneLine : allBookingsInOneLine) {System.out.println(bookingsInOneLine);}

        System.out.println();
        System.out.println("STATISTIKA hotelu " + hotel1Name + ":");
        System.out.println("               Celkový počet rezervací: " + bookingManager.getNumberOfBookings());
        System.out.println("   Průměrný počet hostů na 1 rezervaci: " + bookingManager.getAverageNumberGuests());
        System.out.println("    Celkový počet pracovních rezervací: " + bookingManager.getNumberOfWorkingBookings());
        System.out.println("   Celkový počet rekreačních rezervací: " + bookingManager.getNumberOfRecreatinoBookings());

        System.out.println();
        System.out.println("       Prvních 8 rekreačních rezervací:");
        for (String first8InOneLine : first8BookingsInOneLine) {System.out.println(first8InOneLine);}

    }

}