import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.ucab.cmcapp.logic.dtos.ConexionDto;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ConexionDtoTest {

    @Mock
    TelefonoDto telefonoMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructor(){
        ConexionDto conexionDto = new ConexionDto(1);
        assertEquals(1, conexionDto.getId());
    }

    @Test
    public void testGetSetId() {
        ConexionDto conexionDto = new ConexionDto();
        Long id = 1L;
        conexionDto.setId(id);
        assertEquals(id, conexionDto.getId());
    }

    @Test
    public void testGetSetDate() {
        ConexionDto conexionDto = new ConexionDto();
        String date = "2021-01-01";
        conexionDto.setDate(date);
        assertEquals(date, conexionDto.getDate());
    }

    @Test
    public void testGetSetTelefono() {
        ConexionDto conexionDto = new ConexionDto();
        conexionDto.setTelefono(telefonoMock);
        assertEquals(telefonoMock, conexionDto.getTelefono());
    }

    @Test
    public void testToString() {
        ConexionDto conexionDto = new ConexionDto();
        String date = "2021-01-01";
        conexionDto.setDate(date);
        conexionDto.setTelefono(telefonoMock);
        long id = 1;
        conexionDto.setId(id);

        when(telefonoMock.toString()).thenReturn("Telefono");

        String expected = "ConexionDto{" +
                "date='" + date + '\'' +
                ", telefono=Telefono" +
                ", _id=" + id +
                '}';
        assertEquals(expected, conexionDto.toString());
    }

}