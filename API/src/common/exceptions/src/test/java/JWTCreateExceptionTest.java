import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.common.exceptions.JWTCreateException;

public class JWTCreateExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Test exception";
        JWTCreateException exception = new JWTCreateException(message);
        assertEquals(message, exception.getMessage());
    }
}