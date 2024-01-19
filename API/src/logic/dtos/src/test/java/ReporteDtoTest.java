import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.ucab.cmcapp.logic.dtos.ReporteDto;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import com.ucab.cmcapp.logic.dtos.PuntoGeograficoDto;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReporteDtoTest {

    @Mock
    TelefonoDto telefonoMock;

    @Mock
    PuntoGeograficoDto puntoGeograficoMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructor() {
        ReporteDto reporteDto = new ReporteDto(1);
        assertEquals(1, reporteDto.getId());
    }

    @Test
    public void testGetSetDate() {
        ReporteDto reporteDto = new ReporteDto();
        String date = "2021-09-30";
        reporteDto.setDate(date);
        assertEquals(date, reporteDto.getDate());
    }

    @Test
    public void testGetSetType() {
        ReporteDto reporteDto = new ReporteDto();
        String type = "Tipo de reporte";
        reporteDto.setType(type);
        assertEquals(type, reporteDto.getType());
    }

    @Test
    public void testGetSetTelefono() {
        ReporteDto reporteDto = new ReporteDto();
        reporteDto.setTelefono(telefonoMock);
        assertEquals(telefonoMock, reporteDto.getTelefono());
    }

    @Test
    public void testGetSetPuntoGeografico() {
        ReporteDto reporteDto = new ReporteDto();
        reporteDto.setPuntoGeografico(puntoGeograficoMock);
        assertEquals(puntoGeograficoMock, reporteDto.getPuntoGeografico());
    }

    @Test
    public void testToString() {
        ReporteDto reporteDto = new ReporteDto();
        String date = "2021-09-30";
        reporteDto.setDate(date);
        String type = "Tipo de reporte";
        reporteDto.setType(type);
        reporteDto.setTelefono(telefonoMock);
        reporteDto.setPuntoGeografico(puntoGeograficoMock);
        long id = 1;
        reporteDto.setId(id);

        when(telefonoMock.toString()).thenReturn("Telefono");
        when(puntoGeograficoMock.toString()).thenReturn("Punto");

        String expected = "ReporteDto{" +
                "date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", telefono=Telefono" +
                ", puntoGeografico=Punto" +
                ", _id=" + id +
                '}';
        assertEquals(expected, reporteDto.toString());
    }

    // Agrega más pruebas para los demás métodos si es necesario

}