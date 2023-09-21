import static org.junit.jupiter.api.Assertions.*;

import com.codebase.RoomType;
import org.junit.jupiter.api.Test;

public class RoomTypeTest {
    @Test
    public void testRoomTypeValues() {

        assertEquals(RoomType.SINGLE, RoomType.valueOf("SINGLE"));
        assertEquals(RoomType.DOUBLE, RoomType.valueOf("DOUBLE"));
    }

    @Test
    public void testRoomTypeCapacity() {

        assertEquals(1, RoomType.SINGLE.getCapacity());
        assertEquals(2, RoomType.DOUBLE.getCapacity());
    }
}

