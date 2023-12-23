package com.ucab.cmcapp.logic.commands.reporte.atomic;

import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetReportesCommand extends GetEntitiesCommand<Reporte> {


    public GetReportesCommand(DBHandler handler) {
        super(handler);
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
