import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.ucab.cmcapp.logic.dtos.PersonaDto;

public class PersonaDtoTest {

    @Test
    public void testConstructor(){
        PersonaDto personaDto = new PersonaDto(1);
        assertEquals(1, personaDto.getId());
    }

    @Test
    public void testGetSetName() {
        PersonaDto personaDto = new PersonaDto();
        String name = "John";
        personaDto.setName(name);
        assertEquals(name, personaDto.getName());
    }

    @Test
    public void testGetSetLastName() {
        PersonaDto personaDto = new PersonaDto();
        String lastName = "Doe";
        personaDto.setLastName(lastName);
        assertEquals(lastName, personaDto.getLastName());
    }

    @Test
    public void testGetSetAddress() {
        PersonaDto personaDto = new PersonaDto();
        String address = "123 Main St";
        personaDto.setAddress(address);
        assertEquals(address, personaDto.getAddress());
    }

    @Test
    public void testToString() {
        PersonaDto personaDto = new PersonaDto();
        String name = "John";
        personaDto.setName(name);
        String lastName = "Doe";
        personaDto.setLastName(lastName);
        String address = "123 Main St";
        personaDto.setAddress(address);
        long id = 1;
        personaDto.setId(id);
        String expected = "PersonaDto{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", _id=" + id +
                '}';
        assertEquals(expected, personaDto.toString());
    }

}