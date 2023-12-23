package com.ucab.cmcapp.logic.commands.conexion.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByFullNameCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ConexionDao;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetConnectionsByDateCommand extends Command<Conexion> {

    private static Logger _logger = LoggerFactory.getLogger( GetConnectionsByDateCommand.class );
    private Conexion conexion;

    private List<Conexion> result;
    private ConexionDao dao;


    public GetConnectionsByDateCommand(Conexion conexion, DBHandler handler){
        _logger.debug( String.format( "Get in GetConnectionsByDateCommand.ctor: parameter {%s}",
                conexion.toString() ) );
        setHandler(handler);
        this.conexion = conexion;
        dao = DaoFactory.createConexionDao(getHandler());

        _logger.debug( String.format( "Leaving GetConnectionsByDateCommand.ctor: attribute {%s}",
                conexion.toString() ) );

    }

    public GetConnectionsByDateCommand(Conexion conexion){
        _logger.debug( String.format( "Get in GetConnectionsByDateCommand.ctor: parameter {%s}",
                conexion.toString() ) );
        setHandler(new DBHandler());
        this.conexion = conexion;
        dao = DaoFactory.createConexionDao(getHandler());

        _logger.debug( String.format( "Leaving GetConnectionsByDateCommand.ctor: attribute {%s}",
                conexion.toString() ) );

    }

    @Override
    public void execute() throws IOException {
        _logger.debug( "Get in  GetConnectionsByDateCommand.execute" );

        result = dao.getConnectionsByDate(conexion.getConeFecha());

        _logger.debug( "Leaving GetConnectionsByDateCommand.execute" );
    }

    @Override
    public Object getReturnParam() {
        return result;
    }
}
