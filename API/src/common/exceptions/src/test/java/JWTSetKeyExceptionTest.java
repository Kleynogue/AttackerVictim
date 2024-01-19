import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ucab.cmcapp.common.exceptions.JWTSetKeyException;

public class JWTSetKeyExceptionTest {

    @Test
    void testConstructor() {
        String message = "Test Exception Message";
        JWTSetKeyException exception = new JWTSetKeyException(message);
        assertEquals(message, exception.getMessage());
    }
}