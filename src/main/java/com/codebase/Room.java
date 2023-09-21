package com.codebase;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private int capacity;
    private List<Guest> guests;

    public Room(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void checkIn(Guest guest) {
        if (guests.size() < capacity) {
            guests.add(guest);
        } else {
            throw new IllegalStateException("Room is full.");
        }
    }

    public void checkOut(Guest guest) {
        guests.remove(guest);
    }
}

