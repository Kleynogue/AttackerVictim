package com.ucab.cmcapp.logic.commands.telefono.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByFullNameCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import com.ucab.cmcapp.persistence.dao.TelefonoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class GetTelefonoByBluetoothCommand extends Command<Telefono> {

    private static Logger _logger = LoggerFactory.getLogger( GetTelefonoByBluetoothCommand.class );
    private Telefono telefono;
    private TelefonoDao dao;


    public GetTelefonoByBluetoothCommand(Telefono telefono, DBHandler handler){
        _logger.debug( String.format( "Get in GetTelefonoByBluetoothCommand.ctor: parameter {%s}",
                telefono.toString() ) );
        setHandler(handler);
        this.telefono = telefono;
        dao = DaoFactory.createTelefonoDao(getHandler());

        _logger.debug( String.format( "Leaving GetTelefonoByBluetoothCommand.ctor: attribute {%s}",
                telefono.toString() ) );

    }

    public GetTelefonoByBluetoothCommand(Telefono telefono){
        _logger.debug( String.format( "Get in GetTelefonoByBluetoothCommand.ctor: parameter {%s}",
                telefono.toString() ) );
        setHandler(new DBHandler());
        this.telefono = telefono;
        dao = DaoFactory.createTelefonoDao(getHandler());

        _logger.debug( String.format( "Leaving GetTelefonoByBluetoothCommand.ctor: attribute {%s}",
                telefono.toString() ) );

    }

    @Override
    public void execute() throws IOException {
        _logger.debug( "Get in  GetTelefonoByBluetoothCommand.execute" );

        telefono = dao.getTelefonoByBluetooth(telefono.getTeleBluetooth());

        _logger.debug( "Leaving GetTelefonoByBluetoothCommand.execute" );
    }

    @Override
    public Telefono getReturnParam() {
        return telefono;
    }
}
