package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historico_punto.atomic.GetHistoryByPhoneCommand;
import com.ucab.cmcapp.logic.dtos.HistoricoPuntoDto;
import com.ucab.cmcapp.logic.mappers.HistoricoPuntoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/query/historico-punto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoricoPuntoQueryService extends BaseService{

    private static Logger _logger = LoggerFactory.getLogger( HistoricoPuntoQueryService.class );

    @GET
    public List<HistoricoPuntoDto> getHistoryByPhone(@QueryParam("phone") long phoneID){

        List<HistoricoPuntoDto> response;
        HistoricoPunto historicoPunto = new HistoricoPunto();
        Telefono telefono = new Telefono(phoneID);
        HistoricoPuntoMapper mapper = new HistoricoPuntoMapper();
        GetHistoryByPhoneCommand command;
        historicoPunto.setHistPunFKTelefono(telefono);

        _logger.debug( "Get in HistoricoPuntoQueryService.getHistoryByPhone" );

        try {
            command = CommandFactory.createGetHistoryByPhoneCommand(historicoPunto);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (Exception e){
            _logger.error("error {} getting historico from telefono {}: {}", e.getMessage(), phoneID, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving HistoricoPuntoQueryService.getHistoryByPhone" );
        return response;

    }

}
