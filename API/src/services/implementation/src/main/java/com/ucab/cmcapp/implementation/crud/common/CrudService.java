package com.ucab.cmcapp.implementation.crud.common;

import com.ucab.cmcapp.common.exceptions.JsonValidationException;
import com.ucab.cmcapp.implementation.BaseService;
import com.ucab.cmcapp.logic.commands.common.atomic.GetEntitiesCommand;
import com.ucab.cmcapp.logic.commands.common.atomic.UpdateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.CreateEntityCommand;
import com.ucab.cmcapp.logic.commands.common.composite.GetEntityCommand;
import com.ucab.cmcapp.logic.mappers.BaseMapper;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.lang.reflect.Field;
import java.util.List;

public abstract class CrudService<T, K> extends BaseService {

    private static Logger _logger = LoggerFactory.getLogger( CrudService.class );

    @GET
    public List<T> getEntities(){
        List<T> response;
        GetEntitiesCommand<K> command = null;
        BaseMapper<T, K> mapper = getMapper();
        //region Instrumentation DEBUG
        _logger.debug( "Get in CrudService.getEntities" );
        //endregion

        try {
            command = getCreateGetEntities(new DBHandler());
            command.execute();
            response = mapper.ListEntityToDto(command.getReturnParam());
            _logger.info( "Response getEntities: {} ", response.toString());
        }catch (Exception e){
            _logger.error("error {} getting entities: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }finally {
            if(command != null)
                command.closeHandlerSession();
        }
        _logger.debug( "Leaving CrudService.getEntities" );
        return response;
    }

    @GET
    @Path("/{id}")
    public T getEntity(@PathParam("id") long id){

        K entity;
        T response;
        GetEntityCommand<K> command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in CrudService.getEntity" );
        //endregion

        try
        {
            BaseMapper<T, K> mapper = getMapper();
            entity = mapper.mapDtoToEntity( getDto(id) );
            command = getCreateGetEntity(entity);
            command.execute();
            response = mapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getEntity: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting entity {}: {}", e.getMessage(), id, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UserService.getUser" );
        return response;

    }

    @POST
    public T addEntity( T dto )
    {
        K entity;
        T response;
        CreateEntityCommand<K> command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in CrudService.addEntity" );
        //endregion

        try
        {
            BaseMapper<T, K> mapper = getMapper();
            entity = mapper.mapDtoToEntity( dto );
            command = getCreateCreateEntity(entity);
            command.execute();
            response = mapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addEntity: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding entity: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
            _logger.debug( "Leaving CrudService.addEntity" );
        }
        return response;
    }

    @POST
    @Path("/update")
    public T updateEntity(T dto){
        K entity;
        T response;
        UpdateEntityCommand<K> command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in CrudService.addEntity" );
        //endregion

        try
        {
            validateJson(dto);

            BaseMapper<T, K> mapper = getMapper();
            entity = mapper.mapDtoToEntity( dto );
            command = getCreateUpdateEntity(entity);
            command.execute();
            response = mapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response updateEntity: {} ", response );
        }
        catch (JsonValidationException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("Validation error: " + e.getMessage())
                    .build());
        }
        catch ( Exception e )
        {
            _logger.error("error {} updating entity {}: {}", e.getMessage(), dto.toString(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
            _logger.debug( "Leaving CrudService.updateEntity" );
        }
        return response;
    }

    private void validateJson(T dto) throws JsonValidationException {
        try {
            validateFields(dto);
        } catch (IllegalAccessException e) {
            throw new JsonValidationException("Error accessing fields: " + e.getMessage());
        }
    }

    protected void validateFields(Object obj) throws IllegalAccessException, JsonValidationException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (value == null) {
                throw new JsonValidationException("Field '" + field.getName() + "' has a null value.");
            }
        }
    }

    protected abstract UpdateEntityCommand<K> getCreateUpdateEntity(K entity);


    protected abstract CreateEntityCommand<K> getCreateCreateEntity(K entity);

    protected abstract T getDto(long id);

    protected abstract GetEntitiesCommand<K> getCreateGetEntities(DBHandler dbHandler);
    protected abstract GetEntityCommand<K> getCreateGetEntity(K entity);

    protected abstract BaseMapper<T, K> getMapper();

}
