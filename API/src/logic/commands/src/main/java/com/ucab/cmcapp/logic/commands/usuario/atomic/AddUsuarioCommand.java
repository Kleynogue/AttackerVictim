package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

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
