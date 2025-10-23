package com.pluralsight;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public double getPrice() {
        switch (roomType.toLowerCase()) {
            case "king" -> {
                return 136;
            }
            case "double" -> {
                return 124;
            }
            default -> throw new IllegalStateException("Invalid Room Type: " + roomType.toLowerCase());
        }
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public double getReservationTotal() {
        double total = getPrice() * numberOfNights;
        if (isWeekend) {
            return total * 1.25;
        } else {
            return getPrice() * numberOfNights;
        }
    }

}
