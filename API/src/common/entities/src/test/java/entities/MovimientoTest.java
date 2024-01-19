package entities;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.common.entities.Telefono;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MovimientoTest {

    private Movimiento movimiento;

    @Mock
    private Telefono telefonoMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        movimiento = new Movimiento();
    }

    @Test
    public void testGetMoviID() {
        long moviID = 1L;
        movimiento.setMoviID(moviID);
        assertEquals(moviID, movimiento.getMoviID());
    }

    @Test
    public void testGetMoviX() {
        double moviX = 10.5;
        movimiento.setMoviX(moviX);
        assertEquals(moviX, movimiento.getMoviX(), 0.0001);
    }

    @Test
    public void testGetMoviY() {
        double moviY = 20.3;
        movimiento.setMoviY(moviY);
        assertEquals(moviY, movimiento.getMoviY(), 0.0001);
    }

    @Test
    public void testGetMoviZ() {
        double moviZ = 5.1;
        movimiento.setMoviZ(moviZ);
        assertEquals(moviZ, movimiento.getMoviZ(), 0.0001);
    }

    @Test
    public void testGetMoviFecha() {
        Date moviFecha = new Date();
        movimiento.setMoviFecha(moviFecha);
        assertEquals(moviFecha, movimiento.getMoviFecha());
    }

    @Test
    public void testGetMoviFKTelefono() {
        movimiento.setMoviFKTelefono(telefonoMock);
        assertEquals(telefonoMock, movimiento.getMoviFKTelefono());
    }

    @Test
    public void testConstructor() {
        long moviID = 1L;
        movimiento = new Movimiento(moviID);

        assertEquals(moviID, movimiento.getMoviID());
    }

    @Test
    public void testToString() {
        long moviID = 1L;
        double moviX = 10.5;
        double moviY = 20.3;
        double moviZ = 5.1;
        Date moviFecha = new Date();

        movimiento.setMoviID(moviID);
        movimiento.setMoviX(moviX);
        movimiento.setMoviY(moviY);
        movimiento.setMoviZ(moviZ);
        movimiento.setMoviFecha(moviFecha);
        movimiento.setMoviFKTelefono(telefonoMock);

        when(telefonoMock.toString()).thenReturn("Telefono");

        String expected = "Movimiento{" +
                "moviID=" + moviID +
                ", moviX=" + moviX +
                ", moviY=" + moviY +
                ", moviZ=" + moviZ +
                ", moviFecha=" + moviFecha +
                ", moviFKTelefono=Telefono" +
                '}';
        assertEquals(expected, movimiento.toString());
    }
}