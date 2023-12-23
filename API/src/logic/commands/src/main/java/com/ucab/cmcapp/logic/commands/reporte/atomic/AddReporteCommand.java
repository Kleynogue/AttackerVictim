package com.ucab.cmcapp.logic.commands.reporte.atomic;

import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class AddReporteCommand extends AddEntityCommand<Reporte> {
    public AddReporteCommand(Reporte entity, DBHandler handler) {
        super(entity, handler);
    }

    public AddReporteCommand(Reporte entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Reporte> getDao(DBHandler handler) {
        return DaoFactory.createReporteDao(handler);
    }
}
