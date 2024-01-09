package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.common.exceptions.NotFoundException;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.conexion.atomic.GetConnectionsByPhoneCommand;
import com.ucab.cmcapp.logic.commands.movimiento.atomic.GetMovesByDateCommand;
import com.ucab.cmcapp.logic.commands.movimiento.atomic.GetMovesByPhoneCommand;
import com.ucab.cmcapp.logic.dtos.ConexionDto;
import com.ucab.cmcapp.logic.dtos.MovimientoDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.ConexionMapper;
import com.ucab.cmcapp.logic.mappers.MovimientoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/query/movimiento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovimientoQueryService extends BaseService {

    private static Logger _logger = LoggerFactory.getLogger( MovimientoQueryService.class );

    @Path("/1")
    @GET
    @RolesAllowed({"Administrador"})
    public List<MovimientoDto> getMovesByDate(@QueryParam("date") String date){
        List<MovimientoDto> response;
        Movimiento movimiento = new Movimiento();
        GetMovesByDateCommand command;
        MovimientoMapper mapper = new MovimientoMapper();

        _logger.debug( "Get in MovimientoQueryService.getMovesByDate" );

        try {
            movimiento.setMoviFecha(BaseMapper.parseStringToDate(date));
            command = CommandFactory.createGetMovesByDateCommand(movimiento);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());

        }catch (NotFoundException e){
            _logger.error("error {} getting movimientos {}: {}", e.getMessage(), date, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.NOT_FOUND ).
                    entity( e ).build() );
        }catch (Exception e){
            _logger.error("error {} getting movimientos {}: {}", e.getMessage(), date, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving MovimientoQueryService.getMovesByDate" );
        return response;

    }

    @Path("/2")
    @GET
    @RolesAllowed({"Administrador", "Victima"})
    public List<MovimientoDto> getMovesByPhone(@QueryParam("phone") long phoneID){

        List<MovimientoDto> response;
        Movimiento movimiento = new Movimiento();
        MovimientoMapper mapper = new MovimientoMapper();
        Telefono telefono = new Telefono(phoneID);
        GetMovesByPhoneCommand command;
        movimiento.setMoviFKTelefono(telefono);

        _logger.debug( "Get in MovimientoQueryService.getMovesByPhone" );

        try {
            command = CommandFactory.createGetMovesByPhoneCommand(movimiento);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (NotFoundException e){
            _logger.error("error {} getting movimientos of {}: {}", e.getMessage(), phoneID, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.NOT_FOUND ).
                    entity( e ).build() );
        }catch (Exception e){
            _logger.error("error {} getting movimientos of {}: {}", e.getMessage(), phoneID, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving MovimientoQueryService.getMovesByPhone" );
        return response;
    }

}
