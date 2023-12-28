package com.ucab.cmcapp.logic.commands.common.composite;

import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class CreateEntityCommand<T> extends Command<T> {

    protected static Logger _logger = LoggerFactory.getLogger( CreateEntityCommand.class );
    protected T entity;
    protected T result;
    protected AddEntityCommand<T> addEntityCommand;


    public CreateEntityCommand(T entity)
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateEntityCommand.ctor");
        //endregion

        this.entity = entity;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateEntityCommand.ctor");
        //endregion
    }

    @Override
    public void execute() throws IOException {

        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateEntityCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            addEntityCommand = getAddCommand(entity, getHandler());//CommandFactory.createAddUserCommand(_user, getHandler());
            addEntityCommand.execute();
            result = addEntityCommand.getReturnParam();
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
        _logger.debug( "Leaving CreateEntityCommand.execute");
        //endregion

    }

    @Override
    public T getReturnParam() {
        return result;
    }

    protected abstract AddEntityCommand<T> getAddCommand(T entity, DBHandler handler);
}
