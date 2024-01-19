import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.common.exceptions.AuthenticationException;

public class AuthenticationExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Test exception";
        AuthenticationException exception = new AuthenticationException(message);
        assertEquals(message, exception.getMessage());
    }
}