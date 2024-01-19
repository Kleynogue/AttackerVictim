package com.ucab.cmcapp.implementation.control;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.exceptions.AuthenticationException;
import com.ucab.cmcapp.common.exceptions.JsonValidationException;
import com.ucab.cmcapp.common.exceptions.NotFoundException;
import com.ucab.cmcapp.common.util.JWT;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.implementation.utils.Credentials;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByUsernameCommand;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationService extends BaseService{

    private static Logger _logger = LoggerFactory.getLogger( AuthenticationService.class );

    @POST
    @PermitAll
    public Response authenticate(Credentials credentials){
        GetUsuarioByUsernameCommand command;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AuthenticationService.authenticate" );
        //endregion

        try {
            validateJson(credentials);
            Usuario usuario = new Usuario();
            usuario.setUsuaUsername(credentials.getUsername());
            command = CommandFactory.createGetUsuarioByUsernameCommand(usuario);
            command.execute();
            Usuario foundUser = command.getReturnParam();
            UsuarioMapper mapper = new UsuarioMapper();
            if(credentials.getPassword().equals(foundUser.getUsuaContrasena())){
                String token = JWT.createToken(mapper.mapEntityToDto(foundUser));
                return Response.ok().header("Authorization", "Bearer " + token).build();
            }else{
                throw new AuthenticationException("Contraseña incorrecta");
            }
        }catch (JsonValidationException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("Validation error: " + e.getMessage())
                    .build());
        }catch (AuthenticationException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.FORBIDDEN)
                    .entity("Validation error: " + e.getMessage())
                    .build());
        }catch (NotFoundException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Validation error: " + e.getMessage())
                    .build());
        }catch (Exception e){
            _logger.error("error {} authenticating user {}: {}", e.getMessage(), credentials.getUsername(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
    }

    private void validateJson(Credentials credentials) throws JsonValidationException {
        try {
            validateFields(credentials);
        } catch (IllegalAccessException e) {
            throw new JsonValidationException("Error accessing fields: " + e.getMessage());
        }
    }

}
