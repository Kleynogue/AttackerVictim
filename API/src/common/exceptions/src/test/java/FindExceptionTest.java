import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.common.exceptions.FindException;

public class FindExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Test exception";
        FindException exception = new FindException(message);
        assertEquals(message, exception.getMessage());
    }
}