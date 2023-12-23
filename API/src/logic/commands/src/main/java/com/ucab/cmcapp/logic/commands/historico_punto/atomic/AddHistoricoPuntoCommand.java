package com.ucab.cmcapp.logic.commands.historico_punto.atomic;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class AddHistoricoPuntoCommand extends AddEntityCommand<HistoricoPunto> {
    public AddHistoricoPuntoCommand(HistoricoPunto entity, DBHandler handler) {
        super(entity, handler);
    }

    public AddHistoricoPuntoCommand(HistoricoPunto entity) {
        super(entity);
    }

    @Override
    protected BaseDao<HistoricoPunto> getDao(DBHandler handler) {
        return DaoFactory.createHistoricoPuntoDao(handler);
    }
}
