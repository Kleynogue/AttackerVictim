package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetUsuariosCommand extends GetEntitiesCommand<Usuario> {


    public GetUsuariosCommand(DBHandler handler) {
        super(handler);
    }

    @Override
    protected BaseDao<Usuario> getDao(DBHandler handler) {
        return DaoFactory.createUsuarioDao(handler);
    }

    @Override
    protected Class<Usuario> obtainClass() {
        return Usuario.class;
    }
}
