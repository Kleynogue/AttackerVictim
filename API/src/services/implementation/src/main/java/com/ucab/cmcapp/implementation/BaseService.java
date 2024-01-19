package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.exceptions.JWTVerifyException;
import com.ucab.cmcapp.common.exceptions.JsonValidationException;
import com.ucab.cmcapp.common.util.JWT;
import com.ucab.cmcapp.implementation.control.AuthenticationService;
import com.ucab.cmcapp.implementation.crud.*;
import com.ucab.cmcapp.implementation.middlewares.Cors;
import com.ucab.cmcapp.implementation.middlewares.RequestLogger;
import com.ucab.cmcapp.implementation.middlewares.VerifyToken;
import com.ucab.cmcapp.implementation.queries.*;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath( "/api/v1" )
public class BaseService extends Application
{
    private static Logger _logger = LoggerFactory.getLogger( BaseService.class );



    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> resources = new HashSet<>();

        // Endpoints de crud para cada entidad.

        resources.add(ConexionService.class);
        resources.add(HistoricoPuntoService.class);
        resources.add(MovimientoService.class);
        resources.add(PersonaService.class);
        resources.add(PuntoGeograficoService.class);
        resources.add(QuerellaService.class);
        resources.add(ReporteService.class);
        resources.add(TelefonoService.class);
        resources.add(UsuarioService.class);
        resources.add(ZonaPuntoService.class);
        resources.add(ZonaSeguridadService.class);

        // Endpoints de queries de cada entidad.

        resources.add(ConexionQueryService.class);
        resources.add(HistoricoPuntoQueryService.class);
        resources.add(MovimientoQueryService.class);
        resources.add(PersonaQueryService.class);
        resources.add(QuerellaQueryService.class);
        resources.add(ReporteQueryService.class);
        resources.add(TelefonoQueryService.class);
        resources.add(UsuarioQueryService.class);
        resources.add(ZonaPuntoQueryService.class);
        resources.add(ZonaSeguridadQueryService.class);

        // Endpoints de control

        resources.add(AuthenticationService.class);

        //Middlewares de la API
        resources.add(RequestLogger.class);
        //resources.add(VerifyToken.class);
        resources.add(Cors.class);

        return resources;
    }

    /**
     * Metodo que valida que el parametro proveido al servicio no sea nulo
     * @param object parametro que fue enviado al servicio
     */
    void verifyParams( Object object )
    {
        if ( object == null )
            throwException( Response.Status.BAD_REQUEST );
    }

    /**
     * Metodo para enviar un exceiption unicamente con el estado
     * @param status estado HTTP de error a informar
     */
    void throwException( Response.Status status )
    {
        throw new WebApplicationException( Response.status( status ).build() );
    }

    /**
     * Metodo para enviar exceptions personalizadas al usuario
     * @param status estado HTTP de error a  informar
     * @param e Exception a mostrar
     */
    void throwException( Exception e, Response.Status status )
    {
        _logger.error(e.getMessage(), e);
        throw new WebApplicationException( Response.status( status ).entity( e ).build() );
    }


    protected void validateFields(Object obj) throws IllegalAccessException, JsonValidationException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (value == null) {
                throw new JsonValidationException("Field '" + field.getName() + "' has a null value.");
            }
        }
    }
}
