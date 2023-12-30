package com.ucab.cmcapp.implementation.queries;

import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.reporte.atomic.GetReportsByDateCommand;
import com.ucab.cmcapp.logic.commands.reporte.atomic.GetReportsByPhoneCommand;
import com.ucab.cmcapp.logic.dtos.ReporteDto;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.logic.mappers.ReporteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/query/reporte")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReporteQueryService extends BaseService {

    private static Logger _logger = LoggerFactory.getLogger( ReporteQueryService.class );

    @Path("/1")
    @GET
    public List<ReporteDto> getReportsByPhone(@QueryParam("phone") long phoneID){

        List<ReporteDto> response;
        Reporte reporte = new Reporte();
        Telefono telefono = new Telefono(phoneID);
        ReporteMapper mapper = new ReporteMapper();
        GetReportsByPhoneCommand command;
        reporte.setRepoFKTelefono(telefono);

        _logger.debug( "Get in ReporteQueryService.getReportsByPhone" );

        try {

            command = CommandFactory.createGetReportsByPhoneCommand(reporte);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (Exception e){
            _logger.error("error {} getting reportes from telefono {}: {}", e.getMessage(), phoneID, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving ReporteQueryService.getReportsByPhone" );
        return response;
    }

    @Path("/2")
    @GET
    public List<ReporteDto> getReportsByDate(@QueryParam("date") String date){

        List<ReporteDto> response;
        Reporte reporte = new Reporte();
        ReporteMapper mapper = new ReporteMapper();
        GetReportsByDateCommand command;


        _logger.debug( "Get in ReporteQueryService.getReportsByDate" );

        try {
            reporte.setRepoFecha(BaseMapper.parseStringToDate(date));
            command = CommandFactory.createGetReportsByDateCommand(reporte);
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
        }catch (Exception e){
            _logger.error("error {} getting reportes from {}: {}", e.getMessage(), date, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }

        _logger.debug( "Leaving ReporteQueryService.getReportsByDate" );
        return response;
    }
}
