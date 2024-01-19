package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ucab.cmcapp.common.entities.*;
import static org.mockito.Mockito.when;

public class ZonaSeguridadTest {

    @Mock
    private Querella mockQuerella;

    private ZonaSeguridad zonaSeguridad;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        zonaSeguridad = new ZonaSeguridad();
    }

    @Test
    public void testSetAndGetZonSegID() {
        long zonSegID = 1L;
        zonaSeguridad.setZonSegID(zonSegID);
        Assertions.assertEquals(zonSegID, zonaSeguridad.getZonSegID());
    }

    @Test
    public void testSetAndGetZonSegNombre() {
        String zonSegNombre = "nombre";
        zonaSeguridad.setZonSegNombre(zonSegNombre);
        Assertions.assertEquals(zonSegNombre, zonaSeguridad.getZonSegNombre());
    }

    @Test
    public void testSetAndGetZonSegFKQuerella() {
        zonaSeguridad.setZonSegFKQuerella(mockQuerella);
        Assertions.assertEquals(mockQuerella, zonaSeguridad.getZonSegFKQuerella());
    }

    @Test
    public void testConstructorWithZonSegID() {
        long zonSegID = 1L;
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad(zonSegID);
        Assertions.assertEquals(zonSegID, zonaSeguridad.getZonSegID());
    }

    @Test
    public void testToString() {
        long zonSegID = 1L;
        String zonSegNombre = "nombre";

        zonaSeguridad.setZonSegID(zonSegID);
        zonaSeguridad.setZonSegNombre(zonSegNombre);
        zonaSeguridad.setZonSegFKQuerella(mockQuerella);

        when(mockQuerella.toString()).thenReturn("Querella");

        String expectedString = "ZonaSeguridad{" +
                "zonSegID=" + zonSegID +
                ", zonSegNombre='" + zonSegNombre + '\'' +
                ", zonSegFKQuerella=Querella" +
                '}';

        Assertions.assertEquals(expectedString, zonaSeguridad.toString());
    }
}