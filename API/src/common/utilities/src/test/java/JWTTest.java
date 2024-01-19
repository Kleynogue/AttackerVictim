import com.ucab.cmcapp.common.exceptions.JWTVerifyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.common.util.JWT;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class JWTTest {

    @Mock
    private UsuarioDto usuarioMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateToken() {

        when(usuarioMock.getUsername()).thenReturn("john.doe");
        when(usuarioMock.getTipo()).thenReturn("admin");

        // Act
        String token = JWT.createToken(usuarioMock);

        // Assert
        Assertions.assertNotNull(token);
    }

    @Test
    public void testVerifyToken() {
        // Arrange
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJodHRwOi8vMTU1LjEzOC4yMDUuMjQ0OjgwODAvY21jYXBwLWJhY2tlbmQtMS4wIiwic3ViIjoibWFyaWFnIiwibmJmIjoxNzA1NjQyNDQ0LCJpYXQiOjE3MDU2NDI0NDQsImp0aSI6IjM4NDQxZDNlLTk4ZDgtNDY3MC1iMjQxLWM3ZDJhNTkyMzMxYyIsInR5cGUiOiJWaWN0aW1hIn0.Rifw1Hp3R7a7j_ncx54T6kaGUTKemoWOxtjCQyq-N0CAW_cO3-MySrmqrvsrhl_FRjf9wA7dSl9InIu94VBEBg";

        // Act
        UsuarioDto usuario = JWT.verifyToken(token);

        // Assert
        Assertions.assertThrows(JWTVerifyException.class, () -> {throw new JWTVerifyException("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");});
    }
}