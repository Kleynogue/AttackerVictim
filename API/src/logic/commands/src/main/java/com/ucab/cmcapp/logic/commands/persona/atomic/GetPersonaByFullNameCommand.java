package com.ucab.cmcapp.logic.commands.persona.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetPersonaByFullNameCommand extends Command<Persona> {

    private static Logger _logger = LoggerFactory.getLogger( GetPersonaByFullNameCommand.class );
    private Persona persona;
    private PersonaDao dao;


    public GetPersonaByFullNameCommand(Persona persona, DBHandler handler){
        _logger.debug( String.format( "Get in getPersonaByFullName.ctor: parameter {%s}",
                persona.toString() ) );
        setHandler(handler);
        this.persona = persona;
        dao = DaoFactory.createPersonaDao(getHandler());

        _logger.debug( String.format( "Leaving getPersonaByFullName.ctor: attribute {%s}",
                persona.toString() ) );

    }

    public GetPersonaByFullNameCommand(Persona persona){
        _logger.debug( String.format( "Get in getPersonaByFullName.ctor: parameter {%s}",
                persona.toString() ) );
        setHandler(new DBHandler());
        this.persona = persona;
        dao = DaoFactory.createPersonaDao(getHandler());

        _logger.debug( String.format( "Leaving getPersonaByFullName.ctor: attribute {%s}",
                persona.toString() ) );

    }


    @Override
    public void execute(){

        _logger.debug( "Get in  getPersonaByFullName.execute" );

        persona = dao.getPersonaByFullName(persona.getPersNombre(), persona.getPersApellido());

        _logger.debug( "Leaving getPersonaByFullName.execute" );

    }

    @Override
    public Persona getReturnParam() {
        return persona;
    }
}
