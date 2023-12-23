package com.ucab.cmcapp.logic.commands.common.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.persona.atomic.AddPersonaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class AddEntityCommand<T> extends Command<T> {

    protected static Logger _logger = LoggerFactory.getLogger( AddEntityCommand.class );
    protected T entity;
    protected BaseDao<T> dao;


    public AddEntityCommand(T entity, DBHandler handler) {
        _logger.debug( String.format( "Get in AddEntityCommand.ctor: parameter {%s}",
                entity.toString() ) );
        setHandler(handler);
        this.entity = entity;
        dao = getDao(getHandler());
        _logger.debug( String.format( "Leaving AddEntityCommand.ctor: attribute {%s}",
                entity.toString() ) );
    }

    public AddEntityCommand(T entity) {
        _logger.debug( String.format( "Get in AddEntityCommand.ctor: parameter {%s}",
                entity.toString() ) );
        setHandler(new DBHandler());
        this.entity = entity;
        dao = getDao(getHandler());
        _logger.debug( String.format( "Leaving AddEntityCommand.ctor: attribute {%s}",
                entity.toString() ) );
    }

    @Override
    public void execute() throws IOException {
        _logger.debug( "Get in  AddEntityCommand.execute" );

        entity = dao.insert(entity);

        _logger.debug( "Leaving AddEntityCommand.execute" );
    }

    @Override
    public T getReturnParam() {
        return entity;
    }

    protected abstract BaseDao<T> getDao(DBHandler handler);
}
