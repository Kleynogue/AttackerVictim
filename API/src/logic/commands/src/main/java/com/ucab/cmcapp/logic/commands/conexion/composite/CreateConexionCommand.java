package com.ucab.cmcapp.logic.commands.conexion.composite;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.AddEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CreateConexionCommand extends CreateEntityCommand<Conexion> {
    public CreateConexionCommand(Conexion entity) {
        super(entity);
    }

    @Override
    protected AddEntityCommand<Conexion> getAddCommand(Conexion entity, DBHandler handler) {
        return CommandFactory.createAddConexionCommad(entity,handler);
    }
}
