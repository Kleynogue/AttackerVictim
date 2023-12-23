package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetUsuariosByTypeCommand extends Command<List<Usuario>> {

    private static Logger _logger = LoggerFactory.getLogger( GetUsuariosByTypeCommand.class );
    private String type;
    private List<Usuario> usuarios;
    private UsuarioDao dao;


    public GetUsuariosByTypeCommand( String type, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUsuariosByTypeCommand.ctor: parameter {%s}",
                type) );
        setHandler(handler);
        this.type = type;
        dao = DaoFactory.createUsuarioDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetUsuariosByTypeCommand.ctor: attribute {%s}",
                type ) );
        //endregion
    }

    public GetUsuariosByTypeCommand( String type )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUsuariosByTypeCommand.ctor: parameter {%s}",
                type ) );
        this.type = type;
        setHandler(new DBHandler());
        dao = DaoFactory.createUsuarioDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetUsuariosByTypeCommand.ctor: attribute {%s}",
                type ) );
        //endregion
    }

    @Override
    public void execute() throws IOException {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetUsuariosByTypeCommand.execute" );
        //endregion

        usuarios = dao.getUsuariosByType(type);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetUsuariosByTypeCommand.execute" );
        //endregion
    }

    @Override
    public List<Usuario> getReturnParam() {
        return usuarios;
    }
}
