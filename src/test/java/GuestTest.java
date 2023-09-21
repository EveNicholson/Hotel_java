import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codebase.Guest;
import org.junit.jupiter.api.Test;

public class GuestTest {
    @Test
    public void testGetName() {
        Guest guest = new Guest("Ewelina");
        assertEquals("Ewelina", guest.getName());
    }
}

