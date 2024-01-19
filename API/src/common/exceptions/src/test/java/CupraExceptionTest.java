import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.common.exceptions.CupraException;

public class CupraExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Test exception";
        CupraException exception = new CupraException(message);
        assertEquals(message, exception.getMessage());
    }
}