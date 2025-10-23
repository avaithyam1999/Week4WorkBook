package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;
    private boolean available;

    public Room() {
        this.numberOfBeds = 1;
        this.price = 109.99;
        this.occupied = false;
        this.dirty = false;
        this.available = true;
    }
    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty, boolean available) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
        this.available = available;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return available;
    }
    public void checkIn() {
        if (isAvailable() && !isDirty()) {
            occupied = true;
            available = false;
            dirty = true;
            System.out.println("Guest Checked in");
        } else {
            System.out.println("Not happening pal");
        }
    }

    public void checkOut() {
        if (occupied) {
            occupied = false;
            cleanRoom();
            System.out.println("Room has been cleaned");
            available = true;
            System.out.println("Room is now available");
        }
    }
    public void cleanRoom() {
        if (dirty && isAvailable()) {
            dirty = false;
        }
    }
}
