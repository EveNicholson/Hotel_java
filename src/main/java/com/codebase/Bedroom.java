package com.codebase;

public class Bedroom extends Room {
    private int roomNumber;
    private RoomType roomType;

    public Bedroom(int roomNumber, RoomType roomType) {
        super(roomType.getCapacity());
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}

