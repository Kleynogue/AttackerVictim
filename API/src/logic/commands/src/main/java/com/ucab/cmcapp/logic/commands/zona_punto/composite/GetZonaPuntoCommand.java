package com.ucab.cmcapp.logic.commands.zona_punto.composite;

import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.common.entities.ZonaPunto;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.commands.zona_punto.atomic.GetPuntosByZonaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetZonaPuntoCommand extends Command<ZonaPunto> {

    private static Logger _logger = LoggerFactory.getLogger( GetZonaPuntoCommand.class );
    private ZonaPunto zp;
    private ZonaSeguridad zs;
    private List<ZonaPunto> result;
    private PuntoGeografico pg;


    public GetZonaPuntoCommand( ZonaPunto zp )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetZonaPuntoCommand.ctor: parameter {%s}",
                zp.toString() ) );
        this.zp = zp;
        zs = zp.getZonPunFKZonaSeguridad();
        pg = zp.getZonPunFKPuntoGeografico();
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetZonaPuntoCommand.ctor: attribute {%s}",
                zp.toString() ) );
        //endregion
    }

    @Override
    public void execute() throws IOException {
        try
        {
            GetPuntosByZonaCommand getPuntosByZonaCommand = CommandFactory.createGetPuntosByZonaCommand(zp);
            getPuntosByZonaCommand.execute();
            result = getPuntosByZonaCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Object getReturnParam() {
        return result;
    }
}
