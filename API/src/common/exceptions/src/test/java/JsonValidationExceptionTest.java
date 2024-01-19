import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.common.exceptions.JsonValidationException;

public class JsonValidationExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Test exception";
        JsonValidationException exception = new JsonValidationException(message);
        assertEquals(message, exception.getMessage());
    }
}