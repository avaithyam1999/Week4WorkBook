package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @org.junit.jupiter.api.Test
    void testGetReservationTotal_forKingRoom_forOneNight_NotWeekend() {
        Reservation reservation = new Reservation("King", 1, false);
        assertEquals(136, reservation.getReservationTotal());
    }
    @Test
    void testGetReservationTotal_forKingRoom_forOneNight_inWeekend() {
        Reservation reservation = new Reservation("King", 1, true);
        assertEquals(136 * 1.25, reservation.getReservationTotal());
    }
    @Test
    void testGetReservationTotal_forKingRoom_forMultipleNights_inWeekend() {
        Reservation reservation = new Reservation("King", 5, true);
        assertEquals((136*5) * 1.25, reservation.getReservationTotal());
    }
}