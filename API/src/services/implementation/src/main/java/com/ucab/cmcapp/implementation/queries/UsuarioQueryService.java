package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByUsernameCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuariosByTypeCommand;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/query/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioQueryService extends BaseService{

    private static Logger _logger = LoggerFactory.getLogger( UsuarioQueryService.class );

    @Path("/1")
    @GET
    public UsuarioDto getUsuarioByUsername(@QueryParam("username") String username){
        UsuarioDto response;
        Usuario usuario = new Usuario();
        usuario.setUsuaUsername(username);
        GetUsuarioByUsernameCommand command;
        UsuarioMapper mapper = new UsuarioMapper();

        _logger.debug( "Get in UsuarioQueryService.getUsuarioByUsername" );

        try {
            command = CommandFactory.createGetUsuarioByUsernameCommand(usuario);
            command.execute();
            response = mapper.mapEntityToDto(command.getReturnParam());
        }catch (Exception e){
            _logger.error("error {} getting usuario {}: {}", e.getMessage(), username, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving UsuarioQueryService.getUsuarioByUsername" );
        return response;
    }

    @Path("/2")
    @GET
    public List<UsuarioDto> getUsuariosByType(@QueryParam("type") String type){
        List<UsuarioDto> response;
        GetUsuariosByTypeCommand command;
        UsuarioMapper mapper = new UsuarioMapper();

        _logger.debug( "Get in UsuarioQueryService.getUsuariosByType" );

        try {
            command = CommandFactory.createGetUsuariosByTypeCommand(type);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (Exception e){
            _logger.error("error {} getting usuarios {}: {}", e.getMessage(), type, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving UsuarioQueryService.getUsuariosByType" );
        return response;

    }
}
