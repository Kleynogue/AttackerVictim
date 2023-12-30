package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.movimiento.atomic.GetMovesByDateCommand;
import com.ucab.cmcapp.logic.dtos.MovimientoDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.MovimientoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @GET
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

        }catch (Exception e){
            _logger.error("error {} getting movimientos {}: {}", e.getMessage(), date, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving MovimientoQueryService.getMovesByDate" );
        return response;

    }

}
