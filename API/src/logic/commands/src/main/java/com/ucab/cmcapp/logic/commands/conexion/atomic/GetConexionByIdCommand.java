package com.ucab.cmcapp.logic.commands.conexion.atomic;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetConexionByIdCommand extends GetEntityByIdCommand<Conexion> {
    public GetConexionByIdCommand(long Id) {
        super(Id);
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
