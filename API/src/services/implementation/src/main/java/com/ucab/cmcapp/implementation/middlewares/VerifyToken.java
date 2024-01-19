package com.ucab.cmcapp.implementation.middlewares;

import com.ucab.cmcapp.common.exceptions.AuthorizationException;
import com.ucab.cmcapp.common.exceptions.JWTVerifyException;
import com.ucab.cmcapp.common.util.JWT;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

@Provider
public class VerifyToken implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;
    private static Logger _logger = LoggerFactory.getLogger( VerifyToken.class );
    //private String[] methods = {"/persona", "/usuario", "/querella", "/telefono", "/zona-seguridad", "/punto-geografico", "/historico-punto", "/zona-punto"};

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        try {

            Method method = resourceInfo.getResourceMethod();

            if(method.isAnnotationPresent(PermitAll.class)) return;

            String bearerHeader = requestContext.getHeaders().get("Authorization").toString();
            String bearerToken = bearerHeader.split(" ", 2)[1];
            UsuarioDto usuarioDto = JWT.verifyToken(bearerToken);
            _logger.debug(usuarioDto.toString());
            if(method.isAnnotationPresent(RolesAllowed.class) && requestContext.getMethod() != "" ){
                RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
                String[] roles = rolesAllowed.value();
                if (!Arrays.asList(roles).contains(usuarioDto.getTipo())){
                    throw new AuthorizationException("Usuario no autorizado");
                }
            }


        }catch (NullPointerException | AuthorizationException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED)
                       .entity("Validation error: " + e.getMessage())
                       .build());
        }catch (JWTVerifyException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("Validation error: " + e.getMessage())
                    .build());
        }catch (Exception e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity("Validation error: " + e.getMessage())
                       .build());
        }
    }
}
