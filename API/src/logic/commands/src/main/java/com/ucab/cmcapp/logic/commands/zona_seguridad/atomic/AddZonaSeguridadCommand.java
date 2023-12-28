package com.ucab.cmcapp.logic.commands.zona_seguridad.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class AddZonaSeguridadCommand extends AddEntityCommand<ZonaSeguridad> {
    public AddZonaSeguridadCommand(ZonaSeguridad entity, DBHandler handler) {
        super(entity, handler);
    }

    public AddZonaSeguridadCommand(ZonaSeguridad entity) {
        super(entity);
    }

    @Override
    protected BaseDao<ZonaSeguridad> getDao(DBHandler handler) {
        return DaoFactory.createZonaSeguridadDao(handler);
    }
}
