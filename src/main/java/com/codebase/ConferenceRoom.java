package com.codebase;

import java.util.ArrayList;
import java.util.List;

public class ConferenceRoom extends Room {
    private final String name;
    private final List<Guest> guests;
    public ConferenceRoom(String name, int capacity) {
        super(capacity);
        this.name = name;
        this.guests = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<Guest> getGuests() {
        return guests;
    }

    public void checkIn(Guest guest) {
        if (guests.size() < getCapacity()) {
            guests.add(guest);
        } else {
            throw new IllegalStateException("Room is full.");
        }
    }

    public void checkOut(Guest guest) {
        guests.remove(guest);
    }
}

