package com.ucab.cmcapp.logic.commands.historico_punto.atomic;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetHistoricosPuntoCommand extends GetEntitiesCommand<HistoricoPunto> {


    public GetHistoricosPuntoCommand(DBHandler handler) {
        super(handler);
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
