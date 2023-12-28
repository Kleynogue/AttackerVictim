package com.ucab.cmcapp.logic.commands.conexion.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class AddConexionCommand extends AddEntityCommand<Conexion> {
    public AddConexionCommand(Conexion entity, DBHandler handler) {
        super(entity, handler);
    }

    public AddConexionCommand(Conexion entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Conexion> getDao(DBHandler handler) {
        return DaoFactory.createConexionDao(handler);
    }
}
