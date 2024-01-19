package entities;

import com.ucab.cmcapp.common.entities.PuntoGeografico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntoGeograficoTest {

    @Test
    public void testGetPunGeoID() {
        long punGeoID = 1L;
        PuntoGeografico puntoGeografico = new PuntoGeografico();
        puntoGeografico.setPunGeoID(punGeoID);
        assertEquals(punGeoID, puntoGeografico.getPunGeoID());
    }

    @Test
    public void testGetPunGeoLatitud() {
        double punGeoLatitud = 10.2;
        PuntoGeografico puntoGeografico = new PuntoGeografico();
        puntoGeografico.setPunGeoLatitud(punGeoLatitud);
        assertEquals(punGeoLatitud, puntoGeografico.getPunGeoLatitud());
    }

    @Test
    public void testGetPunGeoLongitud() {
        double punGeoLongitud = -66.9;
        PuntoGeografico puntoGeografico = new PuntoGeografico();
        puntoGeografico.setPunGeoLongitud(punGeoLongitud);
        assertEquals(punGeoLongitud, puntoGeografico.getPunGeoLongitud());
    }

    @Test
    public void testGetPunGeoStatus() {
        String punGeoStatus = "Activo";
        PuntoGeografico puntoGeografico = new PuntoGeografico();
        puntoGeografico.setPunGeoStatus(punGeoStatus);
        assertEquals(punGeoStatus, puntoGeografico.getPunGeoStatus());
    }

    @Test
    public void testConstructor() {
        long punGeoID = 1L;
        PuntoGeografico puntoGeografico = new PuntoGeografico(punGeoID);
        assertEquals(punGeoID, puntoGeografico.getPunGeoID());
    }

    @Test
    public void testToString() {
        long punGeoID = 1L;
        double punGeoLatitud = 10.2;
        double punGeoLongitud = -66.9;
        String punGeoStatus = "Activo";

        PuntoGeografico puntoGeografico = new PuntoGeografico();
        puntoGeografico.setPunGeoID(punGeoID);
        puntoGeografico.setPunGeoLatitud(punGeoLatitud);
        puntoGeografico.setPunGeoLongitud(punGeoLongitud);
        puntoGeografico.setPunGeoStatus(punGeoStatus);

        String expected = "PuntoGeografico{" +
                "punGeoID=" + punGeoID +
                ", punGeoLatitud=" + punGeoLatitud +
                ", punGeoLongitud=" + punGeoLongitud +
                ", punGeoStatus='" + punGeoStatus + '\'' +
                '}';
        assertEquals(expected, puntoGeografico.toString());
    }
}