package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.common.exceptions.NotFoundException;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.conexion.atomic.GetConnectionsByDateCommand;
import com.ucab.cmcapp.logic.commands.conexion.atomic.GetConnectionsByPhoneCommand;
import com.ucab.cmcapp.logic.commands.reporte.atomic.GetReportsByDateCommand;
import com.ucab.cmcapp.logic.dtos.ConexionDto;
import com.ucab.cmcapp.logic.dtos.ReporteDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.ConexionMapper;
import com.ucab.cmcapp.logic.mappers.ReporteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/query/conexion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConexionQueryService extends BaseService{

    private static Logger _logger = LoggerFactory.getLogger( ConexionQueryService.class );

    @Path("/1")
    @GET
    @RolesAllowed({"Administrador"})
    public List<ConexionDto> getConnectionsByDate(@QueryParam("date") String date){
        List<ConexionDto> response;
        Conexion conexion = new Conexion();
        GetConnectionsByDateCommand command;
        ConexionMapper mapper = new ConexionMapper();

        _logger.debug( "Get in ConexionQueryService.getConnectionsByDate" );

        try {
            conexion.setConeFecha(BaseMapper.parseStringToDate(date));
            command = CommandFactory.createGetConnectionsByDateCommand(conexion);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (NotFoundException e){
            _logger.error("error {} getting conexiones {}: {}", e.getMessage(), date, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.NOT_FOUND ).
                    entity( e ).build() );
        }catch (Exception e){
            _logger.error("error {} getting conexiones {}: {}", e.getMessage(), date, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving ConexionQueryService.getConnectionsByDate" );
        return response;
    }

    @Path("/2")
    @GET
    @RolesAllowed({"Administrador", "Victima"})
    public List<ConexionDto> getConnectionsByPhone(@QueryParam("phone") long phoneID){

        List<ConexionDto> response;
        Conexion conexion = new Conexion();
        ConexionMapper mapper = new ConexionMapper();
        Telefono telefono = new Telefono(phoneID);
        GetConnectionsByPhoneCommand command;
        conexion.setConeFKTelefono(telefono);

        _logger.debug( "Get in ConexionQueryService.getConnectionsByPhone" );

        try {
            command = CommandFactory.createGetConnectionsByPhoneCommand(conexion);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (NotFoundException e){
            _logger.error("error {} getting conexiones of {}: {}", e.getMessage(), phoneID, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.NOT_FOUND).
                    entity( e ).build() );
        }catch (Exception e){
            _logger.error("error {} getting conexiones of {}: {}", e.getMessage(), phoneID, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving ConexionQueryService.getConnectionsByPhone" );
        return response;
    }

}
