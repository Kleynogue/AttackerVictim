package com.ucab.cmcapp.logic.commands.querella.atomic;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.QuerellaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetQuerellasByStatusCommand extends Command<Querella> {

    private static Logger _logger = LoggerFactory.getLogger( GetQuerellasByStatusCommand.class );
    private Querella querella;
    private List<Querella> result;
    private QuerellaDao dao;


    public GetQuerellasByStatusCommand(Querella querella, DBHandler handler){
        _logger.debug( String.format( "Get in GetQuerellasByStatusCommand.ctor: parameter {%s}",
                querella.toString() ) );
        setHandler(handler);
        this.querella = querella;
        dao = DaoFactory.createQuerellaDao(getHandler());

        _logger.debug( String.format( "Leaving GetQuerellasByStatusCommand.ctor: attribute {%s}",
                querella.toString() ) );

    }

    public GetQuerellasByStatusCommand(Querella querella){
        _logger.debug( String.format( "Get in GetQuerellasByStatusCommand.ctor: parameter {%s}",
                querella.toString() ) );
        setHandler(new DBHandler());
        this.querella = querella;
        dao = DaoFactory.createQuerellaDao(getHandler());

        _logger.debug( String.format( "Leaving GetQuerellasByStatusCommand.ctor: attribute {%s}",
                querella.toString() ) );

    }

    @Override
    public void execute() throws IOException {

        _logger.debug( "Get in  GetQuerellasByStatusCommand.execute" );

        result = dao.getQuerellasByStatus(querella.getQuerStatus());

        _logger.debug( "Leaving GetQuerellasByStatusCommand.execute" );

    }

    @Override
    public List<Querella> getReturnParam() {
        return result;
    }
}
