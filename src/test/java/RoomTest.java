import static org.junit.jupiter.api.Assertions.*;

import com.codebase.Guest;
import com.codebase.Room;
import org.junit.jupiter.api.Test;

public class RoomTest {
    @Test
    public void testCheckInGuest() {
        int roomCapacity = 3;
        Room room = new TestRoom(roomCapacity);
        Guest guest1 = new Guest("Alice");
        Guest guest2 = new Guest("Bob");

        room.checkIn(guest1);
        assertEquals(1, room.getGuests().size());
        assertTrue(room.getGuests().contains(guest1));

        room.checkIn(guest2);
        assertEquals(2, room.getGuests().size());
        assertTrue(room.getGuests().contains(guest2));
    }

    @Test
    public void testCheckInGuestRoomFull() {
        int roomCapacity = 2;
        Room room = new TestRoom(roomCapacity);
        Guest guest1 = new Guest("Carol");
        Guest guest2 = new Guest("David");

        room.checkIn(guest1);
        room.checkIn(guest2);


        assertThrows(IllegalStateException.class, () -> room.checkIn(new Guest("Eve")));
    }

    @Test
    public void testCheckOutGuest() {
        int roomCapacity = 3;
        Room room = new TestRoom(roomCapacity);
        Guest guest1 = new Guest("Frank");
        Guest guest2 = new Guest("Grace");

        room.checkIn(guest1);
        room.checkIn(guest2);

        room.checkOut(guest1);
        assertEquals(1, room.getGuests().size());
        assertFalse(room.getGuests().contains(guest1));
        assertTrue(room.getGuests().contains(guest2));

        room.checkOut(guest2);
        assertTrue(room.getGuests().isEmpty());
    }


    private class TestRoom extends Room {
        TestRoom(int capacity) {
            super(capacity);
        }
    }
}

