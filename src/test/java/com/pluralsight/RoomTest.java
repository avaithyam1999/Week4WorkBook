package com.pluralsight;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RoomTest {
    @Test
    public void checkIn_while_room_available() {
        Room room = new Room();
        room.checkIn();
        room.checkOut();
        room.cleanRoom();
        assertTrue(room.isAvailable());
    }

    public void checkOut_while_room_not_available() {
        Room room = new Room();
        room.checkOut();
    }
}
