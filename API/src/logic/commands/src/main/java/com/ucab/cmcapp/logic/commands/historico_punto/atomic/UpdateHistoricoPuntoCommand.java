package com.ucab.cmcapp.logic.commands.historico_punto.atomic;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class UpdateHistoricoPuntoCommand extends UpdateEntityCommand<HistoricoPunto> {
    public UpdateHistoricoPuntoCommand(HistoricoPunto entity, DBHandler handler) {
        super(entity, handler);
    }

    public UpdateHistoricoPuntoCommand(HistoricoPunto entity) {
        super(entity);
    }

    @Override
    protected BaseDao<HistoricoPunto> getDao(DBHandler handler) {
        return DaoFactory.createHistoricoPuntoDao(handler);
    }
}
