import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.common.EntityFactory;

public class EntityFactoryTest {

    @Test
    public void testCreatePersona() {
        Persona persona = EntityFactory.createPersona();
        Assertions.assertNotNull(persona);
    }

    @Test
    public void testCreatePersonaWithId() {
        long id = 1L;
        Persona persona = EntityFactory.createPersona(id);
        Assertions.assertEquals(id, persona.getPersID());
    }

    @Test
    public void testCreateUsuario() {
        Usuario usuario = EntityFactory.createUsuario();
        Assertions.assertNotNull(usuario);
    }

    @Test
    public void testCreateUsuarioWithId() {
        long id = 1L;
        Usuario usuario = EntityFactory.createUsuario(id);
        Assertions.assertEquals(id, usuario.getUsuaID());
    }

    @Test
    public void testCreateQuerella() {
        Querella querella = EntityFactory.createQuerella();
        Assertions.assertNotNull(querella);
    }

    @Test
    public void testCreateQuerellaWithId() {
        long id = 1L;
        Querella querella = EntityFactory.createQuerella(id);
        Assertions.assertEquals(id, querella.getQuerID());
    }

    @Test
    public void testCreateTelefono() {
        Telefono telefono = EntityFactory.createTelefono();
        Assertions.assertNotNull(telefono);
    }

    @Test
    public void testCreateTelefonoWithId() {
        long id = 1L;
        Telefono telefono = EntityFactory.createTelefono(id);
        Assertions.assertEquals(id, telefono.getTeleID());
    }

    @Test
    public void testCreateZonaSeguridad() {
        ZonaSeguridad zonaSeguridad = EntityFactory.createZonaSeguridad();
        Assertions.assertNotNull(zonaSeguridad);
    }

    @Test
    public void testCreateZonaSeguridadWithId() {
        long id = 1L;
        ZonaSeguridad zonaSeguridad = EntityFactory.createZonaSeguridad(id);
        Assertions.assertEquals(id, zonaSeguridad.getZonSegID());
    }

    @Test
    public void testCreatePuntoGeografico() {
        PuntoGeografico puntoGeografico = EntityFactory.createPuntoGeografico();
        Assertions.assertNotNull(puntoGeografico);
    }

    @Test
    public void testCreatePuntoGeograficoWithId() {
        long id = 1L;
        PuntoGeografico puntoGeografico = EntityFactory.createPuntoGeografico(id);
        Assertions.assertEquals(id, puntoGeografico.getPunGeoID());
    }

    @Test
    public void testCreateConexion() {
        Conexion conexion = EntityFactory.createConexion();
        Assertions.assertNotNull(conexion);
    }

    @Test
    public void testCreateConexionWithId() {
        long id = 1L;
        Conexion conexion = EntityFactory.createConexion(id);
        Assertions.assertEquals(id, conexion.getConeID());
    }

    @Test
    public void testCreateMovimiento() {
        Movimiento movimiento = EntityFactory.createMovimiento();
        Assertions.assertNotNull(movimiento);
    }

    @Test
    public void testCreateMovimientoWithId() {
        long id = 1L;
        Movimiento movimiento = EntityFactory.createMovimiento(id);
        Assertions.assertEquals(id, movimiento.getMoviID());
    }

    @Test
    public void testCreateReporte() {
        Reporte reporte = EntityFactory.createReporte();
        Assertions.assertNotNull(reporte);
    }

    @Test
    public void testCreateReporteWithId() {
        long id = 1L;
        Reporte reporte = EntityFactory.createReporte(id);
        Assertions.assertEquals(id, reporte.getRepoID());
    }

    @Test
    public void testCreateHistoricoPunto() {
        HistoricoPunto historicoPunto = EntityFactory.createHistoricoPunto();
        Assertions.assertNotNull(historicoPunto);
    }

    @Test
    public void testCreateHistoricoPuntoWithId() {
        long id = 1L;
        HistoricoPunto historicoPunto = EntityFactory.createHistoricoPunto(id);
        Assertions.assertEquals(id, historicoPunto.getHistPunID());
    }

    @Test
    public void testCreateZonaPuntoWithoutArguments() {
        ZonaPunto zonaPunto = EntityFactory.createZonaPunto();
        Assertions.assertNotNull(zonaPunto);
    }

    @Test
    public void testCreateZonaPunto() {
        PuntoGeografico puntoGeografico = new PuntoGeografico();
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        ZonaPunto zonaPunto = EntityFactory.createZonaPunto(puntoGeografico, zonaSeguridad);
        Assertions.assertEquals(puntoGeografico, zonaPunto.getZonPunFKPuntoGeografico());
        Assertions.assertEquals(zonaSeguridad, zonaPunto.getZonPunFKZonaSeguridad());
    }
}