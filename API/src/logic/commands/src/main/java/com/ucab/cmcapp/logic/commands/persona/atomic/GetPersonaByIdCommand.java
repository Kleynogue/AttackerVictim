package com.ucab.cmcapp.logic.commands.persona.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class GetPersonaByIdCommand extends GetEntityByIdCommand<Persona> {


    public GetPersonaByIdCommand(long Id ) {
        super(Id);
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
