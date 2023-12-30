package com.ucab.cmcapp.logic.commands.zona_seguridad.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class GetZonaSeguridadByNameCommand extends Command<ZonaSeguridad> {

    private static Logger _logger = LoggerFactory.getLogger( GetZonaSeguridadByNameCommand.class );
    private ZonaSeguridad zonaSeguridad;
    private ZonaSeguridadDao dao;



    public GetZonaSeguridadByNameCommand(ZonaSeguridad zonaSeguridad, DBHandler handler){
        _logger.debug( String.format( "Get in GetZonaSeguridadByNameCommand.ctor: parameter {%s}",
                zonaSeguridad.toString() ) );
        setHandler(handler);
        this.zonaSeguridad = zonaSeguridad;
        dao = DaoFactory.createZonaSeguridadDao(getHandler());

        _logger.debug( String.format( "Leaving GetZonaSeguridadByNameCommand.ctor: attribute {%s}",
                zonaSeguridad.toString() ) );

    }

    public GetZonaSeguridadByNameCommand(ZonaSeguridad zonaSeguridad){
        _logger.debug( String.format( "Get in GetZonaSeguridadNameCommand.ctor: parameter {%s}",
                zonaSeguridad.toString() ) );
        setHandler(new DBHandler());
        this.zonaSeguridad = zonaSeguridad;
        dao = DaoFactory.createZonaSeguridadDao(getHandler());

        _logger.debug( String.format( "Leaving GetZonaSeguridadNameCommand.ctor: attribute {%s}",
                zonaSeguridad.toString() ) );

    }

    @Override
    public void execute() throws IOException {

        _logger.debug( "Get in  GetZonaSeguridadByNameCommand.execute" );

        zonaSeguridad = dao.getZonaSeguridadByName(zonaSeguridad.getZonSegNombre());

        _logger.debug( "Leaving GetZonaSeguridadByNameCommand.execute" );

    }

    @Override
    public ZonaSeguridad getReturnParam() {
        return zonaSeguridad;
    }
}
