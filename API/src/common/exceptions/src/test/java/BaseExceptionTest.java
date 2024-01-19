import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.common.exceptions.BaseException;

public class BaseExceptionTest {

    @Test
    public void testConstructorWithIllegalArgumentException() {
        IllegalArgumentException cause = new IllegalArgumentException("Test exception");
        BaseException exception = new BaseException(cause);
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testConstructorWithExceptionAndString() {
        String message = "Test exception";
        Exception cause = new Exception("Inner exception");
        BaseException exception = new BaseException(cause, message);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testConstructorWithString() {
        String message = "Test exception";
        BaseException exception = new BaseException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testConstructorWithException() {
        Exception cause = new Exception("Test exception");
        BaseException exception = new BaseException(cause);
        assertEquals(cause, exception.getCause());
    }
}