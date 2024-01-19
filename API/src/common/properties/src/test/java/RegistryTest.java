import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.ucab.cmcapp.properties.Registry;


public class RegistryTest {


    @Test
    public void testGetProperty() {
        Registry registry = Registry.getInstance();
        String property = registry.getProperty("config.db.unit");
        assertEquals("cmcapp-test", property);
    }
}
