package com.ucab.cmcapp.logic.commands.conexion.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class UpdateConexionCommand extends UpdateEntityCommand<Conexion> {
    public UpdateConexionCommand(Conexion entity, DBHandler handler) {
        super(entity, handler);
    }

    public UpdateConexionCommand(Conexion entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Conexion> getDao(DBHandler handler) {
        return DaoFactory.createConexionDao(handler);
    }
}
