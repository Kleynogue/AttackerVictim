package com.ucab.cmcapp.logic.commands.conexion.composite;

import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntityByIdCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;

public class GetConexionCommand extends GetEntityCommand<Conexion>{
    public GetConexionCommand(Conexion entity) {
        super(entity);
    }

    @Override
    protected GetEntityByIdCommand<Conexion> getGetCommand(long id) {
        return CommandFactory.createGetConexionByIdCommand(id);
    }

    @Override
    protected long getId() {
        return entity.getConeID();
    }
}
