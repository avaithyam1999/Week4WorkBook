package com.pluralsight;

public class HotelOperations {
    public static void main(String[] args) {
        Reservation reservation1 = new Reservation("king", 3, true);
        System.out.println(reservation1.getReservationTotal());
    }
}
