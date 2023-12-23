package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ZonaSeguridadMapper extends BaseMapper<ZonaSeguridadDto, ZonaSeguridad>{

    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadMapper.class );
    private QuerellaMapper querellaMapper = new QuerellaMapper();

    @Override
    public ZonaSeguridad mapDtoToEntity(ZonaSeguridadDto dto){

        ZonaSeguridad entity = EntityFactory.createZonaSeguridad();

        _logger.debug( "Get in ZonaSeguridadMapper.mapDtoToEntity: dto {}", dto );

        entity.setZonSegNombre(dto.getName());

        if(Objects.nonNull(dto.getQuerella())){
            entity.setZonSegFKQuerella(querellaMapper.mapDtoToEntity(dto.getQuerella()));
        }

        _logger.debug( "Leaving ZonaSeguridadMapper.mapDtoToEntity: entity {}", entity );

        return entity;
    }

    @Override
    public ZonaSeguridadDto mapEntityToDto(ZonaSeguridad entity){

        ZonaSeguridadDto dto = new ZonaSeguridadDto();

        _logger.debug( "Get in ZonaSeguridadMapper.mapEntityToDto: entity {}", entity );

        dto.setName(entity.getZonSegNombre());

        if(Objects.nonNull(entity.getZonSegFKQuerella())){
            dto.setQuerella(querellaMapper.mapEntityToDto(entity.getZonSegFKQuerella()));
        }

        _logger.debug( "Leaving ZonaSeguridadMapper.mapEntityToDto: dto {}", dto );

        return dto;

    }

}
