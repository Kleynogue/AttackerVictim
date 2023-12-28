package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.dtos.QuerellaDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuerellaMapper extends BaseMapper<QuerellaDto, Querella>{

    private static Logger _logger = LoggerFactory.getLogger( QuerellaMapper.class );

    @Override
    public Querella mapDtoToEntity(QuerellaDto dto){

        Querella entity = EntityFactory.createQuerella();

        _logger.debug( "Get in QuerellaMapper.mapDtoToEntity: dto {}", dto );

        entity.setQuerID(dto.getId());
        entity.setQuerDistanciaMin(dto.getDistanciaMin());
        entity.setQuerTiempoControl(dto.getTiempoControl());
        entity.setQuerStatus(dto.getStatus());

        _logger.debug( "Leaving QuerellaMapper.mapDtoToEntity: entity {}", entity );

        return entity;

    }

    @Override
    public QuerellaDto mapEntityToDto(Querella entity){

        QuerellaDto dto = new QuerellaDto();

        _logger.debug( "Get in QuerellaMapper.mapEntityToDto: entity {}", entity );

        dto.setId(entity.getQuerID());
        dto.setDistanciaMin(entity.getQuerDistanciaMin());
        dto.setTiempoControl(entity.getQuerTiempoControl());
        dto.setStatus(entity.getQuerStatus());

        _logger.debug( "Leaving QuerellaMapper.mapEntityToDto: dto {}", dto );

        return dto;

    }

}
