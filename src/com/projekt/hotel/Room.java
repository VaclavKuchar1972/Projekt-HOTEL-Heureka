package com.projekt.hotel;

import java.math.BigDecimal;

public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean theBalcony;
    private boolean seaView;
    private BigDecimal pricePerNight;

    public Room(int roomNumber, int numberOfBeds, boolean theBalcony, boolean seaView, BigDecimal pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.theBalcony = theBalcony;
        this.seaView = seaView;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {return roomNumber;}
    public int getNumberOfBeds() {return numberOfBeds;}
    public String getTheBalconyText() {if (theBalcony == true) {return "ANO";} else {return "NE";}}
    public String getSeaViewText() {if (seaView == true) {return "ANO";} else {return "NE";}}
    public BigDecimal getPricePerNight() {return pricePerNight;}

}