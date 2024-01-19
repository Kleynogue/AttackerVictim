import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.ucab.cmcapp.logic.dtos.QuerellaDto;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ZonaSeguridadDtoTest {

    @Mock
    QuerellaDto querellaMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructor() {
        long id = 1;
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto(id);
        assertEquals(id, zonaSeguridadDto.getId());
    }


    @Test
    public void testGetSetName() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        String name = "Zona 1";
        zonaSeguridadDto.setName(name);
        assertEquals(name, zonaSeguridadDto.getName());
    }

    @Test
    public void testGetSetQuerella() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        zonaSeguridadDto.setQuerella(querellaMock);
        assertEquals(querellaMock, zonaSeguridadDto.getQuerella());
    }

    @Test
    public void testToString() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        String name = "Zona 1";
        zonaSeguridadDto.setName(name);
        zonaSeguridadDto.setQuerella(querellaMock);
        long id = 1;
        zonaSeguridadDto.setId(id);

        when(querellaMock.toString()).thenReturn("Querella");

        String expected = "ZonaSeguridadDto{" +
                "name='" + name + '\'' +
                ", querella=Querella" +
                ", _id=" + id +
                '}';
        assertEquals(expected, zonaSeguridadDto.toString());
    }
}