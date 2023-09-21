import static org.junit.jupiter.api.Assertions.*;

import com.codebase.Bedroom;
import com.codebase.Guest;
import com.codebase.RoomType;
import org.junit.jupiter.api.Test;

public class BedroomTest {
    @Test
    public void testBedroomInitialization() {
        RoomType roomType = RoomType.SINGLE;
        int roomNumber = 101;
        Bedroom bedroom = new Bedroom(roomNumber, roomType);

        assertEquals(roomNumber, bedroom.getRoomNumber());
        assertEquals(roomType, bedroom.getRoomType());
        assertEquals(roomType.getCapacity(), bedroom.getCapacity());
        assertTrue(bedroom.getGuests().isEmpty());
    }

    @Test
    public void testCheckInGuest() {
        Bedroom bedroom = new Bedroom(102, RoomType.DOUBLE);
        Guest guest1 = new Guest("Alice");
        Guest guest2 = new Guest("Bob");

        bedroom.checkIn(guest1);
        assertEquals(1, bedroom.getGuests().size());
        assertTrue(bedroom.getGuests().contains(guest1));

        bedroom.checkIn(guest2);
        assertEquals(2, bedroom.getGuests().size());
        assertTrue(bedroom.getGuests().contains(guest2));
    }

    @Test
    public void testCheckInGuestRoomFull() {
        Bedroom bedroom = new Bedroom(103, RoomType.SINGLE);
        Guest guest1 = new Guest("Carol");
        bedroom.checkIn(guest1);
        assertThrows(IllegalStateException.class, () -> bedroom.checkIn(new Guest("Eve")));
    }

    @Test
    public void testCheckOutGuest() {
        Bedroom bedroom = new Bedroom(104, RoomType.DOUBLE);
        Guest guest1 = new Guest("Frank");
        Guest guest2 = new Guest("Grace");

        bedroom.checkIn(guest1);
        bedroom.checkIn(guest2);

        bedroom.checkOut(guest1);
        assertEquals(1, bedroom.getGuests().size());
        assertFalse(bedroom.getGuests().contains(guest1));
        assertTrue(bedroom.getGuests().contains(guest2));

        bedroom.checkOut(guest2);
        assertTrue(bedroom.getGuests().isEmpty());
    }
}
