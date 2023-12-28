package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class UsuarioMapper extends BaseMapper<UsuarioDto, Usuario>{

    private static Logger _logger = LoggerFactory.getLogger( UsuarioMapper.class );
    private PersonaMapper personaMapper = new PersonaMapper();

    @Override
    public Usuario mapDtoToEntity(UsuarioDto dto){
        Usuario entity = EntityFactory.createUsuario();
        UsuarioDao dao = DaoFactory.createUsuarioDao(new DBHandler());
        _logger.debug( "Get in UsuarioMapper.mapDtoToEntity: dto {}", dto );

        entity.setUsuaID(dto.getId());
        entity.setUsuaUsername(dto.getUsername());
        entity.setUsuaTipo(dto.getTipo());

        if(dto.getId()!=0)
            entity.setUsuaContrasena(dao.find(dto.getId(), Usuario.class).getUsuaContrasena());
        else
            entity.setUsuaContrasena("12345");

        if(Objects.nonNull(dto.getPersona())){
            entity.setUsuaFKPersona(personaMapper.mapDtoToEntity(dto.getPersona()));
        }

        _logger.debug( "Leaving UsuarioMapper.mapDtoToEntity: entity {}", entity );

        return entity;

    }

    @Override
    public UsuarioDto mapEntityToDto(Usuario entity){
        UsuarioDto dto = new UsuarioDto();

        _logger.debug( "Get in UsuarioMapper.mapEntityToDto: dto {}", dto );

        dto.setId(entity.getUsuaID());
        dto.setUsername(entity.getUsuaUsername());
        dto.setTipo(entity.getUsuaTipo());

        _logger.debug( "Leaving UsuarioMapper.mapEntityToDto: entity {}", entity );

        return dto;

    }

}
