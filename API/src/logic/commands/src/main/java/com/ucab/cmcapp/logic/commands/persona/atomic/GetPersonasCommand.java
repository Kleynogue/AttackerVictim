package com.ucab.cmcapp.logic.commands.persona.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetPersonasCommand extends GetEntitiesCommand<Persona>{


    public GetPersonasCommand(DBHandler handler) {
        super(handler);
    }

    @Override
    protected BaseDao<Persona> getDao(DBHandler handler) {
        return DaoFactory.createPersonaDao(handler);
    }

    @Override
    protected Class<Persona> obtainClass() {
        return Persona.class;
    }
}
