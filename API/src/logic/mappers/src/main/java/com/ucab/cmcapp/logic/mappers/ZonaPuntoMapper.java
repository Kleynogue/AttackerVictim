package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.ZonaPunto;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.dtos.ZonaPuntoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ZonaPuntoMapper extends BaseMapper{

    private static Logger _logger = LoggerFactory.getLogger( ZonaPuntoMapper.class );

    public static ZonaPunto mapDtoToEntity(ZonaPuntoDto dto){

        ZonaPunto entity = EntityFactory.createZonaPunto();

        _logger.debug( "Get in ZonaPuntoMapper.mapDtoToEntity: dto {}", dto );

        if(Objects.nonNull(dto.getZona())){
            entity.setZonPunFKZonaSeguridad(ZonaSeguridadMapper.mapDtoToEntity(dto.getZona()));
        }
        if(Objects.nonNull(dto.getPunto())){
            entity.setZonPunFKPuntoGeografico(PuntoGeograficoMapper.mapDtoToEntity(dto.getPunto()));
        }

        _logger.debug( "Leaving ZonaPuntoMapper.mapDtoToEntity: entity {}", entity );

        return entity;
    }

    public static ZonaPuntoDto mapEntityToDto(ZonaPunto entity){
        ZonaPuntoDto dto = new ZonaPuntoDto();

        _logger.debug( "Get in ZonaPuntoMapper.mapEntityToDto: entity {}", entity );

        if (Objects.nonNull(entity.getZonPunFKZonaSeguridad())){
            dto.setZona(ZonaSeguridadMapper.mapEntityToDto(entity.getZonPunFKZonaSeguridad()));
        }
        if (Objects.nonNull(entity.getZonPunFKPuntoGeografico())){
            dto.setPunto(PuntoGeograficoMapper.mapEntityToDto(entity.getZonPunFKPuntoGeografico()));
        }

        _logger.debug( "Leaving ZonaPuntoMapper.mapEntityToDto: dto {}", dto );

        return dto;

    }

}
