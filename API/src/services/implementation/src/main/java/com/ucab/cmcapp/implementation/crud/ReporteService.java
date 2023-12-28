package com.ucab.cmcapp.implementation.crud;

import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.implementation.crud.common.CrudService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.dtos.ReporteDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.ReporteMapper;
import com.ucab.cmcapp.persistence.DBHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reporte")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReporteService extends CrudService<ReporteDto, Reporte> {
    @Override
    protected UpdateEntityCommand<Reporte> getCreateUpdateEntity(Reporte entity) {
        return CommandFactory.createUpdateReporteCommand(entity);
    }

    @Override
    protected CreateEntityCommand<Reporte> getCreateCreateEntity(Reporte entity) {
        return CommandFactory.createCreateReporteCommand(entity);
    }

    @Override
    protected ReporteDto getDto(long id) {
        return new ReporteDto(id);
    }

    @Override
    protected GetEntitiesCommand<Reporte> getCreateGetEntities(DBHandler dbHandler) {
        return CommandFactory.createGetReportesCommand(dbHandler);
    }

    @Override
    protected GetEntityCommand<Reporte> getCreateGetEntity(Reporte entity) {
        return CommandFactory.createGetReporteCommand(entity);
    }

    @Override
    protected BaseMapper<ReporteDto, Reporte> getMapper() {
        return new ReporteMapper();
    }
}
