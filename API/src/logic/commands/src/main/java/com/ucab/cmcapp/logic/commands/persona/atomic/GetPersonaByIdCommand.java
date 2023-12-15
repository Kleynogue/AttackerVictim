package com.ucab.cmcapp.logic.commands.persona.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class GetPersonaByIdCommand extends Command<Persona> {

    private static Logger _logger = LoggerFactory.getLogger( GetPersonaByIdCommand.class );
    private long Id;
    private Persona result;
    private PersonaDao dao;


    public GetPersonaByIdCommand(long userId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetPersonaByIdCommand.ctor: parameter {%s}", userId ) );
        //endregion

        Id = userId;
        setHandler(new DBHandler());
        dao = DaoFactory.createPersonaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetPersonaByIdCommand.ctor: attribute {%s}", userId ) );
        //endregion
    }


    @Override
    public void execute(){
        _logger.debug( "Get in  GetUserByIdCommand.execute" );
        //endregion
        result = dao.find(Id, Persona.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetUserByIdCommand.execute" );
    }

    @Override
    public Persona getReturnParam() {
        return result;
    }
}
