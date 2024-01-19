import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ucab.cmcapp.common.exceptions.NotFoundException;

public class NotFoundExceptionTest {

    @Test
    void testConstructor() {
        String message = "Test Exception Message";
        NotFoundException exception = new NotFoundException(message);
        assertEquals(message, exception.getMessage());
    }
}