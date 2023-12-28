package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.ZonaPunto;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.dtos.ZonaPuntoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ZonaPuntoMapper extends BaseMapper<ZonaPuntoDto, ZonaPunto>{

    private static Logger _logger = LoggerFactory.getLogger( ZonaPuntoMapper.class );
    private ZonaSeguridadMapper zonaSeguridadMapper = new ZonaSeguridadMapper();
    private PuntoGeograficoMapper puntoGeograficoMapper = new PuntoGeograficoMapper();

    @Override
    public ZonaPunto mapDtoToEntity(ZonaPuntoDto dto){

        ZonaPunto entity = EntityFactory.createZonaPunto();

        _logger.debug( "Get in ZonaPuntoMapper.mapDtoToEntity: dto {}", dto );

        if(Objects.nonNull(dto.getZona())){
            entity.setZonPunFKZonaSeguridad(zonaSeguridadMapper.mapDtoToEntity(dto.getZona()));
        }
        if(Objects.nonNull(dto.getPunto())){
            entity.setZonPunFKPuntoGeografico(puntoGeograficoMapper.mapDtoToEntity(dto.getPunto()));
        }

        _logger.debug( "Leaving ZonaPuntoMapper.mapDtoToEntity: entity {}", entity );

        return entity;
    }

    @Override
    public ZonaPuntoDto mapEntityToDto(ZonaPunto entity){
        ZonaPuntoDto dto = new ZonaPuntoDto();

        _logger.debug( "Get in ZonaPuntoMapper.mapEntityToDto: entity {}", entity );

        if (Objects.nonNull(entity.getZonPunFKZonaSeguridad())){
            dto.setZona(zonaSeguridadMapper.mapEntityToDto(entity.getZonPunFKZonaSeguridad()));
        }
        if (Objects.nonNull(entity.getZonPunFKPuntoGeografico())){
            dto.setPunto(puntoGeograficoMapper.mapEntityToDto(entity.getZonPunFKPuntoGeografico()));
        }

        _logger.debug( "Leaving ZonaPuntoMapper.mapEntityToDto: dto {}", dto );

        return dto;

    }

}
