import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import com.ucab.cmcapp.logic.dtos.QuerellaDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TelefonoDtoTest {

    @Mock
    UsuarioDto usuarioMock;

    @Mock
    QuerellaDto querellaMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructor() {
        TelefonoDto telefonoDto = new TelefonoDto(1);
        assertEquals(1, telefonoDto.getId());
    }


    @Test
    public void testGetSetBluetooth() {
        TelefonoDto telefonoDto = new TelefonoDto();
        String bluetooth = "Bluetooth";
        telefonoDto.setBluetooth(bluetooth);
        assertEquals(bluetooth, telefonoDto.getBluetooth());
    }

    @Test
    public void testGetSetFechaInicio() {
        TelefonoDto telefonoDto = new TelefonoDto();
        String fechaInicio = "2021-09-30";
        telefonoDto.setFechaInicio(fechaInicio);
        assertEquals(fechaInicio, telefonoDto.getFechaInicio());
    }

    @Test
    public void testGetSetFechaFin() {
        TelefonoDto telefonoDto = new TelefonoDto();
        String fechaFin = "2021-10-01";
        telefonoDto.setFechaFin(fechaFin);
        assertEquals(fechaFin, telefonoDto.getFechaFin());
    }

    @Test
    public void testGetSetUsuario() {
        TelefonoDto telefonoDto = new TelefonoDto();
        telefonoDto.setUsuario(usuarioMock);
        assertEquals(usuarioMock, telefonoDto.getUsuario());
    }

    @Test
    public void testGetSetQuerella() {
        TelefonoDto telefonoDto = new TelefonoDto();
        telefonoDto.setQuerella(querellaMock);
        assertEquals(querellaMock, telefonoDto.getQuerella());
    }

    @Test
    public void testToString() {
        TelefonoDto telefonoDto = new TelefonoDto();
        String bluetooth = "Bluetooth";
        telefonoDto.setBluetooth(bluetooth);
        String fechaInicio = "2021-09-30";
        telefonoDto.setFechaInicio(fechaInicio);
        String fechaFin = "2021-10-01";
        telefonoDto.setFechaFin(fechaFin);
        telefonoDto.setUsuario(usuarioMock);
        telefonoDto.setQuerella(querellaMock);
        long id = 1;
        telefonoDto.setId(id);

        when(querellaMock.toString()).thenReturn("Querella");
        when(usuarioMock.toString()).thenReturn("Usuario");

        String expected = "TelefonoDto{" +
                "bluetooth='" + bluetooth + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", usuario=Usuario" +
                ", querella=Querella" +
                ", _id=" + id +
                '}';
        assertEquals(expected, telefonoDto.toString());
    }

}