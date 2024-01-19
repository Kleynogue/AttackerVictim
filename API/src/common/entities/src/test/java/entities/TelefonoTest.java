package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ucab.cmcapp.common.entities.*;

import java.util.Date;

import static org.mockito.Mockito.when;

public class TelefonoTest {

    @Mock
    private Usuario UsuarioMock;

    @Mock
    private Querella QuerellaMock;

    private Telefono telefono;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        telefono = new Telefono();
    }

    @Test
    public void testSetAndGetTeleID() {
        long teleID = 1L;
        telefono.setTeleID(teleID);
        Assertions.assertEquals(teleID, telefono.getTeleID());
    }

    @Test
    public void testSetAndGetTeleBluetooth() {
        String teleBluetooth = "Bluetooth";
        telefono.setTeleBluetooth(teleBluetooth);
        Assertions.assertEquals(teleBluetooth, telefono.getTeleBluetooth());
    }

    @Test
    public void testSetAndGetTeleFechaInicio() {
        Date teleFechaInicio = new Date();
        telefono.setTeleFechaInicio(teleFechaInicio);
        Assertions.assertEquals(teleFechaInicio, telefono.getTeleFechaInicio());
    }

    @Test
    public void testSetAndGetTeleFechaFin() {
        Date teleFechaFin = new Date();
        telefono.setTeleFechaFin(teleFechaFin);
        Assertions.assertEquals(teleFechaFin, telefono.getTeleFechaFin());
    }

    @Test
    public void testSetAndGetTeleFKUsuario() {
        telefono.setTeleFKUsuario(UsuarioMock);
        Assertions.assertEquals(UsuarioMock, telefono.getTeleFKUsuario());
    }

    @Test
    public void testSetAndGetTeleFKQuerella() {
        telefono.setTeleFKQuerella(QuerellaMock);
        Assertions.assertEquals(QuerellaMock, telefono.getTeleFKQuerella());
    }

    @Test
    public void testConstructorWithTeleID() {
        long teleID = 1L;
        telefono = new Telefono(teleID);
        Assertions.assertEquals(teleID, telefono.getTeleID());
    }

    @Test
    public void testToString() {
        long teleID = 1L;
        String teleBluetooth = "Bluetooth";
        Date teleFechaInicio = new Date();
        Date teleFechaFin = new Date();

        telefono.setTeleID(teleID);
        telefono.setTeleBluetooth(teleBluetooth);
        telefono.setTeleFechaInicio(teleFechaInicio);
        telefono.setTeleFechaFin(teleFechaFin);
        telefono.setTeleFKUsuario(UsuarioMock);
        telefono.setTeleFKQuerella(QuerellaMock);

        when(QuerellaMock.toString()).thenReturn("Querella");
        when(UsuarioMock.toString()).thenReturn("Usuario");

        String expectedString = "Telefono{" +
                "teleID=" + teleID +
                ", teleBluetooth='" + teleBluetooth + '\'' +
                ", teleFechaInicio=" + teleFechaInicio +
                ", teleFechaFin=" + teleFechaFin +
                ", teleFKUsuario=Usuario" +
                ", teleFKQuerella=Querella" +
                '}';

        Assertions.assertEquals(expectedString, telefono.toString());
    }
}