package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class UpdateUsuarioCommand extends UpdateEntityCommand<Usuario> {
    public UpdateUsuarioCommand(Usuario entity, DBHandler handler) {
        super(entity, handler);
    }

    public UpdateUsuarioCommand(Usuario entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Usuario> getDao(DBHandler handler) {
        return DaoFactory.createUsuarioDao(handler);
    }
}
