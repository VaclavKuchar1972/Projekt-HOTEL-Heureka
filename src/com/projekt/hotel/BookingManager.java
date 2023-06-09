package com.projekt.hotel;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class BookingManager {
    // Pomocné proměnné
    //  int i = 0; int j = 0; int k = 0;
    int helpBookingNumerBM = 0; double helpAverageBM = 0;

    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    private List<Booking> bookingListBM;

    public BookingManager() {this.bookingListBM = new ArrayList<>();}
    public List<Booking> getBookingListBM() {return bookingListBM;}

    public void addBooking(Booking booking) {
        bookingListBM.add(booking);}

    public int getNumberOfBookings() {return bookingListBM.size();}

    public String getAverageNumberGuests() {
        helpBookingNumerBM = 0;
        for (Booking booking : bookingListBM) {helpBookingNumerBM = helpBookingNumerBM + booking.getGuests().size();}
        helpAverageBM = (double) helpBookingNumerBM / bookingListBM.size();
        return decimalFormat.format(helpAverageBM).replace(".", ",");
    }

    public int getNumberOfWorkingBookings() {
        helpBookingNumerBM = 0;
        for (Booking booking : bookingListBM) {
            if (booking.getIsWorkStay() == true) {helpBookingNumerBM = helpBookingNumerBM + 1;}
        }
        return helpBookingNumerBM;
    }

    public int getNumberOfRecreatinoBookings() {
        helpBookingNumerBM = 0;
        for (Booking booking : bookingListBM) {
            if (booking.getIsWorkStay() == false) {helpBookingNumerBM = helpBookingNumerBM + 1;}
        }
        return helpBookingNumerBM;
    }

    public void BookingToOneLine () {

        this.bookingListBM = bookingListBM;
    }

    public List<String> getAllBookingsInOneLine() {

        List<String> bookingsBM = new ArrayList<>();

        helpBookingNumerBM = 0;
        for (Booking booking : bookingListBM) {
            helpBookingNumerBM = helpBookingNumerBM + 1;
            String bookingNumerBM = Integer.toString(helpBookingNumerBM);;


            // Opakující se kód 1/2
            boolean commercialGuestBM = booking.getGuests().get(0).getCommercialGuest();
            String companyNameBM;
            if (commercialGuestBM == true) {
                companyNameBM = "firma, " + booking.getGuests().get(0).getCompanyNameAndCompanyVatNumber() + ", ";
            }
            else {companyNameBM = "";}
            List<String> guestNamesBM = new ArrayList<>();
            for (Guest guest : booking.getGuests()) {guestNamesBM.add(guest.getFullNameAndDateBirth());}

            // Metoda String."join()" mi spojuje Stringy v Listu guestNameBM a přidává String Oddělovač - to je pro mě
            String guestNameBM = String.join(", ", guestNamesBM);

            String bookingRangeBM = booking.getBookingRange();
            int daysNumberBM = booking.getDaysNumber();
            String workStayBM = booking.getWorkStay();
            int roomNumberBM = booking.getRoom().getRoomNumber();
            int numberOfBedsBM = booking.getRoom().getNumberOfBeds();
            String balconyBM = booking.getRoom().getTheBalconyText();
            String seaViewBM = booking.getRoom().getSeaViewText();
            String pricePerNightBM = String.valueOf(booking.getRoom().getPricePerNight());
            String totalPriceBM = String.valueOf(booking.getTotalPrice());
            // KONEC - Opakující se kód 1/2


            String bookingInfoBM = "   čr: " + bookingNumerBM + ", "+ companyNameBM + "host, " + guestNameBM + ", termín: "
                    + bookingRangeBM + ", nocí: " + daysNumberBM + ", pobyt: " +  workStayBM + ", pokoj: "
                    + roomNumberBM + ", lůžka: " + numberOfBedsBM + ", balkón: " + balconyBM + ", výhled na more: "
                    + seaViewBM + ", cena/noc: " + pricePerNightBM + ",- Kč, cena celkem: " + totalPriceBM + ",- Kč";

            bookingsBM.add(bookingInfoBM);
        }
        return bookingsBM;
    }

    public List<String> getFirst8BookingsInOneLine() {

        List<String> bookingsFirst8BM = new ArrayList<>();


        // Opakující se kód 2/2
        helpBookingNumerBM = 0;
        for (Booking booking : bookingListBM) {
            if(booking.getIsWorkStay() == false) {
                helpBookingNumerBM = helpBookingNumerBM + 1;
                boolean commercialGuestBM = booking.getGuests().get(0).getCommercialGuest();
                String companyNameBM;
                if (commercialGuestBM == true) {
                    companyNameBM = "firma, " + booking.getGuests().get(0).getCompanyNameAndCompanyVatNumber() + ", ";
                }
                else {companyNameBM = "";}
                List<String> guestNamesBM = new ArrayList<>();
                for (Guest guest : booking.getGuests()) {guestNamesBM.add(guest.getFullNameAndDateBirth());}

                // Metoda String."join()" mi spojuje Stringy v Listu guestNameBM a přidává String Oddělovač - to je pro mě
                String guestNameBM = String.join(", ", guestNamesBM);

                String bookingRangeBM = booking.getBookingRange();
                int daysNumberBM = booking.getDaysNumber();
                String workStayBM = booking.getWorkStay();
                int roomNumberBM = booking.getRoom().getRoomNumber();
                int numberOfBedsBM = booking.getRoom().getNumberOfBeds();
                String balconyBM = booking.getRoom().getTheBalconyText();
                String seaViewBM = booking.getRoom().getSeaViewText();
                String pricePerNightBM = String.valueOf(booking.getRoom().getPricePerNight());
                String totalPriceBM = String.valueOf(booking.getTotalPrice());
                // KONEC - Opakující se kód 2/2


                String bookingInfoBM = "          " + helpBookingNumerBM + ". rr: " + companyNameBM + "host, " + guestNameBM + ", termín: "
                        + bookingRangeBM + ", nocí: " + daysNumberBM + ", pobyt: " +  workStayBM + ", pokoj: "
                        + roomNumberBM + ", lůžka: " + numberOfBedsBM + ", balkón: " + balconyBM + ", výhled na more: "
                        + seaViewBM + ", cena/noc: " + pricePerNightBM + ",- Kč, cena celkem: " + totalPriceBM + ",- Kč";

                bookingsFirst8BM.add(bookingInfoBM);
            }
            if (helpBookingNumerBM == 8) {break;}
        }
        return bookingsFirst8BM;
    }

}