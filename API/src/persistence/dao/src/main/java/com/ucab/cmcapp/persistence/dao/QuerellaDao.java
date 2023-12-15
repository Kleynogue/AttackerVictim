package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class QuerellaDao extends BaseDao<Querella>{

    private static Logger _logger = LoggerFactory.getLogger( QuerellaDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public QuerellaDao(){
        super();
    }

    public QuerellaDao(DBHandler handler){
        super( handler );
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<Querella> getQuerellasByStatus(String status){
        List<Querella> result = null;
        _logger.debug( String.format( "Get in QuerellaDao.getQuerellasByStatus: parameter {%s}", status ) );
        try {
            CriteriaQuery<Querella> query = _builder.createQuery(Querella.class);
            Root<Querella> root = query.from(Querella.class);
            query.select(root);
            query.where(_builder.equal(root.get("querStatus"), status));
            result = _em.createQuery(query).getResultList();
        }catch (NoResultException e){
            _logger.error( String.format( "Error QuerellaDao.getQuerellasByStatus: No Result {%s}", e.getMessage() ) );
        }catch (Exception e){
            _logger.error( String.format( "Error QuerellaDao.getQuerellasByStatus: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }

        return result;
    }


}
