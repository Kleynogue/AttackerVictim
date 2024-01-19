import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ucab.cmcapp.common.exceptions.UpdateException;

public class UpdateExceptionTest {

    @Test
    void testConstructor() {
        Exception exception = new Exception("Test Exception Message");
        String message = "Test String";
        UpdateException updateException = new UpdateException(exception, message);
        assertEquals(exception, updateException.getCause());
        assertEquals(message, updateException.getMessage());
    }
}