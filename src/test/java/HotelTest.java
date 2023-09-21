import static org.junit.jupiter.api.Assertions.*;

import com.codebase.*;
import org.junit.jupiter.api.Test;

public class HotelTest {
    @Test
    public void testCheckInGuestToBedroom() {
        Hotel hotel = new Hotel();
        Bedroom bedroom = new Bedroom(101, RoomType.SINGLE);
        Guest guest = new Guest("Alice");

        hotel.checkInGuestToRoom(guest, bedroom);
        assertTrue(bedroom.getGuests().contains(guest));
    }

    @Test
    public void testCheckOutGuestFromBedroom() {
        Hotel hotel = new Hotel();
        Bedroom bedroom = new Bedroom(102, RoomType.DOUBLE);
        Guest guest = new Guest("Bob");

        hotel.checkOutGuestFromRoom(guest, bedroom);
        assertFalse(bedroom.getGuests().contains(guest));
    }


    @Test
    public void testCheckInGuestToConferenceRoom() {
        Hotel hotel = new Hotel();
        ConferenceRoom conferenceRoom = new ConferenceRoom("Meeting Room A", 20);
        Guest guest = new Guest("Carol");

        hotel.checkInGuestToRoom(guest, conferenceRoom);
        assertTrue(conferenceRoom.getGuests().contains(guest));
    }



    @Test
    public void testCheckOutGuestFromConferenceRoom() {
        Hotel hotel = new Hotel();
        ConferenceRoom conferenceRoom = new ConferenceRoom("Conference Room B", 30);
        Guest guest = new Guest("David");

        hotel.checkOutGuestFromRoom(guest, conferenceRoom);
        assertFalse(conferenceRoom.getGuests().contains(guest));
    }

}
