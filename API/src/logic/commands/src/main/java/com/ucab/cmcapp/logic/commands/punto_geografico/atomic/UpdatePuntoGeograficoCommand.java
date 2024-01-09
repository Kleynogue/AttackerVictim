package com.ucab.cmcapp.logic.commands.punto_geografico.atomic;

import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class UpdatePuntoGeograficoCommand extends UpdateEntityCommand<PuntoGeografico> {
    public UpdatePuntoGeograficoCommand(PuntoGeografico entity, DBHandler handler) {
        super(entity, handler);
    }

    public UpdatePuntoGeograficoCommand(PuntoGeografico entity) {
        super(entity);
    }

    @Override
    protected BaseDao<PuntoGeografico> getDao(DBHandler handler) {
        return new BaseDao<PuntoGeografico>(handler) {
            @Override
            public PuntoGeografico update(PuntoGeografico entity) {
                return super.update(entity);
            }
        };
    }
}
