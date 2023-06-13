package com.projekt.hotel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private int helpBookingNumberBM = 0;
    private double helpAverageBM = 0;
    private DecimalFormat decimalFormatBM = new DecimalFormat("#,##0.00");
    private List<Booking> bookingListBM;

    public BookingManager() {
        this.bookingListBM = new ArrayList<>();
    }

    public List<Booking> getBookingListBM() {
        return bookingListBM;
    }

    public void addBookingBM(Booking booking) {
        bookingListBM.add(booking);
    }

    public int getNumberOfBookingsBM() {
        return bookingListBM.size();
    }

    public String getAverageNumberGuestsBM() {
        helpBookingNumberBM = 0;
        for (Booking booking : bookingListBM) {
            helpBookingNumberBM += booking.getGuests().size();
        }
        helpAverageBM = (double) helpBookingNumberBM / bookingListBM.size();
        return decimalFormatBM.format(helpAverageBM).replace(".", ",");
    }

    public int getNumberOfWorkingBookingsBM() {
        helpBookingNumberBM = 0;
        for (Booking booking : bookingListBM) {
            if (booking.getIsWorkStay()) {
                helpBookingNumberBM++;
            }
        }
        return helpBookingNumberBM;
    }

    public int getNumberOfRecreationBookingsBM() {
        helpBookingNumberBM = 0;
        for (Booking booking : bookingListBM) {
            if (!booking.getIsWorkStay()) {
                helpBookingNumberBM++;
            }
        }
        return helpBookingNumberBM;
    }

    public int getNumberOfOneDayBookingsBM() {
        helpBookingNumberBM = 0;
        for (Booking booking : bookingListBM) {
            if (booking.getDaysNumber() == 1) {
                helpBookingNumberBM++;
            }
        }
        return helpBookingNumberBM;
    }

    public int getNumberOfTwoDayBookingsBM() {
        helpBookingNumberBM = 0;
        for (Booking booking : bookingListBM) {
            if (booking.getDaysNumber() == 2) {
                helpBookingNumberBM++;
            }
        }
        return helpBookingNumberBM;
    }

    public int getNumberOfMoreThanTwoDayBookingsBM() {
        helpBookingNumberBM = 0;
        for (Booking booking : bookingListBM) {
            if (booking.getDaysNumber() > 2) {
                helpBookingNumberBM++;
            }
        }
        return helpBookingNumberBM;
    }

    private String getBookingInfoBM(Booking booking) {
        boolean commercialGuestBM = booking.getGuests().get(0).getCommercialGuest();
        String companyNameBM = commercialGuestBM ? "firma, " + booking.getGuests().get(0).getCompanyNameAndCompanyVatNumber() + ", " : "";
        List<String> guestNamesBM = new ArrayList<>();
        for (Guest guest : booking.getGuests()) {
            guestNamesBM.add(guest.getFullNameAndDateBirth());
        }
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

        return "   čr: " + helpBookingNumberBM + ", " + companyNameBM + "host, " + guestNameBM + ", termín: " +
                bookingRangeBM + ", nocí: " + daysNumberBM + ", pobyt: " + workStayBM + ", pokoj: " +
                roomNumberBM + ", lůžka: " + numberOfBedsBM + ", balkón: " + balconyBM + ", výhled na more: " +
                seaViewBM + ", cena/noc: " + pricePerNightBM + ",- Kč, cena celkem: " + totalPriceBM + ",- Kč";
    }

    public List<String> getAllBookingsInOneLineBM() {
        List<String> bookingsBM = new ArrayList<>();
        helpBookingNumberBM = 0;
        for (Booking booking : bookingListBM) {
            helpBookingNumberBM++;
            String bookingInfo = getBookingInfoBM(booking);
            bookingsBM.add(bookingInfo);
        }
        return bookingsBM;
    }

    public List<String> getFirst8BookingsInOneLineBM() {
        List<String> bookingsFirst8BM = new ArrayList<>();
        helpBookingNumberBM = 0;
        for (Booking booking : bookingListBM) {
            if (!booking.getIsWorkStay()) {
                helpBookingNumberBM++;
                String bookingInfo = getBookingInfoBM(booking);
                bookingsFirst8BM.add("          " + helpBookingNumberBM + ". " + bookingInfo);
            }
            if (helpBookingNumberBM == 8) {
                break;
            }
        }
        return bookingsFirst8BM;
    }

}