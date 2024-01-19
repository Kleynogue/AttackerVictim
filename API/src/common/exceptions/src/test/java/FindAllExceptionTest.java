import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.common.exceptions.FindAllException;

public class FindAllExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Test exception";
        FindAllException exception = new FindAllException(message);
        assertEquals(message, exception.getMessage());
    }
}