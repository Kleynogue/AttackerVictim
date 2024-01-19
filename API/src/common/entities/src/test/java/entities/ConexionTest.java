package entities;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.common.entities.Telefono;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ConexionTest {

    private Conexion conexion;

    @Mock
    private Telefono telefonoMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        conexion = new Conexion();
    }

    @Test
    public void testGetConeID() {
        long coneID = 1L;
        conexion.setConeID(coneID);
        assertEquals(coneID, conexion.getConeID());
    }

    @Test
    public void testGetConeFecha() {
        Date coneFecha = new Date();
        conexion.setConeFecha(coneFecha);
        assertEquals(coneFecha, conexion.getConeFecha());
    }

    @Test
    public void testGetConeFKTelefono() {
        conexion.setConeFKTelefono(telefonoMock);
        assertEquals(telefonoMock, conexion.getConeFKTelefono());
    }

    @Test
    public void testConstructor() {
        long coneID = 1L;
        conexion = new Conexion(coneID);

        assertEquals(coneID, conexion.getConeID());
    }

    @Test
    public void testToString() {
        long coneID = 1L;
        Date coneFecha = new Date();
        conexion.setConeID(coneID);
        conexion.setConeFecha(coneFecha);
        conexion.setConeFKTelefono(telefonoMock);

        when(telefonoMock.toString()).thenReturn("Telefono");

        String expected = "Conexion{" +
                "coneID=" + coneID +
                ", coneFecha=" + coneFecha +
                ", coneFKTelefono=Telefono" +
                '}';
        assertEquals(expected, conexion.toString());
    }
}
