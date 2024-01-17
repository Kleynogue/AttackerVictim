package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.PuntoGeografico;
import com.ucab.cmcapp.logic.dtos.PuntoGeograficoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PuntoGeograficoMapper extends BaseMapper<PuntoGeograficoDto, PuntoGeografico>{

    private static Logger _logger = LoggerFactory.getLogger( PuntoGeograficoMapper.class );


    @Override
    public PuntoGeografico mapDtoToEntity(PuntoGeograficoDto dto){

        PuntoGeografico entity = EntityFactory.createPuntoGeografico();

        _logger.debug( "Get in PuntoGeograficoMapper.mapDtoToEntity: dto {}", dto );

        entity.setPunGeoID(dto.getId());
        entity.setPunGeoLatitud(dto.getLatitude());
        entity.setPunGeoLongitud(dto.getLongitude());
        entity.setPunGeoStatus(dto.getStatus());

        _logger.debug( "Leaving PuntoGeograficoMapper.mapDtoToEntity: entity {}", entity );

        return entity;

    }

    @Override
    public PuntoGeograficoDto mapEntityToDto(PuntoGeografico entity){

        PuntoGeograficoDto dto = new PuntoGeograficoDto();

        _logger.debug( "Get in PuntoGeograficoMapper.mapEntityToDto: entity {}", entity );

        dto.setId(entity.getPunGeoID());
        dto.setLatitude(entity.getPunGeoLatitud());
        dto.setLongitude(entity.getPunGeoLongitud());
        dto.setStatus(entity.getPunGeoStatus());

        _logger.debug( "Leaving PuntoGeograficoMapper.mapEntityToDto: dto {}", dto );

        return dto;

    }



}
