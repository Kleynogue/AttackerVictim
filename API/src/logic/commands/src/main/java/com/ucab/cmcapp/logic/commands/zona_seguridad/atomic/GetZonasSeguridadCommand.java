package com.ucab.cmcapp.logic.commands.zona_seguridad.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetZonasSeguridadCommand extends GetEntitiesCommand<ZonaSeguridad> {


    public GetZonasSeguridadCommand(DBHandler handler) {
        super(handler);
    }

    @Override
    protected BaseDao<ZonaSeguridad> getDao(DBHandler handler) {
        return DaoFactory.createZonaSeguridadDao(handler);
    }

    @Override
    protected Class<ZonaSeguridad> obtainClass() {
        return ZonaSeguridad.class;
    }
}
