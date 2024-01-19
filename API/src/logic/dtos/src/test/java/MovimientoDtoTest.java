import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.ucab.cmcapp.logic.dtos.MovimientoDto;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MovimientoDtoTest {

    @Mock
    TelefonoDto telefonoMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructor() {
        long id = 1L;
        MovimientoDto movimientoDto = new MovimientoDto(id);
        assertEquals(id, movimientoDto.getId());
    }


    @Test
    public void testGetSetX() {
        MovimientoDto movimientoDto = new MovimientoDto();
        double x = 1.23;
        movimientoDto.setX(x);
        assertEquals(x, movimientoDto.getX());
    }

    @Test
    public void testGetSetY() {
        MovimientoDto movimientoDto = new MovimientoDto();
        double y = 4.56;
        movimientoDto.setY(y);
        assertEquals(y, movimientoDto.getY());
    }

    @Test
    public void testGetSetZ() {
        MovimientoDto movimientoDto = new MovimientoDto();
        double z = 7.89;
        movimientoDto.setZ(z);
        assertEquals(z, movimientoDto.getZ());
    }

    @Test
    public void testGetSetDate() {
        MovimientoDto movimientoDto = new MovimientoDto();
        String date = "2021-01-01";
        movimientoDto.setDate(date);
        assertEquals(date, movimientoDto.getDate());
    }

    @Test
    public void testGetSetTelefono() {
        MovimientoDto movimientoDto = new MovimientoDto();
        movimientoDto.setTelefono(telefonoMock);
        assertEquals(telefonoMock, movimientoDto.getTelefono());
    }

    @Test
    public void testToString() {
        MovimientoDto movimientoDto = new MovimientoDto();
        double x = 1.23;
        movimientoDto.setX(x);
        double y = 4.56;
        movimientoDto.setY(y);
        double z = 7.89;
        movimientoDto.setZ(z);
        String date = "2021-01-01";
        movimientoDto.setDate(date);
        movimientoDto.setTelefono(telefonoMock);
        long id = 1;
        movimientoDto.setId(id);

        when(telefonoMock.toString()).thenReturn("Telefono");

        String expected = "MovimientoDto{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", date='" + date + '\'' +
                ", telefono=Telefono" +
                ", _id=" + id +
                '}';
        assertEquals(expected, movimientoDto.toString());
    }

}