package com.pluralsight;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class HotelTest {
    @Test
    public void bookRoom_whenRoomsAvailable() {
        //arrange: create object
        Hotel grandBudapestHotel = new Hotel("Grand Budapest Hotel", 15, 100);
        //act: call method
        boolean result = grandBudapestHotel.bookRoom(5, true);
        //assert: verify changes
        assertTrue(result);
    }
    @Test
    public void bookRoom_when_Rooms_not_Available() {
        Hotel myhotel = new Hotel("Casa Blanca", 20, 100);
        boolean result = myhotel.bookRoom(1000, false);
        assertTrue(result);
    }
    @Test
    public void bookRoom_when_Suites_not_Available() {
        Hotel myhotel = new Hotel("Casa Blanca", 20, 100);
        boolean result = myhotel.bookRoom(1000, true);
        assertFalse(result);
    }
}
