import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.common.exceptions.InsertException;

public class InsertExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Test exception";
        InsertException exception = new InsertException(message);
        assertEquals(message, exception.getMessage());
    }
}