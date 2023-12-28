package com.ucab.cmcapp.logic.commands.common.atomic;

import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GetEntityByIdCommand<T> extends Command<T> {

    protected static Logger _logger = LoggerFactory.getLogger( GetEntityByIdCommand.class );
    protected long Id;
    protected T result;
    protected BaseDao<T> dao;


    public GetEntityByIdCommand( long Id )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetEntityByIdCommand.ctor: parameter {%s}", Id ) );
        //endregion

        this.Id = Id;
        setHandler(new DBHandler());
        dao = getDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetEntityByIdCommand.ctor: attribute {%s}", Id ) );
        //endregion
    }

    @Override
    public void execute(){
        _logger.debug( "Get in  GetEntityByIdCommand.execute" );
        //endregion
        result = dao.find(Id, obtainClass());
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetEntityByIdCommand.execute" );
    }

    @Override
    public T getReturnParam() {
        return result;
    }

    protected abstract BaseDao<T> getDao(DBHandler handler);
    protected abstract Class<T> obtainClass();

}
