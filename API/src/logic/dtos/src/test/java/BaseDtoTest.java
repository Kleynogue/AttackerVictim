import com.ucab.cmcapp.common.exceptions.BadIdException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import com.ucab.cmcapp.logic.dtos.QuerellaDto;

public class BaseDtoTest {

    @Test
    public void getIdTest() {
        QuerellaDto querellaDto = new QuerellaDto(123);
        assertEquals(123, querellaDto.getId());
    }

    @Test
    public void setIdValidTest() {
        QuerellaDto querellaDto = new QuerellaDto();
        querellaDto.setId(456);
        assertEquals(456, querellaDto.getId());
    }

    @Test
    public void setIdInvalidTest() {
        QuerellaDto querellaDto = new QuerellaDto();
        try {
            querellaDto.setId(-789);
            fail("Expected BadIdException to be thrown");
        } catch (BadIdException e) {
            assertEquals("Invalid Id: -789", e.getMessage());
        }
    }
}