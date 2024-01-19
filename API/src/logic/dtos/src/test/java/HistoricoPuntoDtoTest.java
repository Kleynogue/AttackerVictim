import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.ucab.cmcapp.logic.dtos.HistoricoPuntoDto;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import com.ucab.cmcapp.logic.dtos.PuntoGeograficoDto;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HistoricoPuntoDtoTest {

    @Mock
    TelefonoDto telefonoMock;

    @Mock
    PuntoGeograficoDto puntoGeograficoMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructor(){
        HistoricoPuntoDto historicoPuntoDto = new HistoricoPuntoDto(1);
        assertEquals(1, historicoPuntoDto.getId());
    }

    @Test
    public void testGetSetId() {
        HistoricoPuntoDto historicoPuntoDto = new HistoricoPuntoDto();
        long id = 1;
        historicoPuntoDto.setId(id);
        assertEquals(id, historicoPuntoDto.getId());
    }

    @Test
    public void testGetSetFechaInicio() {
        HistoricoPuntoDto historicoPuntoDto = new HistoricoPuntoDto();
        String fechaInicio = "2021-01-01";
        historicoPuntoDto.setFechaInicio(fechaInicio);
        assertEquals(fechaInicio, historicoPuntoDto.getFechaInicio());
    }

    @Test
    public void testGetSetFechaFin() {
        HistoricoPuntoDto historicoPuntoDto = new HistoricoPuntoDto();
        String fechaFin = "2021-01-02";
        historicoPuntoDto.setFechaFin(fechaFin);
        assertEquals(fechaFin, historicoPuntoDto.getFechaFin());
    }

    @Test
    public void testGetSetTelefono() {
        HistoricoPuntoDto historicoPuntoDto = new HistoricoPuntoDto();
        historicoPuntoDto.setTelefono(telefonoMock);
        assertEquals(telefonoMock, historicoPuntoDto.getTelefono());
    }

    @Test
    public void testGetSetPuntoGeografico() {
        HistoricoPuntoDto historicoPuntoDto = new HistoricoPuntoDto();
        historicoPuntoDto.setPuntoGeografico(puntoGeograficoMock);
        assertEquals(puntoGeograficoMock, historicoPuntoDto.getPuntoGeografico());
    }

    @Test
    public void testToString() {
        HistoricoPuntoDto historicoPuntoDto = new HistoricoPuntoDto();
        String fechaInicio = "2021-01-01";
        historicoPuntoDto.setFechaInicio(fechaInicio);
        String fechaFin = "2021-01-02";
        historicoPuntoDto.setFechaFin(fechaFin);
        historicoPuntoDto.setTelefono(telefonoMock);
        historicoPuntoDto.setPuntoGeografico(puntoGeograficoMock);
        long id = 1;

        when(telefonoMock.toString()).thenReturn("Telefono");
        when(puntoGeograficoMock.toString()).thenReturn("Punto");

        historicoPuntoDto.setId(id);
        String expected = "HistoricoPuntoDto{" +
                "fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", telefono=Telefono" +
                ", puntoGeografico=Punto" +
                ", _id=" + id +
                '}';
        assertEquals(expected, historicoPuntoDto.toString());
    }

}