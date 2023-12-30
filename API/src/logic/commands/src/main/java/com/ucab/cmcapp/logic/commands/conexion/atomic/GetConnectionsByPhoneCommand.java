package com.ucab.cmcapp.logic.commands.conexion.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.reporte.atomic.GetReportsByPhoneCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ConexionDao;
import com.ucab.cmcapp.persistence.dao.ReporteDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetConnectionsByPhoneCommand extends Command<Conexion>{

    private static Logger _logger = LoggerFactory.getLogger( GetConnectionsByPhoneCommand.class );
    private Conexion conexion;
    private List<Conexion> result;
    private ConexionDao dao;


    public GetConnectionsByPhoneCommand(Conexion conexion, DBHandler handler){
        _logger.debug( String.format( "Get in GetConnectionsByPhoneCommand.ctor: parameter {%s}",
                conexion.toString() ) );
        setHandler(handler);
        this.conexion = conexion;
        dao = DaoFactory.createConexionDao(getHandler());

        _logger.debug( String.format( "Leaving GetConnectionsByPhoneCommand.ctor: attribute {%s}",
                conexion.toString() ) );

    }

    public GetConnectionsByPhoneCommand(Conexion conexion){
        _logger.debug( String.format( "Get in GetConnectionsByPhoneCommand.ctor: parameter {%s}",
                conexion.toString() ) );
        setHandler(new DBHandler());
        this.conexion = conexion;
        dao = DaoFactory.createConexionDao(getHandler());

        _logger.debug( String.format( "Leaving GetConnectionsByPhoneCommand.ctor: attribute {%s}",
                conexion.toString() ) );

    }

    @Override
    public void execute() throws IOException {

        _logger.debug( "Get in  GetReportsByPhoneCommand.execute" );

        result = dao.getConnectionsByPhone(conexion.getConeFKTelefono());

        _logger.debug( "Leaving GetReportsByPhoneCommand.execute" );

    }

    @Override
    public List<Conexion> getReturnParam() {
        return result;
    }
}
