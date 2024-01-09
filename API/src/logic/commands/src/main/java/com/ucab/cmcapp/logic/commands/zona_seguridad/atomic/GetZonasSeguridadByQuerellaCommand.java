package com.ucab.cmcapp.logic.commands.zona_seguridad.atomic;

import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.reporte.atomic.GetReportsByPhoneCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ReporteDao;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetZonasSeguridadByQuerellaCommand extends Command<ZonaSeguridad>{

    private static Logger _logger = LoggerFactory.getLogger( GetZonasSeguridadByQuerellaCommand.class );
    private ZonaSeguridad zonaSeguridad;
    private List<ZonaSeguridad> result;
    private ZonaSeguridadDao dao;


    public GetZonasSeguridadByQuerellaCommand(ZonaSeguridad zonaSeguridad, DBHandler handler){
        _logger.debug( String.format( "Get in GetZonasSeguridadByQuerellaCommand.ctor: parameter {%s}",
                zonaSeguridad.toString() ) );
        setHandler(handler);
        this.zonaSeguridad = zonaSeguridad;
        dao = DaoFactory.createZonaSeguridadDao(getHandler());

        _logger.debug( String.format( "Leaving GetZonasSeguridadByQuerellaCommand.ctor: attribute {%s}",
                zonaSeguridad.toString() ) );

    }

    public GetZonasSeguridadByQuerellaCommand(ZonaSeguridad zonaSeguridad){
        _logger.debug( String.format( "Get in GetZonasSeguridadByQuerellaCommand.ctor: parameter {%s}",
                zonaSeguridad.toString() ) );
        setHandler(new DBHandler());
        this.zonaSeguridad = zonaSeguridad;
        dao = DaoFactory.createZonaSeguridadDao(getHandler());

        _logger.debug( String.format( "Leaving GetZonasSeguridadByQuerellaCommand.ctor: attribute {%s}",
                zonaSeguridad.toString() ) );

    }

    @Override
    public void execute() throws IOException {
        _logger.debug( "Get in  GetZonasSeguridadByQuerellaCommand.execute" );

        result = dao.getZonasSeguridadByQuerella(zonaSeguridad.getZonSegFKQuerella());

        _logger.debug( "Leaving GetZonasSeguridadByQuerellaCommand.execute" );
    }

    @Override
    public List<ZonaSeguridad> getReturnParam() {
        return result;
    }
}
