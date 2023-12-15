package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Reporte;
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

public class ReporteDao extends BaseDao<Reporte> {

    private static Logger _logger = LoggerFactory.getLogger(ReporteDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public ReporteDao() {
    }

    public ReporteDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<Reporte> getReportsByPhone(Telefono telefono) {
        List<Reporte> result = null;
        _logger.debug(String.format("Get in ReporteDao.getReportsByPhone: parameter {%s}", telefono.toString()));
        try {
            CriteriaQuery<Reporte> query = _builder.createQuery(Reporte.class);
            Root<Reporte> root = query.from(Reporte.class);
            query.select(root);
            query.where(_builder.equal(root.get("repoFKTelefono"), telefono));
            result = _em.createQuery(query).getResultList();
        } catch (NoResultException e) {
            _logger.error(String.format("Error ReporteDao.getReportsByPhone: No Result {%s}", e.getMessage()));
        } catch (Exception e) {
            _logger.error(String.format("Error ReporteDao.getReportsByPhone: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        return result;
    }

    public List<Reporte> getReportsByDate(Date date) {
        List<Reporte> result = null;
        _logger.debug(String.format("Get in ReporteDao.getReportsByDate: parameter {%s}", date.toString()));
        try {
            CriteriaQuery<Reporte> query = _builder.createQuery(Reporte.class);
            Root<Reporte> root = query.from(Reporte.class);
            query.select(root);
            query.where(_builder.equal(root.get("repoFecha"), date));
            result = _em.createQuery(query).getResultList();
        } catch (NoResultException e) {
            _logger.error(String.format("Error ReporteDao.getReportsByDate: No Result {%s}", e.getMessage()));
        } catch (Exception e) {
            _logger.error(String.format("Error ReporteDao.getReportsByDate: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        return result;
    }
}