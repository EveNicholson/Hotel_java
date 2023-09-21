import static org.junit.jupiter.api.Assertions.*;

import com.codebase.ConferenceRoom;
import com.codebase.Guest;
import org.junit.jupiter.api.Test;

public class ConferenceRoomTest {
    @Test
    public void testConferenceRoomInitialization() {
        String roomName = "Meeting Room A";
        int capacity = 20;
        ConferenceRoom conferenceRoom = new ConferenceRoom(roomName, capacity);

        assertEquals(roomName, conferenceRoom.getName());
        assertEquals(capacity, conferenceRoom.getCapacity());
        assertTrue(conferenceRoom.getGuests().isEmpty());
    }

    @Test
    public void testCheckInGuest() {
        ConferenceRoom conferenceRoom = new ConferenceRoom("Conference Room 1", 30);
        Guest guest1 = new Guest("Alice");
        Guest guest2 = new Guest("Bob");

        conferenceRoom.checkIn(guest1);
        assertEquals(1, conferenceRoom.getGuests().size());
        assertTrue(conferenceRoom.getGuests().contains(guest1));

        conferenceRoom.checkIn(guest2);
        assertEquals(2, conferenceRoom.getGuests().size());
        assertTrue(conferenceRoom.getGuests().contains(guest2));
    }

    @Test
    public void testCheckInGuestRoomFull() {
        ConferenceRoom conferenceRoom = new ConferenceRoom("Conference Room 2", 10);
        Guest guest1 = new Guest("Carol");
        Guest guest2 = new Guest("David");

        // Fill up the conference room
        for (int i = 0; i < 10; i++) {
            conferenceRoom.checkIn(new Guest("Guest" + i));
        }

        // Try to check in another guest when the room is already full
        assertThrows(IllegalStateException.class, () -> conferenceRoom.checkIn(guest1));
    }

    @Test
    public void testCheckOutGuest() {
        ConferenceRoom conferenceRoom = new ConferenceRoom("Conference Room 3", 15);
        Guest guest1 = new Guest("Frank");
        Guest guest2 = new Guest("Grace");

        conferenceRoom.checkIn(guest1);
        conferenceRoom.checkIn(guest2);

        conferenceRoom.checkOut(guest1);
        assertEquals(1, conferenceRoom.getGuests().size());
        assertFalse(conferenceRoom.getGuests().contains(guest1));
        assertTrue(conferenceRoom.getGuests().contains(guest2));

        conferenceRoom.checkOut(guest2);
        assertTrue(conferenceRoom.getGuests().isEmpty());
    }
}
