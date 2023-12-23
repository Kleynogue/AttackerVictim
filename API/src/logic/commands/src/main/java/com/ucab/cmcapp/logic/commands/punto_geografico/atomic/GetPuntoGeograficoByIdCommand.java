package com.ucab.cmcapp.logic.commands.punto_geografico.atomic;

import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetPuntoGeograficoByIdCommand extends GetEntityByIdCommand<PuntoGeografico> {
    public GetPuntoGeograficoByIdCommand(long Id) {
        super(Id);
    }

    @Override
    protected BaseDao<PuntoGeografico> getDao(DBHandler handler) {
        return new BaseDao<PuntoGeografico>() {
            @Override
            public PuntoGeografico find(Long id, Class<PuntoGeografico> type) {
                return super.find(id, type);
            }
        };
    }

    @Override
    protected Class<PuntoGeografico> obtainClass() {
        return PuntoGeografico.class;
    }
}
