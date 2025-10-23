package com.pluralsight;

public class Hotel {
    //field members, backing fields/variables
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    //constructors
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    //getters
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }


    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        boolean isBasicRoom = !isSuite;
        if (isBasicRoom && (getAvailableRooms() >= numberOfRooms)) {
            bookedBasicRooms = bookedBasicRooms + numberOfRooms; //OR bookedBasicRooms += numberOfRooms;
            return true;
        }

        if (isSuite && (getAvailableSuites() >= numberOfSuites)) {
            bookedSuites = bookedSuites + numberOfRooms; //OR bookedSuites += numberOfRooms;
            return true;
        }

        return false;
    }



    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", numberOfSuites=" + numberOfSuites +
                ", numberOfRooms=" + numberOfRooms +
                ", bookedSuites=" + bookedSuites +
                ", bookedBasicRooms=" + bookedBasicRooms +
                '}';
    }
}