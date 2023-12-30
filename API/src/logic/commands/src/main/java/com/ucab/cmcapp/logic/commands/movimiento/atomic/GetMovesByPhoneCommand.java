package com.ucab.cmcapp.logic.commands.movimiento.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.conexion.atomic.GetConnectionsByPhoneCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ConexionDao;
import com.ucab.cmcapp.persistence.dao.MovimientoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetMovesByPhoneCommand extends Command<Movimiento>{

    private static Logger _logger = LoggerFactory.getLogger( GetMovesByPhoneCommand.class );
    private Movimiento movimiento;
    private List<Movimiento> result;
    private MovimientoDao dao;


    public GetMovesByPhoneCommand(Movimiento movimiento, DBHandler handler){
        _logger.debug( String.format( "Get in GetMovesByPhoneCommand.ctor: parameter {%s}",
                movimiento.toString() ) );
        setHandler(handler);
        this.movimiento = movimiento;
        dao = DaoFactory.createMovimientoDao(getHandler());

        _logger.debug( String.format( "Leaving GetMovesByPhoneCommand.ctor: attribute {%s}",
                movimiento.toString() ) );

    }

    public GetMovesByPhoneCommand(Movimiento movimiento){
        _logger.debug( String.format( "Get in GetMovesByPhoneCommand.ctor: parameter {%s}",
                movimiento.toString() ) );
        setHandler(new DBHandler());
        this.movimiento = movimiento;
        dao = DaoFactory.createMovimientoDao(getHandler());

        _logger.debug( String.format( "Leaving GetMovesByPhoneCommand.ctor: attribute {%s}",
                movimiento.toString() ) );

    }

    @Override
    public void execute() throws IOException {

        _logger.debug( "Get in  GetReportsByPhoneCommand.execute" );

        result = dao.getMovesByPhone(movimiento.getMoviFKTelefono());

        _logger.debug( "Leaving GetReportsByPhoneCommand.execute" );

    }

    @Override
    public List<Movimiento> getReturnParam() {
        return result;
    }
}
