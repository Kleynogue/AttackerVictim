package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ZonaSeguridadDao extends BaseDao<ZonaSeguridad> {

    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public ZonaSeguridadDao() {
        super();
    }

    public ZonaSeguridadDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public ZonaSeguridad getZonaSeguridadByName(String name){
        ZonaSeguridad result = EntityFactory.createZonaSeguridad();
        _logger.debug( String.format( "Get in ZonaSeguridadDao.getZonaSeguridadByName: parameters {%s}", name) );
        try {
            CriteriaQuery<ZonaSeguridad> query = _builder.createQuery(ZonaSeguridad.class);
            Root<ZonaSeguridad> root = query.from(ZonaSeguridad.class);
            query.select(root);
            query.where(_builder.equal(root.get("zonSegName"), name));
            result = _em.createQuery(query).getSingleResult();

        }catch (NoResultException e){
            _logger.error( String.format( "Error ZonaSeguridadDao.getZonaSeguridadByName: No Result {%s}", e.getMessage() ) );
        }catch (Exception e){
            _logger.error( String.format( "Error ZonaSeguridadDao.getZonaSeguridadByName: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        return result;
    }


}
