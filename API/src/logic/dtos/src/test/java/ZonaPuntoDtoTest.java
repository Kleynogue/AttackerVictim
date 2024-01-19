import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.ucab.cmcapp.logic.dtos.ZonaPuntoDto;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.dtos.PuntoGeograficoDto;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ZonaPuntoDtoTest {

    @Mock
    ZonaSeguridadDto zonaSeguridadMock;

    @Mock
    PuntoGeograficoDto puntoGeograficoMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructor() {
        ZonaPuntoDto zonaPuntoDto = new ZonaPuntoDto(1);
        assertEquals(1, zonaPuntoDto.getId());
    }

    @Test
    public void testGetSetZona() {
        ZonaPuntoDto zonaPuntoDto = new ZonaPuntoDto();
        zonaPuntoDto.setZona(zonaSeguridadMock);
        assertEquals(zonaSeguridadMock, zonaPuntoDto.getZona());
    }

    @Test
    public void testGetSetPunto() {
        ZonaPuntoDto zonaPuntoDto = new ZonaPuntoDto();
        zonaPuntoDto.setPunto(puntoGeograficoMock);
        assertEquals(puntoGeograficoMock, zonaPuntoDto.getPunto());
    }

    @Test
    public void testToString() {
        ZonaPuntoDto zonaPuntoDto = new ZonaPuntoDto();
        zonaPuntoDto.setZona(zonaSeguridadMock);
        zonaPuntoDto.setPunto(puntoGeograficoMock);
        long id = 1;
        zonaPuntoDto.setId(id);

        when(zonaSeguridadMock.toString()).thenReturn("Zona");
        when(puntoGeograficoMock.toString()).thenReturn("Punto");

        String expected = "ZonaPuntoDto{" +
                "zona=Zona"  +
                ", punto=Punto" +
                ", _id=" + id +
                '}';
        assertEquals(expected, zonaPuntoDto.toString());
    }

}