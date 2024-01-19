package entities;

import com.ucab.cmcapp.common.entities.Querella;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuerellaTest {

    @Test
    public void testGetQuerID() {
        long querID = 1L;
        Querella querella = new Querella();
        querella.setQuerID(querID);
        assertEquals(querID, querella.getQuerID());
    }

    @Test
    public void testGetQuerDistanciaMin() {
        double querDistanciaMin = 10.5;
        Querella querella = new Querella();
        querella.setQuerDistanciaMin(querDistanciaMin);
        assertEquals(querDistanciaMin, querella.getQuerDistanciaMin());
    }

    @Test
    public void testGetQuerTiempoControl() {
        int querTiempoControl = 60;
        Querella querella = new Querella();
        querella.setQuerTiempoControl(querTiempoControl);
        assertEquals(querTiempoControl, querella.getQuerTiempoControl());
    }

    @Test
    public void testGetQuerStatus() {
        String querStatus = "Activa";
        Querella querella = new Querella();
        querella.setQuerStatus(querStatus);
        assertEquals(querStatus, querella.getQuerStatus());
    }

    @Test
    public void testConstructor() {
        long querID = 1L;
        Querella querella = new Querella(querID);
        assertEquals(querID, querella.getQuerID());
    }

    @Test
    public void testToString() {
        long querID = 1L;
        double querDistanciaMin = 10.5;
        int querTiempoControl = 60;
        String querStatus = "Activa";

        Querella querella = new Querella();
        querella.setQuerID(querID);
        querella.setQuerDistanciaMin(querDistanciaMin);
        querella.setQuerTiempoControl(querTiempoControl);
        querella.setQuerStatus(querStatus);

        String expected = "Querella{" +
                "querID=" + querID +
                ", querDistanciaMin=" + querDistanciaMin +
                ", querTiempoControl=" + querTiempoControl +
                ", querStatus='" + querStatus + '\'' +
                '}';
        assertEquals(expected, querella.toString());
    }
}