package com.ucab.cmcapp.logic.commands.persona.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class UpdatePersonaCommand extends UpdateEntityCommand<Persona> {
    public UpdatePersonaCommand(Persona entity, DBHandler handler) {
        super(entity, handler);
    }

    public UpdatePersonaCommand(Persona entity) {
        super(entity);
    }

    @Override
    protected BaseDao<Persona> getDao(DBHandler handler) {
        return DaoFactory.createPersonaDao(handler);
    }
}
