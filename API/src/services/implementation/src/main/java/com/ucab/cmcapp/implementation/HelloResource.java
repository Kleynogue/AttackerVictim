package com.ucab.cmcapp.implementation;

import java.util.List;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.PersonaDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {

    @PersistenceContext(unitName = "cmcapp")
    EntityManager manager;

    @GET
    @Produces("text/plain")
    public String hello() {
        Query q = manager.createQuery("from ZonaPunto ");
        return q.getResultList().toString();
    }
}