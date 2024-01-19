import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.ucab.cmcapp.logic.dtos.PuntoGeograficoDto;

public class PuntoGeograficoDtoTest {

    @org.junit.Test
    public void testConstructor() {
        PuntoGeograficoDto puntoGeograficoDto = new PuntoGeograficoDto(1);
        assertEquals(0, puntoGeograficoDto.getLatitude());
        assertEquals(0, puntoGeograficoDto.getLongitude());
    }

    @Test
    public void testGetSetLatitud() {
        PuntoGeograficoDto puntoGeograficoDto = new PuntoGeograficoDto();
        double latitud = 10.12345;
        puntoGeograficoDto.setLatitude(latitud);
        assertEquals(latitud, puntoGeograficoDto.getLatitude());
    }

    @Test
    public void testGetSetLongitud() {
        PuntoGeograficoDto puntoGeograficoDto = new PuntoGeograficoDto();
        double longitud = -66.54321;
        puntoGeograficoDto.setLongitude(longitud);
        assertEquals(longitud, puntoGeograficoDto.getLongitude());
    }

    @Test
    public void testGetSetStatus() {
        PuntoGeograficoDto puntoGeograficoDto = new PuntoGeograficoDto();
        String status = "Activo";
        puntoGeograficoDto.setStatus(status);
        assertEquals(status, puntoGeograficoDto.getStatus());
    }

    @Test
    public void testToString() {
        PuntoGeograficoDto puntoGeograficoDto = new PuntoGeograficoDto();
        double latitud = 10.12345;
        puntoGeograficoDto.setLatitude(latitud);
        double longitud = -66.54321;
        puntoGeograficoDto.setLongitude(longitud);
        String status = "Activo";
        puntoGeograficoDto.setStatus(status);
        String expected = "PuntoGeograficoDto{" +
                "latitude=" + latitud +
                ", longitude=" + longitud +
                ", status='" + status +
                "', _id=0" +
                '}';
        assertEquals(expected, puntoGeograficoDto.toString());
    }

}