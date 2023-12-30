package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Conexion;
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
import java.util.Date;
import java.util.List;

public class ConexionDao extends BaseDao<Conexion> {

    private static Logger _logger = LoggerFactory.getLogger(ConexionDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public ConexionDao() {
    }

    public ConexionDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<Conexion> getConnectionsByDate(Date date) {
        List<Conexion> result = null;
        _logger.debug(String.format("Get in ConexionDao.getConnectionsByDate: parameter {%s}", date.toString()));
        try {
            CriteriaQuery<Conexion> query = _builder.createQuery(Conexion.class);
            Root<Conexion> root = query.from(Conexion.class);
            query.select(root);
            query.where(_builder.equal(root.get("coneFecha"), date));
            result = _em.createQuery(query).getResultList();
        } catch (NoResultException e) {
            _logger.error(String.format("Error ConexionDao.getConnectionsByDate: No Result {%s}", e.getMessage()));
        } catch (Exception e) {
            _logger.error(String.format("Error ConexionDao.getConnectionsByDate: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        return result;
    }

    public List<Conexion> getConnectionsByPhone(Telefono telefono){
        List<Conexion> result = null;
        _logger.debug(String.format("Get in ReporteDao.getConnectionsByPhone: parameter {%s}", telefono.toString()));

        try {
            CriteriaQuery<Conexion> query = _builder.createQuery(Conexion.class);
            Root<Conexion> root = query.from(Conexion.class);
            query.select(root);
            query.where(_builder.equal(root.get("coneFKTelefono"), telefono));
            result = _em.createQuery(query).getResultList();
        }catch (NoResultException e) {
            _logger.error(String.format("Error ReporteDao.getConnectionsByPhone: No Result {%s}", e.getMessage()));
        } catch (Exception e) {
            _logger.error(String.format("Error ReporteDao.getConnectionsByPhone: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }

        return result;
    }
}