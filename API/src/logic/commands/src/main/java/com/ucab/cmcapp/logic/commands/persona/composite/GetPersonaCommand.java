package com.ucab.cmcapp.logic.commands.persona.composite;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetPersonaCommand extends Command<Persona> {

    private static Logger _logger = LoggerFactory.getLogger( GetPersonaCommand.class );
    private Persona persona;
    long id;


    public GetPersonaCommand( Persona persona )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetPersonaCommand.ctor: parameter {%s}",
                persona.toString() ) );
        id = persona.getPersID();
        this.persona = persona;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetPersonaCommand.ctor: attribute {%s}",
                persona) );
        //endregion
    }

    @Override
    public void execute(){
        try
        {
            GetPersonaByIdCommand getPersonaByIdCommand = CommandFactory.createGetPersonaByIdCommand(id);
            getPersonaByIdCommand.execute();
            persona = getPersonaByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Persona getReturnParam() {
        return persona;
    }
}
