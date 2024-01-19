import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ucab.cmcapp.common.exceptions.JWTVerifyException;

public class JWTVerifyExceptionTest {

    @Test
    void testConstructor() {
        String message = "Test Exception Message";
        JWTVerifyException exception = new JWTVerifyException(message);
        assertEquals(message, exception.getMessage());
    }
}