package com.ucab.cmcapp.logic.commands.persona.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;

public class AddPersonaCommand extends AddEntityCommand<Persona> {

    public AddPersonaCommand(Persona persona, DBHandler handler) {
        super(persona, handler);
    }

    public AddPersonaCommand(Persona persona) {
        super(persona);
    }

    @Override
    protected BaseDao<Persona> getDao(DBHandler handler) {
        return DaoFactory.createPersonaDao(getHandler());
    }
}
