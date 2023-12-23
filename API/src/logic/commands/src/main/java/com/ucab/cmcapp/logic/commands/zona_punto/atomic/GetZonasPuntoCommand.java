package com.ucab.cmcapp.logic.commands.zona_punto.atomic;

import com.ucab.cmcapp.common.entities.ZonaPunto;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetZonasPuntoCommand extends GetEntitiesCommand<ZonaPunto> {


    public GetZonasPuntoCommand(DBHandler handler) {
        super(handler);
    }

    @Override
    protected BaseDao<ZonaPunto> getDao(DBHandler handler) {
        return DaoFactory.createZonaPuntoDao(handler);
    }

    @Override
    protected Class<ZonaPunto> obtainClass() {
        return ZonaPunto.class;
    }
}
