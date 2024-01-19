package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ucab.cmcapp.common.entities.*;

import static org.mockito.Mockito.when;

public class ZonaPuntoTest {

    @Mock
    private PuntoGeografico mockPuntoGeografico;

    @Mock
    private ZonaSeguridad mockZonaSeguridad;

    private ZonaPunto zonaPunto;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        zonaPunto = new ZonaPunto();
    }

    @Test
    public void testSetAndGetZonPunFKPuntoGeografico() {
        zonaPunto.setZonPunFKPuntoGeografico(mockPuntoGeografico);
        Assertions.assertEquals(mockPuntoGeografico, zonaPunto.getZonPunFKPuntoGeografico());
    }

    @Test
    public void testSetAndGetZonPunFKZonaSeguridad() {
        zonaPunto.setZonPunFKZonaSeguridad(mockZonaSeguridad);
        Assertions.assertEquals(mockZonaSeguridad, zonaPunto.getZonPunFKZonaSeguridad());
    }

    @Test
    public void testConstructorWithPuntoGeograficoAndZonaSeguridad() {
        ZonaPunto zonaPunto = new ZonaPunto(mockPuntoGeografico, mockZonaSeguridad);
        Assertions.assertEquals(mockPuntoGeografico, zonaPunto.getZonPunFKPuntoGeografico());
        Assertions.assertEquals(mockZonaSeguridad, zonaPunto.getZonPunFKZonaSeguridad());
    }

    @Test
    public void testToString() {
        zonaPunto.setZonPunFKPuntoGeografico(mockPuntoGeografico);
        zonaPunto.setZonPunFKZonaSeguridad(mockZonaSeguridad);

        when(mockPuntoGeografico.toString()).thenReturn("Punto");
        when(mockZonaSeguridad.toString()).thenReturn("Zona");

        String expectedString = "ZonaPunto{" +
                "zonPunFKPuntoGeografico=Punto" +
                ", zonPunFKZonaSeguridad=Zona" +
                '}';

        Assertions.assertEquals(expectedString, zonaPunto.toString());
    }
}