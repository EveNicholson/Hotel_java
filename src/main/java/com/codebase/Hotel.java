package com.codebase;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    public Hotel() {
        List<Bedroom> bedrooms = new ArrayList<>();
        List<ConferenceRoom> conferenceRooms = new ArrayList<>();
    }

    public void checkInGuestToRoom(Guest guest, Room room) {
        room.checkIn(guest);
    }
    public void checkOutGuestFromRoom(Guest guest, Room room) {
        room.checkOut(guest);
    }

}
