package com.ucab.cmcapp.logic.commands.telefono.atomic;

import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.TelefonoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetTelefonosByQuerellaCommand extends Command<Telefono> {

    private static Logger _logger = LoggerFactory.getLogger( GetTelefonosByQuerellaCommand.class );
    private Telefono telefono;
    private List<Telefono> telefonos;
    private TelefonoDao dao;


    public GetTelefonosByQuerellaCommand(Telefono telefono, DBHandler handler){
        _logger.debug( String.format( "Get in GetTelefonosByQuerellaCommand.ctor: parameter {%s}",
                telefono.toString() ) );
        setHandler(handler);
        this.telefono = telefono;
        dao = DaoFactory.createTelefonoDao(getHandler());

        _logger.debug( String.format( "Leaving GetTelefonosByQuerellaCommand.ctor: attribute {%s}",
                telefono.toString() ) );

    }

    public GetTelefonosByQuerellaCommand(Telefono telefono){
        _logger.debug( String.format( "Get in GetTelefonosByQuerellaCommand.ctor: parameter {%s}",
                telefono.toString() ) );
        setHandler(new DBHandler());
        this.telefono = telefono;
        dao = DaoFactory.createTelefonoDao(getHandler());

        _logger.debug( String.format( "Leaving GetTelefonosByQuerellaCommand.ctor: attribute {%s}",
                telefono.toString() ) );

    }

    @Override
    public void execute() throws IOException {
        _logger.debug( "Get in GetTelefonosByQuerellaCommand.execute" );

        telefonos = dao.getTelefonosByQuerella(telefono.getTeleFKQuerella());

        _logger.debug( "Leaving GetTelefonosByQuerellaCommand.execute" );
    }

    @Override
    public List<Telefono> getReturnParam() {
        return telefonos;
    }
}
