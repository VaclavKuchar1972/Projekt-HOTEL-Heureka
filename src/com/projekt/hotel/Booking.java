package com.projekt.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Booking {
    private Room room;
    private List<Guest> guests;
    private LocalDate bookedFrom;
    private LocalDate bookedUntil;
    private boolean workStay;

    public Booking(Room room, List<Guest> guests, LocalDate bookedFrom, LocalDate bookedUntil, boolean workStay) {
        this.room = room;
        this.guests = guests;
        this.bookedFrom = bookedFrom;
        this.bookedUntil = bookedUntil;
        this.workStay = workStay;
    }
    public Room getRoom() {return room;}
    public List<Guest> getGuests() {return guests;}
    public LocalDate getBookedFrom() {return bookedFrom;}
    public LocalDate getBookedUntil() {return bookedUntil;}
    public boolean getIsWorkStay() {return workStay;}
    public int getDaysNumber() {return (int) (bookedUntil.toEpochDay() - bookedFrom.toEpochDay());}
    public String getBookingRange() {
        return "od " + bookedFrom.format(DateTimeFormatter.ofPattern("d.M.yyyy")) + " do "
                + bookedUntil.format(DateTimeFormatter.ofPattern("d.M.yyyy"));
    }
    public String getWorkStay() {if (workStay == true) {return "PRACOVNÍ";} else {return "REKREAČNÍ";}}
    public BigDecimal getTotalPrice() {return room.getPricePerNight().multiply(new BigDecimal(getDaysNumber()));}

}
