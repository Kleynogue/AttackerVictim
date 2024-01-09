package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.common.exceptions.NotFoundException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PersonaDao extends BaseDao<Persona>{

    private static Logger _logger = LoggerFactory.getLogger( PersonaDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public PersonaDao(){
        super();
    }

    public PersonaDao( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Persona getPersonaByFullName(String name, String lastName){
        Persona result = EntityFactory.createPersona();
        _logger.debug( String.format( "Get in PersonaDao.getPersonaByFullName: parameters {%s}, {%s}", name, lastName ) );
        try {
            CriteriaQuery<Persona> query = _builder.createQuery(Persona.class);
            Root<Persona> root = query.from(Persona.class);
            query.select(root);
            Predicate nameEquals = _builder.equal(root.get("persNombre"), name);
            Predicate lastNameEquals = _builder.equal(root.get("persApellido"), lastName);
            query.where(_builder.and(nameEquals, lastNameEquals));
            result = _em.createQuery(query).getSingleResult();

        }catch (NoResultException e){
            _logger.error( String.format( "Error PersonaDao.getPersonaByFullName: No Result {%s}", e.getMessage() ) );
            throw new NotFoundException("Persona no encontrada");
        }catch (Exception e){
            _logger.error( String.format( "Error PersonaDao.getPersonaByFullName: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }

        return result;
    }

}
