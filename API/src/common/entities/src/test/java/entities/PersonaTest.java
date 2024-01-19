package entities;

import com.ucab.cmcapp.common.entities.Persona;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonaTest {

    @Test
    public void testGetPersID() {
        long persID = 1L;
        Persona persona = new Persona();
        persona.setPersID(persID);
        assertEquals(persID, persona.getPersID());
    }

    @Test
    public void testGetPersNombre() {
        String persNombre = "John";
        Persona persona = new Persona();
        persona.setPersNombre(persNombre);
        assertEquals(persNombre, persona.getPersNombre());
    }

    @Test
    public void testGetPersApellido() {
        String persApellido = "Doe";
        Persona persona = new Persona();
        persona.setPersApellido(persApellido);
        assertEquals(persApellido, persona.getPersApellido());
    }

    @Test
    public void testGetPersDireccion() {
        String persDireccion = "123 Main St";
        Persona persona = new Persona();
        persona.setPersDireccion(persDireccion);
        assertEquals(persDireccion, persona.getPersDireccion());
    }

    @Test
    public void testConstructor() {
        long persID = 1L;
        Persona persona = new Persona(persID);
        assertEquals(persID, persona.getPersID());
    }

    @Test
    public void testToString() {
        long persID = 1L;
        String persNombre = "John";
        String persApellido = "Doe";
        String persDireccion = "123 Main St";

        Persona persona = new Persona();
        persona.setPersID(persID);
        persona.setPersNombre(persNombre);
        persona.setPersApellido(persApellido);
        persona.setPersDireccion(persDireccion);

        String expected = "Persona{" +
                "persID=" + persID +
                ", persNombre='" + persNombre + '\'' +
                ", persApellido='" + persApellido + '\'' +
                ", persDireccion='" + persDireccion + '\'' +
                '}';
        assertEquals(expected, persona.toString());
    }
}