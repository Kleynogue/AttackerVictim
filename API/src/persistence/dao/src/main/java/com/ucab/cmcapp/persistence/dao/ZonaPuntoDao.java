package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.common.entities.ZonaPunto;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
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

public class ZonaPuntoDao extends BaseDao<ZonaPunto>{

    private static Logger _logger = LoggerFactory.getLogger( ZonaPuntoDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public ZonaPuntoDao() {
    }

    public ZonaPuntoDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<ZonaPunto> getPuntosByZona(ZonaSeguridad zona){
        List<ZonaPunto> result = null;
        _logger.debug( String.format( "Get in ZonaPuntoDao.getPuntosByZona: parameters {%s}", zona ) );
        try {
            CriteriaQuery<ZonaPunto> query = _builder.createQuery(ZonaPunto.class);
            Root<ZonaPunto> root = query.from(ZonaPunto.class);
            query.select(root);
            query.where(_builder.equal(root.get("zonPunFKZonaSeguridad"),zona));
            result = _em.createQuery(query).getResultList();
        }catch (NoResultException e){
            _logger.error( String.format( "Error ZonaPuntoDao.getPuntosByZona: No Result {%s}", e.getMessage() ) );
            throw new NotFoundException("Puntos no encontrados");
        }catch (Exception e){
            _logger.error( String.format( "Error ZonaPuntoDao.getPuntosByZona: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }

        return result;
    }

}
