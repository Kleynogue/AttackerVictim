package com.ucab.cmcapp.logic.commands.historico_punto.atomic;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetHistoricoPuntoByIdCommand extends GetEntityByIdCommand<HistoricoPunto> {
    public GetHistoricoPuntoByIdCommand(long Id) {
        super(Id);
    }

    @Override
    protected BaseDao<HistoricoPunto> getDao(DBHandler handler) {
        return DaoFactory.createHistoricoPuntoDao(handler);
    }

    @Override
    protected Class<HistoricoPunto> obtainClass() {
        return HistoricoPunto.class;
    }
}
