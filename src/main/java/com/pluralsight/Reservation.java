package com.pluralsight;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private double price;
    private boolean isWeekend;
    private double reservationTotal;

    public Reservation(String roomType, int numberOfNights, double price, boolean isWeekend, double reservationTotal) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.price = price;
        this.isWeekend = isWeekend;
        this.reservationTotal = reservationTotal;
    }

    public boolean isRoomType() {
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
        return price;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public double getReservationTotal() {
        if (isWeekend) {
            return (price * numberOfNights) * 1.25;
        } else {
            return price * numberOfNights;
        }
    }
}
