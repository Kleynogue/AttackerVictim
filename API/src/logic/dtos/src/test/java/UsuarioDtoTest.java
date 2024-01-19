import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.dtos.PersonaDto;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UsuarioDtoTest {

    @Mock
    PersonaDto personaMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructor() {
        long id = 1;
        UsuarioDto usuarioDto = new UsuarioDto(id);
        assertEquals(id, usuarioDto.getId());
    }

    @Test
    public void testGetSetUsername() {
        UsuarioDto usuarioDto = new UsuarioDto();
        String username = "john_doe";
        usuarioDto.setUsername(username);
        assertEquals(username, usuarioDto.getUsername());
    }

    @Test
    public void testGetSetTipo() {
        UsuarioDto usuarioDto = new UsuarioDto();
        String tipo = "admin";
        usuarioDto.setTipo(tipo);
        assertEquals(tipo, usuarioDto.getTipo());
    }

    @Test
    public void testGetSetPersona() {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setPersona(personaMock);
        assertEquals(personaMock, usuarioDto.getPersona());
    }

    @Test
    public void testToString() {
        UsuarioDto usuarioDto = new UsuarioDto();
        String username = "john_doe";
        usuarioDto.setUsername(username);
        String tipo = "admin";
        usuarioDto.setTipo(tipo);
        usuarioDto.setPersona(personaMock);
        long id = 1;
        usuarioDto.setId(id);

        when(personaMock.toString()).thenReturn("Persona");

        String expected = "UsuarioDto{" +
                "username='" + username + '\'' +
                ", tipo='" + tipo + '\'' +
                ", persona=Persona" +
                ", _id=" + id +
                '}';
        assertEquals(expected, usuarioDto.toString());
    }

}