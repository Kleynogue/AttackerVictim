import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.common.exceptions.AuthorizationException;

public class AuthorizationExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Test exception";
        AuthorizationException exception = new AuthorizationException(message);
        assertEquals(message, exception.getMessage());
    }
}