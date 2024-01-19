import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.common.exceptions.BadIdException;

public class BadIdExceptionTest {

    @Test
    public void testConstructor() {
        String id = "123";
        BadIdException exception = new BadIdException(id);
        assertEquals("Invalid Id: " + id, exception.getMessage());
    }
}