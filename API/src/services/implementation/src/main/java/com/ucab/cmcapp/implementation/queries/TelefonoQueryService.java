package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.telefono.atomic.GetTelefonoByBluetoothCommand;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import com.ucab.cmcapp.logic.mappers.TelefonoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/query/telefono")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TelefonoQueryService extends BaseService {

    private static Logger _logger = LoggerFactory.getLogger( TelefonoQueryService.class );

    @GET
    public TelefonoDto getTelefonoByBluetooth(@QueryParam("bluetooth") String bluetooth){

        TelefonoDto response;
        GetTelefonoByBluetoothCommand command;
        Telefono telefono = new Telefono();
        telefono.setTeleBluetooth(bluetooth);
        TelefonoMapper mapper = new TelefonoMapper();

        _logger.debug( "Get in TelefonoQueryService.getTelefonoByBluetooth" );

        try {
            command = CommandFactory.createGetTelefonoByBluetoothCommand(telefono);
            command.execute();
            response = mapper.mapEntityToDto(command.getReturnParam());
        }catch (Exception e){
            _logger.error("error {} getting telefono {}: {}", e.getMessage(), bluetooth, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving TelefonoQueryService.getTelefonoByBluetooth" );
        return response;
    }

}
