package entities;

import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.common.entities.PuntoGeografico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReporteTest {

    private Reporte reporte;

    @Mock
    Telefono telefonoMock;

    @Mock
    PuntoGeografico puntoGeograficoMock;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        reporte = new Reporte();
    }

    @Test
    public void testGetRepoID() {
        long repoID = 1L;
        reporte.setRepoID(repoID);
        assertEquals(repoID, reporte.getRepoID());
    }

    @Test
    public void testGetRepoFecha() {
        Date repoFecha = new Date();
        reporte.setRepoFecha(repoFecha);
        assertEquals(repoFecha, reporte.getRepoFecha());
    }

    @Test
    public void testGetRepoTipo() {
        String repoTipo = "Tipo de reporte";
        reporte.setRepoTipo(repoTipo);
        assertEquals(repoTipo, reporte.getRepoTipo());
    }

    @Test
    public void testGetRepoFKTelefono() {
        reporte.setRepoFKTelefono(telefonoMock);
        assertEquals(telefonoMock, reporte.getRepoFKTelefono());
    }

    @Test
    public void testGetRepoFKPuntoGeografico() {
        reporte.setRepoFKPuntoGeografico(puntoGeograficoMock);
        assertEquals(puntoGeograficoMock, reporte.getRepoFKPuntoGeografico());
    }

    @Test
    public void testConstructor() {
        long repoID = 1L;
        Reporte reporte = new Reporte(repoID);
        assertEquals(repoID, reporte.getRepoID());
    }

    @Test
    public void testToString() {
        long repoID = 1L;
        Date repoFecha = new Date();
        String repoTipo = "Tipo de reporte";

        reporte.setRepoID(repoID);
        reporte.setRepoFecha(repoFecha);
        reporte.setRepoTipo(repoTipo);
        reporte.setRepoFKTelefono(telefonoMock);
        reporte.setRepoFKPuntoGeografico(puntoGeograficoMock);

        when(telefonoMock.toString()).thenReturn("Telefono");
        when(puntoGeograficoMock.toString()).thenReturn("Punto");

        String expected = "Reporte{" +
                "repoID=" + repoID +
                ", repoFecha=" + repoFecha +
                ", repoTipo='" + repoTipo + '\'' +
                ", repoFKTelefono=Telefono"+
                ", repoFKPuntoGeografico=Punto"+
                '}';
        assertEquals(expected, reporte.toString());
    }
}