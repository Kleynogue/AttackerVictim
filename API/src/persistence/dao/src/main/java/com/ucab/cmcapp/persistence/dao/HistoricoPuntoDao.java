package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.common.exceptions.NotFoundException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HistoricoPuntoDao extends BaseDao<HistoricoPunto>{

    private static Logger _logger = LoggerFactory.getLogger( HistoricoPuntoDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public HistoricoPuntoDao() {
    }

    public HistoricoPuntoDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<HistoricoPunto> getHistoryByPhone(Telefono telefono){
        List<HistoricoPunto> result = null;
        _logger.debug( String.format( "Get in HistoricoPuntoDao.getHistoryByPhone: parameters {%s}", telefono.toString() ) );
        try {
            CriteriaQuery<HistoricoPunto> query = _builder.createQuery(HistoricoPunto.class);
            Root<HistoricoPunto> root = query.from(HistoricoPunto.class);
            query.select(root);
            query.where(_builder.equal(root.get("histPunFKTelefono"),telefono));
            result = _em.createQuery(query).getResultList();
        }catch (NoResultException e){
            _logger.error( String.format( "Error HistoricoPuntoDao.getHistoryByPhone: No Result {%s}", e.getMessage() ) );
            throw new NotFoundException("Historicos no encontrados");
        }catch (Exception e){
            _logger.error( String.format( "Error HistoricoPuntoDao.getHistoryByPhone: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        return result;
    }

}
