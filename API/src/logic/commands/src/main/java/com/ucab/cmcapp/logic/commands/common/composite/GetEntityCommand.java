package com.ucab.cmcapp.logic.commands.common.composite;

import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class GetEntityCommand<T> extends Command<T>{

    protected static Logger _logger = LoggerFactory.getLogger( GetEntityCommand.class );
    protected T entity;
    protected long id;


    public GetEntityCommand( T entity )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetEntityCommand.ctor: parameter {%s}",
                entity.toString() ) );
        this.entity = entity;
        id = getId();
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetEntityCommand.ctor: attribute {%s}",
                entity.toString() ) );
        //endregion
    }

    @Override
    public void execute() throws IOException {
        try
        {
            getHandler().beginTransaction();
            GetEntityByIdCommand<T> getEntityByIdCommand = getGetCommand(id);
            getEntityByIdCommand.execute();
            entity = getEntityByIdCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        }catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public T getReturnParam() {
        return entity;
    }

    protected abstract GetEntityByIdCommand<T> getGetCommand(long id);

    protected abstract long getId();
}
