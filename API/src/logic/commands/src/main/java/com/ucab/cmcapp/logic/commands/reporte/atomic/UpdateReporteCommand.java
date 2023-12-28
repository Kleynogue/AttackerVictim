package com.ucab.cmcapp.logic.commands.reporte.atomic;

import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class UpdateReporteCommand extends UpdateEntityCommand<Reporte> {
    public UpdateReporteCommand(Reporte entity, DBHandler handler) {
        super(entity, handler);
    }

    public UpdateReporteCommand(Reporte entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Reporte> getDao(DBHandler handler) {
        return DaoFactory.createReporteDao(handler);
    }
}
