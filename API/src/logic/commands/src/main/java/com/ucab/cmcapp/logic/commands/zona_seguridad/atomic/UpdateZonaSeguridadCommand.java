package com.ucab.cmcapp.logic.commands.zona_seguridad.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class UpdateZonaSeguridadCommand extends UpdateEntityCommand<ZonaSeguridad> {
    public UpdateZonaSeguridadCommand(ZonaSeguridad entity, DBHandler handler) {
        super(entity, handler);
    }

    public UpdateZonaSeguridadCommand(ZonaSeguridad entity) {
        super(entity);
    }

    @Override
    protected BaseDao<ZonaSeguridad> getDao(DBHandler handler) {
        return DaoFactory.createZonaSeguridadDao(handler);
    }
}
