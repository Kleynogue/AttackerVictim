package com.ucab.cmcapp.logic.commands.movimiento.atomic;

import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByFullNameCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.MovimientoDao;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetMovesByDateCommand extends Command<Movimiento> {

    private static Logger _logger = LoggerFactory.getLogger( GetMovesByDateCommand.class );
    private Movimiento movimiento;
    private List<Movimiento> result;
    private MovimientoDao dao;


    public GetMovesByDateCommand(Movimiento movimiento, DBHandler handler){
        _logger.debug( String.format( "Get in GetMovesByDateCommand.ctor: parameter {%s}",
                movimiento.toString() ) );
        setHandler(handler);
        this.movimiento = movimiento;
        dao = DaoFactory.createMovimientoDao(getHandler());

        _logger.debug( String.format( "Leaving GetMovesByDateCommand.ctor: attribute {%s}",
                movimiento.toString() ) );

    }

    public GetMovesByDateCommand(Movimiento movimiento){
        _logger.debug( String.format( "Get in GetMovesByDateCommand.ctor: parameter {%s}",
                movimiento.toString() ) );
        setHandler(new DBHandler());
        this.movimiento = movimiento;
        dao = DaoFactory.createMovimientoDao(getHandler());

        _logger.debug( String.format( "Leaving GetMovesByDateCommand.ctor: attribute {%s}",
                movimiento.toString() ) );

    }

    @Override
    public void execute(){
        _logger.debug( "Get in  GetMovesByDateCommand.execute" );

        result = dao.getMovesByDate(movimiento.getMoviFecha());

        _logger.debug( "Leaving GetMovesByDateCommand.execute" );
    }

    @Override
    public List<Movimiento> getReturnParam() {
        return result;
    }
}
