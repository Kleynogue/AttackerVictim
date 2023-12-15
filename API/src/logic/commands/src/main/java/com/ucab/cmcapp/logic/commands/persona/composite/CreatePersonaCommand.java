package com.ucab.cmcapp.logic.commands.persona.composite;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.persona.atomic.AddPersonaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CreatePersonaCommand extends Command<Persona> {

    private static Logger _logger = LoggerFactory.getLogger( CreatePersonaCommand.class );
    private Persona persona;
    private Persona result;

    AddPersonaCommand addPersonaCommand;


    public CreatePersonaCommand(Persona persona, DBHandler handler){
        _logger.debug( String.format( "Get in CreatePersonaCommand.ctor: parameter {%s}",
                persona.toString() ) );
        setHandler(handler);
        this.persona = persona;

        _logger.debug( String.format( "Leaving CreatePersonaCommand.ctor: attribute {%s}",
                persona.toString() ) );
    }

    public CreatePersonaCommand(Persona persona){
        _logger.debug( String.format( "Get in CreatePersonaCommand.ctor: parameter {%s}",
                persona.toString() ) );
        setHandler(new DBHandler());
        this.persona = persona;

        _logger.debug( String.format( "Leaving CreatePersonaCommand.ctor: attribute {%s}",
                persona.toString() ) );
    }


    @Override
    public void execute(){
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreatePersonaCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            addPersonaCommand = CommandFactory.createAddPersonaCommand(persona, getHandler());
            addPersonaCommand.execute();
            result = addPersonaCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateUserCommand.execute");
        //endregion
    }

    @Override
    public Persona getReturnParam() {
        return result;
    }
}
