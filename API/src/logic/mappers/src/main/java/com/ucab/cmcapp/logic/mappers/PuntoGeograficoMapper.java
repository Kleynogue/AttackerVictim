package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.logic.dtos.PuntoGeograficoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PuntoGeograficoMapper extends BaseMapper{

    private static Logger _logger = LoggerFactory.getLogger( PuntoGeograficoMapper.class );

    public static PuntoGeografico mapDtoToEntity(PuntoGeograficoDto dto){

        PuntoGeografico entity = EntityFactory.createPuntoGeografico();

        _logger.debug( "Get in PuntoGeograficoMapper.mapDtoToEntity: dto {}", dto );

        entity.setPunGeoLatitud(dto.getLatitude());
        entity.setPunGeoLongitud(dto.getLongitude());

        _logger.debug( "Leaving PuntoGeograficoMapper.mapDtoToEntity: entity {}", entity );

        return entity;

    }

    public static PuntoGeograficoDto mapEntityToDto(PuntoGeografico entity){

        PuntoGeograficoDto dto = new PuntoGeograficoDto();

        _logger.debug( "Get in PuntoGeograficoMapper.mapEntityToDto: entity {}", entity );

        dto.setLatitude(entity.getPunGeoLatitud());
        dto.setLongitude(entity.getPunGeoLongitud());

        _logger.debug( "Leaving PuntoGeograficoMapper.mapEntityToDto: dto {}", dto );

        return dto;

    }



}
