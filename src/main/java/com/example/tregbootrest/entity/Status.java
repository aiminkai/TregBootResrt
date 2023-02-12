package com.example.tregbootrest.entity;


public enum Status {
    RESERVED("Reserved"),
    SOLD("Sold"),
    AVAILABLE("Available");

    private final String seatSlotStatus;

    Status(String seatSlotStatus) {
        this.seatSlotStatus = seatSlotStatus;
    }

    public String getSeatSlotStatus() {
        return seatSlotStatus;
    }


}
