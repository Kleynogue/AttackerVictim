package com.ucab.cmcapp.logic.commands.punto_geografico.atomic;

import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

import java.util.List;

public class GetPuntosGeograficosCommand extends GetEntitiesCommand<PuntoGeografico> {


    public GetPuntosGeograficosCommand(DBHandler handler) {
        super(handler);
    }

    @Override
    protected BaseDao<PuntoGeografico> getDao(DBHandler handler) {
        return new BaseDao<PuntoGeografico>() {
            @Override
            public List<PuntoGeografico> findAll(Class<PuntoGeografico> type) {
                return super.findAll(type);
            }
        };
    }

    @Override
    protected Class<PuntoGeografico> obtainClass() {
        return PuntoGeografico.class;
    }
}
