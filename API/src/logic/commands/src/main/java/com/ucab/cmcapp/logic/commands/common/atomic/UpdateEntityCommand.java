package com.ucab.cmcapp.logic.commands.common.atomic;

import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class UpdateEntityCommand<T> extends Command<T> {

    protected static Logger _logger = LoggerFactory.getLogger( UpdateEntityCommand.class );
    protected T entity;
    protected BaseDao<T> dao;


    public UpdateEntityCommand(T entity, DBHandler handler) {
        _logger.debug( String.format( "Get in UpdateEntityCommand.ctor: parameter {%s}",
                entity.toString() ) );
        setHandler(handler);
        this.entity = entity;
        dao = getDao(getHandler());
        _logger.debug( String.format( "Leaving UpdateEntityCommand.ctor: attribute {%s}",
                entity.toString() ) );
    }

    public UpdateEntityCommand(T entity) {
        _logger.debug( String.format( "Get in UpdateEntityCommand.ctor: parameter {%s}",
                entity.toString() ) );
        setHandler(new DBHandler());
        this.entity = entity;
        dao = getDao(getHandler());
        _logger.debug( String.format( "Leaving UpdateEntityCommand.ctor: attribute {%s}",
                entity.toString() ) );
    }

    protected abstract BaseDao<T> getDao(DBHandler handler);

    @Override
    public void execute() throws IOException {
        _logger.debug( "Get in UpdateEntityCommand.execute" );

        try {
            getHandler().beginTransaction();
            entity = dao.update(entity);
            getHandler().finishTransaction();
            getHandler().closeSession();
        }catch (Exception e){
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

        _logger.debug( "Leaving UpdateEntityCommand.execute" );
    }

    @Override
    public T getReturnParam() {
        return entity;
    }
}
