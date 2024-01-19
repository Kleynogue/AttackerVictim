package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ucab.cmcapp.common.entities.*;

import static org.mockito.Mockito.when;

public class UsuarioTest {

    @Mock
    private Persona personaMock;

    private Usuario usuario;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario();
    }

    @Test
    public void testSetAndGetUsuaID() {
        long usuaID = 1L;
        usuario.setUsuaID(usuaID);
        Assertions.assertEquals(usuaID, usuario.getUsuaID());
    }

    @Test
    public void testSetAndGetUsuaUsername() {
        String usuaUsername = "username";
        usuario.setUsuaUsername(usuaUsername);
        Assertions.assertEquals(usuaUsername, usuario.getUsuaUsername());
    }

    @Test
    public void testSetAndGetUsuaContrasena() {
        String usuaContrasena = "password";
        usuario.setUsuaContrasena(usuaContrasena);
        Assertions.assertEquals(usuaContrasena, usuario.getUsuaContrasena());
    }

    @Test
    public void testSetAndGetUsuaTipo() {
        String usuaTipo = "tipo";
        usuario.setUsuaTipo(usuaTipo);
        Assertions.assertEquals(usuaTipo, usuario.getUsuaTipo());
    }

    @Test
    public void testSetAndGetUsuaFKPersona() {
        usuario.setUsuaFKPersona(personaMock);
        Assertions.assertEquals(personaMock, usuario.getUsuaFKPersona());
    }

    @Test
    public void testConstructorWithUsuaID() {
        long usuaID = 1L;
        Usuario usuario = new Usuario(usuaID);
        Assertions.assertEquals(usuaID, usuario.getUsuaID());
    }

    @Test
    public void testToString() {
        long usuaID = 1L;
        String usuaUsername = "username";
        String usuaContrasena = "password";
        String usuaTipo = "tipo";

        usuario.setUsuaID(usuaID);
        usuario.setUsuaUsername(usuaUsername);
        usuario.setUsuaContrasena(usuaContrasena);
        usuario.setUsuaTipo(usuaTipo);
        usuario.setUsuaFKPersona(personaMock);

        when(personaMock.toString()).thenReturn("Persona");

        String expectedString = "Usuario{" +
                "usuaID=" + usuaID +
                ", usuaUsername='" + usuaUsername + '\'' +
                ", usuaContrasena='" + usuaContrasena + '\'' +
                ", usuaTipo='" + usuaTipo + '\'' +
                ", usuaFKPersona=Persona" +
                '}';

        Assertions.assertEquals(expectedString, usuario.toString());
    }
}