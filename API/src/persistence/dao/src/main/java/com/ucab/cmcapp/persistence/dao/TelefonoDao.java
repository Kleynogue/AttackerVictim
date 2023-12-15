package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TelefonoDao extends BaseDao<Telefono> {

    private static Logger _logger = LoggerFactory.getLogger( TelefonoDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public TelefonoDao(){
        super();
    }

    public TelefonoDao(DBHandler handler){
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Telefono getTelefonoByBluetooth(String bluetooth){
        Telefono result = EntityFactory.createTelefono();
        _logger.debug( String.format( "Get in TelefonoDao.getTelefonoByBluetooth: parameters {%s}", bluetooth ) );
        try {
            CriteriaQuery<Telefono> query = _builder.createQuery(Telefono.class);
            Root<Telefono> root = query.from(Telefono.class);
            query.select(root);
            query.where(_builder.equal(root.get("teleBluetooth"), bluetooth));
            result = _em.createQuery(query).getSingleResult();
        }catch (NoResultException e){
            _logger.error( String.format( "Error TelefonoDao.getTelefonoByBluetooth: No Result {%s}", e.getMessage() ) );
        }catch (Exception e){
            _logger.error( String.format( "Error TelefonoDao.getTelefonoByBluetooth: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        return result;
    }

}
