package entities;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.common.entities.Telefono;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class HistoricoPuntoTest {

    private HistoricoPunto historicoPunto;

    @Mock
    private PuntoGeografico puntoGeograficoMock;

    @Mock
    private Telefono telefonoMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        historicoPunto = new HistoricoPunto();
    }

    @Test
    public void testGetHistPunID() {
        long histPunID = 1L;
        historicoPunto.setHistPunID(histPunID);
        assertEquals(histPunID, historicoPunto.getHistPunID());
    }

    @Test
    public void testGetHistPunFechaInicio() {
        Date histPunFechaInicio = new Date();
        historicoPunto.setHistPunFechaInicio(histPunFechaInicio);
        assertEquals(histPunFechaInicio, historicoPunto.getHistPunFechaInicio());
    }

    @Test
    public void testGetHistPunFechaFin() {
        Date histPunFechaFin = new Date();
        historicoPunto.setHistPunFechaFin(histPunFechaFin);
        assertEquals(histPunFechaFin, historicoPunto.getHistPunFechaFin());
    }

    @Test
    public void testGetHistPunFKTelefono() {
        historicoPunto.setHistPunFKTelefono(telefonoMock);
        assertEquals(telefonoMock, historicoPunto.getHistPunFKTelefono());
    }

    @Test
    public void testGetHistPunFKPuntoGeografico() {
        historicoPunto.setHistPunFKPuntoGeografico(puntoGeograficoMock);
        assertEquals(puntoGeograficoMock, historicoPunto.getHistPunFKPuntoGeografico());
    }

    @Test
    public void testConstructor() {
        long histPunID = 1L;
        HistoricoPunto historicoPunto1 = new HistoricoPunto(histPunID);

        assertEquals(histPunID, historicoPunto1.getHistPunID());
    }

    @Test
    public void testToString() {
        long histPunID = 1L;
        Date histPunFechaInicio = new Date();
        Date histPunFechaFin = new Date();

        historicoPunto.setHistPunID(histPunID);
        historicoPunto.setHistPunFechaInicio(histPunFechaInicio);
        historicoPunto.setHistPunFechaFin(histPunFechaFin);
        historicoPunto.setHistPunFKTelefono(telefonoMock);
        historicoPunto.setHistPunFKPuntoGeografico(puntoGeograficoMock);

        when(telefonoMock.toString()).thenReturn("Telefono");
        when(puntoGeograficoMock.toString()).thenReturn("Punto");

        String expected = "HistoricoPunto{" +
                "histPunID=" + histPunID +
                ", histPunFechaInicio=" + histPunFechaInicio +
                ", histPunFechaFin=" + histPunFechaFin +
                ", histPunFKTelefono=Telefono"+
                ", histPunFKPuntoGeografico=Punto" +
                '}';
        assertEquals(expected, historicoPunto.toString());
    }
}