package com.ucab.cmcapp.logic.commands.punto_geografico.atomic;

import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class AddPuntoGeograficoCommand extends AddEntityCommand<PuntoGeografico> {
    public AddPuntoGeograficoCommand(PuntoGeografico entity, DBHandler handler) {
        super(entity, handler);
    }

    public AddPuntoGeograficoCommand(PuntoGeografico entity) {
        super(entity);
    }

    @Override
    protected BaseDao<PuntoGeografico> getDao(DBHandler handler) {
        return new BaseDao<PuntoGeografico>(handler) {
            @Override
            public PuntoGeografico insert(PuntoGeografico entity) {
                return super.insert(entity);
            }
        };

//
    }
}
