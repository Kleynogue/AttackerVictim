package com.ucab.cmcapp.logic.commands.zona_punto.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.ZonaPunto;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByFullNameCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import com.ucab.cmcapp.persistence.dao.ZonaPuntoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetPuntosByZonaCommand extends Command<ZonaPunto>{

    private static Logger _logger = LoggerFactory.getLogger( GetPuntosByZonaCommand.class );
    private ZonaPunto zp;
    private List<ZonaPunto> result;
    private ZonaPuntoDao dao;


    public GetPuntosByZonaCommand(ZonaPunto zp, DBHandler handler){
        _logger.debug( String.format( "Get in GetPuntosByZonaCommand.ctor: parameter {%s}",
                zp.toString() ) );
        setHandler(handler);
        this.zp = zp;
        dao = DaoFactory.createZonaPuntoDao(getHandler());

        _logger.debug( String.format( "Leaving GetPuntosByZonaCommand.ctor: attribute {%s}",
                zp.toString() ) );

    }

    public GetPuntosByZonaCommand(ZonaPunto zp){
        _logger.debug( String.format( "Get in GetPuntosByZonaCommand.ctor: parameter {%s}",
                zp.toString() ) );
        setHandler(new DBHandler());
        this.zp = zp;
        dao = DaoFactory.createZonaPuntoDao(getHandler());

        _logger.debug( String.format( "Leaving GetPuntosByZonaCommand.ctor: attribute {%s}",
                zp.toString() ) );

    }

    @Override
    public void execute() throws IOException {
        _logger.debug( "Get in  GetPuntosByZonaCommand.execute" );

        result = dao.getPuntosByZona(zp.getZonPunFKZonaSeguridad());

        _logger.debug( "Leaving GetPuntosByZonaCommand.execute" );
    }

    @Override
    public List<ZonaPunto> getReturnParam() {
        return result;
    }
}
