package com.ucab.cmcapp.logic.commands.persona.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AddPersonaCommand extends Command<Persona> {

    private static Logger _logger = LoggerFactory.getLogger( AddPersonaCommand.class );
    private Persona persona;
    private PersonaDao dao;


    public AddPersonaCommand(Persona persona, DBHandler handler) {
        _logger.debug( String.format( "Get in AddUserCommand.ctor: parameter {%s}",
                persona.toString() ) );
        setHandler(handler);
        this.persona = persona;
        dao = DaoFactory.createPersonaDao(getHandler());

        _logger.debug( String.format( "Leaving AddUserCommand.ctor: attribute {%s}",
                persona.toString() ) );
    }

    public AddPersonaCommand(Persona persona) {
        _logger.debug( String.format( "Get in AddUserCommand.ctor: parameter {%s}",
                persona.toString() ) );
        setHandler(new DBHandler());
        this.persona = persona;
        dao = DaoFactory.createPersonaDao(getHandler());

        _logger.debug( String.format( "Leaving AddUserCommand.ctor: attribute {%s}",
                persona.toString() ) );
    }

    @Override
    public void execute(){
        _logger.debug( "Get in  AddUserCommand.execute" );

        persona = dao.insert(persona);

        _logger.debug( "Leaving AddUserCommand.execute" );
    }

    @Override
    public Persona getReturnParam() {
        return persona;
    }
}
