package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class UsuarioMapper extends BaseMapper{

    private static Logger _logger = LoggerFactory.getLogger( UsuarioMapper.class );

    public static Usuario mapDtoToEntity(UsuarioDto dto){
        Usuario entity = EntityFactory.createUsuario();

        _logger.debug( "Get in UsuarioMapper.mapDtoToEntity: dto {}", dto );

        entity.setUsuaUsername(dto.getUsername());
        entity.setUsuaContrasena(dto.getContrasena());
        entity.setUsuaTipo(dto.getTipo());

        if(Objects.nonNull(dto.getPersona())){
            entity.setUsuaFKPersona(PersonaMapper.mapDtoToEntity(dto.getPersona()));
        }

        _logger.debug( "Leaving UsuarioMapper.mapDtoToEntity: entity {}", entity );

        return entity;

    }

    public static UsuarioDto mapEntityToDto(Usuario entity){
        UsuarioDto dto = new UsuarioDto();

        _logger.debug( "Get in UsuarioMapper.mapEntityToDto: dto {}", dto );

        dto.setUsername(entity.getUsuaUsername());
        dto.setTipo(entity.getUsuaTipo());

        _logger.debug( "Leaving UsuarioMapper.mapEntityToDto: entity {}", entity );

        return dto;

    }

}
