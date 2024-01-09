package com.ucab.cmcapp.implementation.middlewares;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.util.Date;

@Provider
@PreMatching
public class RequestLogger implements ContainerRequestFilter {

    private static final Logger _logger = LoggerFactory.getLogger( RequestLogger.class );

    @Context
    HttpServletRequest request;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String ip = request.getRemoteAddr();
        Date date = new Date();
        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();
        String client = requestContext.getHeaders().get("User-Agent").toString();
        _logger.debug("{} --  [{}] {} {} {}", ip, date, method, path, client);
    }
}
