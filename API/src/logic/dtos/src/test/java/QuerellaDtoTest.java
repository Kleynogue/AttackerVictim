import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.ucab.cmcapp.logic.dtos.QuerellaDto;

public class QuerellaDtoTest {

    @Test
    public void testConstructor() {
        QuerellaDto querellaDto = new QuerellaDto(1);
        assertEquals(1, querellaDto.getId());
    }

    @Test
    public void testGetSetDistanciaMin() {
        QuerellaDto querellaDto = new QuerellaDto();
        double distanciaMin = 10.5;
        querellaDto.setDistanciaMin(distanciaMin);
        assertEquals(distanciaMin, querellaDto.getDistanciaMin());
    }

    @Test
    public void testGetSetTiempoControl() {
        QuerellaDto querellaDto = new QuerellaDto();
        int tiempoControl = 60;
        querellaDto.setTiempoControl(tiempoControl);
        assertEquals(tiempoControl, querellaDto.getTiempoControl());
    }

    @Test
    public void testGetSetStatus() {
        QuerellaDto querellaDto = new QuerellaDto();
        String status = "Activo";
        querellaDto.setStatus(status);
        assertEquals(status, querellaDto.getStatus());
    }

    @Test
    public void testToString() {
        QuerellaDto querellaDto = new QuerellaDto();
        double distanciaMin = 10.5;
        querellaDto.setDistanciaMin(distanciaMin);
        int tiempoControl = 60;
        querellaDto.setTiempoControl(tiempoControl);
        String status = "Activo";
        querellaDto.setStatus(status);
        long id = 1;
        querellaDto.setId(id);
        String expected = "QuerellaDto{" +
                "distanciaMin=" + distanciaMin +
                ", tiempoControl=" + tiempoControl +
                ", status='" + status + '\'' +
                ", _id=" + id +
                '}';
        assertEquals(expected, querellaDto.toString());
    }

    // Agrega más pruebas para los demás métodos si es necesario

}