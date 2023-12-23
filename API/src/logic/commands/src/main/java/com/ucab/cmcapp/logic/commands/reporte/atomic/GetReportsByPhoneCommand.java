package com.ucab.cmcapp.logic.commands.reporte.atomic;

import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ReporteDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetReportsByPhoneCommand extends Command<Reporte> {

    private static Logger _logger = LoggerFactory.getLogger( GetReportsByPhoneCommand.class );
    private Reporte reporte;
    private List<Reporte> result;
    private ReporteDao dao;


    public GetReportsByPhoneCommand(Reporte reporte, DBHandler handler){
        _logger.debug( String.format( "Get in GetReportsByPhoneCommand.ctor: parameter {%s}",
                reporte.toString() ) );
        setHandler(handler);
        this.reporte = reporte;
        dao = DaoFactory.createReporteDao(getHandler());

        _logger.debug( String.format( "Leaving GetReportsByPhoneCommand.ctor: attribute {%s}",
                reporte.toString() ) );

    }

    public GetReportsByPhoneCommand(Reporte reporte){
        _logger.debug( String.format( "Get in GetReportsByPhoneCommand.ctor: parameter {%s}",
                reporte.toString() ) );
        setHandler(new DBHandler());
        this.reporte = reporte;
        dao = DaoFactory.createReporteDao(getHandler());

        _logger.debug( String.format( "Leaving GetReportsByPhoneCommand.ctor: attribute {%s}",
                reporte.toString() ) );

    }

    @Override
    public void execute() throws IOException {

        _logger.debug( "Get in  GetReportsByPhoneCommand.execute" );

        result = dao.getReportsByPhone(reporte.getRepoFKTelefono());

        _logger.debug( "Leaving GetReportsByPhoneCommand.execute" );


    }

    @Override
    public Object getReturnParam() {
        return result;
    }
}
