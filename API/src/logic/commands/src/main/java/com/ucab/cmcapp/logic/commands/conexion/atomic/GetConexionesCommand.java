package com.ucab.cmcapp.logic.commands.conexion.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetConexionesCommand extends GetEntitiesCommand<Conexion>{


    public GetConexionesCommand(DBHandler handler) {
        super(handler);
    }

    @Override
    protected BaseDao<Conexion> getDao(DBHandler handler) {
        return DaoFactory.createConexionDao(handler);
    }

    @Override
    protected Class<Conexion> obtainClass() {
        return Conexion.class;
    }
}
