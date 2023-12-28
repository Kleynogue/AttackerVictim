package com.ucab.cmcapp.logic.commands.historico_punto.atomic;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByFullNameCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.HistoricoPuntoDao;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GetHistoryByPhoneCommand extends Command<HistoricoPunto> {

    private static Logger _logger = LoggerFactory.getLogger( GetHistoryByPhoneCommand.class );
    private HistoricoPunto historico;
    private List<HistoricoPunto> result;
    private HistoricoPuntoDao dao;


    public GetHistoryByPhoneCommand(HistoricoPunto historico, DBHandler handler){
        _logger.debug( String.format( "Get in GetHistoryByPhoneCommand.ctor: parameter {%s}",
                historico.toString() ) );
        setHandler(handler);
        this.historico = historico;
        dao = DaoFactory.createHistoricoPuntoDao(getHandler());

        _logger.debug( String.format( "Leaving GetHistoryByPhoneCommand.ctor: attribute {%s}",
                historico.toString() ) );

    }

    public GetHistoryByPhoneCommand(HistoricoPunto historico){
        _logger.debug( String.format( "Get in GetHistoryByPhoneCommand.ctor: parameter {%s}",
                historico.toString() ) );
        setHandler(new DBHandler());
        this.historico = historico;
        dao = DaoFactory.createHistoricoPuntoDao(getHandler());

        _logger.debug( String.format( "Leaving GetHistoryByPhoneCommand.ctor: attribute {%s}",
                historico.toString() ) );

    }

    @Override
    public void execute() throws IOException {

        _logger.debug( "Get in  GetHistoryByPhoneCommand.execute" );

        result = dao.getHistoryByPhone(historico.getHistPunFKTelefono());

        _logger.debug( "Leaving GetHistoryByPhoneCommand.execute" );

    }

    @Override
    public Object getReturnParam() {
        return result;
    }
}
