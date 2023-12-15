package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

public class MovimientoDao extends BaseDao<Movimiento> {

    private static Logger _logger = LoggerFactory.getLogger( MovimientoDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public MovimientoDao() {
    }

    public MovimientoDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<Movimiento> getMovesByDate(Date date){
        List<Movimiento> result = null;
        _logger.debug( String.format( "Get in PersonaDao.getPersonaByFullName: parameter {%s}", date.toString() ) );
        try {
            CriteriaQuery<Movimiento> query = _builder.createQuery(Movimiento.class);
            Root<Movimiento> root = query.from(Movimiento.class);
            query.select(root);
            query.where(_builder.equal(root.get("moviFecha"), date));
            result = _em.createQuery(query).getResultList();
        }catch (NoResultException e){
            _logger.error( String.format( "Error MovimientoDao.getMovesByDate: No Result {%s}", e.getMessage() ) );
        }catch (Exception e){
            _logger.error( String.format( "Error MovimientoDao.getMovesByDate: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        return result;
    }
}
