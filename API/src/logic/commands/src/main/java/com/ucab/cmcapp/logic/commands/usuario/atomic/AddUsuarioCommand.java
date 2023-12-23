package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AddUsuarioCommand extends AddEntityCommand<Usuario> {

    public AddUsuarioCommand(Usuario usuario, DBHandler handler) {
        super(usuario, handler);
    }

    public AddUsuarioCommand(Usuario usuario) {
        super(usuario);
    }

    @Override
    protected BaseDao<Usuario> getDao(DBHandler handler) {
        return DaoFactory.createUsuarioDao(getHandler());
    }
}
