package com.ucab.cmcapp.logic.commands.reporte.atomic;

import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetReporteByIdCommand extends GetEntityByIdCommand<Reporte> {
    public GetReporteByIdCommand(long Id) {
        super(Id);
    }

    @Override
    protected BaseDao<Reporte> getDao(DBHandler handler) {
        return DaoFactory.createReporteDao(handler);
    }

    @Override
    protected Class<Reporte> obtainClass() {
        return Reporte.class;
    }
}
