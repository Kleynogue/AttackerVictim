import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.common.exceptions.DbHandlerException;

public class DbHandlerExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Test exception";
        DbHandlerException exception = new DbHandlerException(message);
        assertEquals(message, exception.getMessage());
    }
}