package com.ucab.cmcapp.logic.commands.common.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.conexion.atomic.GetConnectionsByDateCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;
import com.ucab.cmcapp.persistence.dao.ConexionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public abstract class GetEntitiesCommand<T> extends Command<T>{

    protected static Logger _logger = LoggerFactory.getLogger( GetEntitiesCommand.class );
    protected List<T> result;
    protected BaseDao<T> dao;


    public GetEntitiesCommand(DBHandler handler){
        _logger.debug("Get in GetEntitiesCommand.ctor");
        setHandler(handler);
        dao = getDao(getHandler());

        _logger.debug("Leaving GetEntitiesCommand.ctor");

    }

    @Override
    public void execute() throws IOException {

        _logger.debug( "Get in GetEntitiesCommand.execute" );

        result = dao.findAll(obtainClass());

        _logger.debug( "Leaving GetEntitiesCommand.execute" );

    }

    @Override
    public List<T> getReturnParam() {
        return result;
    }

    protected abstract BaseDao<T> getDao(DBHandler handler);
    protected abstract Class<T> obtainClass();
}
