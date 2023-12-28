package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class GetUsuarioByUsernameCommand extends Command<Usuario> {

    private static Logger _logger = LoggerFactory.getLogger( AddUsuarioCommand.class );
    private Usuario usuario;
    private UsuarioDao dao;

    public GetUsuarioByUsernameCommand(Usuario usuario, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUsuarioByUsernameCommand.ctor: parameter {%s}",
                usuario.toString() ) );
        setHandler(handler);
        this.usuario = usuario;
        dao = DaoFactory.createUsuarioDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetUsuarioByUsernameCommand.ctor: attribute {%s}",
                usuario.toString() ) );
        //endregion
    }

    public GetUsuarioByUsernameCommand(Usuario usuario )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUsuarioByUsernameCommand.ctor: parameter {%s}",
                usuario.toString() ) );
        this.usuario = usuario;
        setHandler(new DBHandler());
        dao = DaoFactory.createUsuarioDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetUsuarioByUsernameCommand.ctor: attribute {%s}",
                usuario.toString() ) );
        //endregion
    }


    @Override
    public void execute() throws IOException {
        //region Instrumentation DEBUG
        _logger.debug( "Get in GetUsuarioByUsernameCommand.execute" );
        //endregion

        usuario = dao.getUsuarioByUsername(usuario.getUsuaUsername());

        //region Instrumentation DEBUG
        _logger.debug( "Get in GetUsuarioByUsernameCommand.execute" );
        //endregion
    }

    @Override
    public Usuario getReturnParam() {
        return usuario;
    }
}
