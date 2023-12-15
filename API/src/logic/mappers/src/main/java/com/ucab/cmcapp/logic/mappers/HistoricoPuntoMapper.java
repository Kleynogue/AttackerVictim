package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.HistoricoPunto;
import com.ucab.cmcapp.logic.dtos.HistoricoPuntoDto;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class HistoricoPuntoMapper extends BaseMapper{

    private static Logger _logger = LoggerFactory.getLogger( UserMapper.class );

    public static HistoricoPunto mapDtoToEntity(HistoricoPuntoDto dto) throws ParseException {

        HistoricoPunto entity = EntityFactory.createHistoricoPunto();

        _logger.debug( "Get in HistoricoPuntoMapper.mapDtoToEntity: dto {}", dto );

        entity.setHistPunFechaFin(BaseMapper.parseStringToDate(dto.getFechaFin()));
        entity.setHistPunFechaInicio(BaseMapper.parseStringToDate(dto.getFechaInicio()));

        if(Objects.nonNull(dto.getTelefono())){
            entity.setHistPunFKTelefono(TelefonoMapper.mapDtoToEntity(dto.getTelefono()));
        }

        if (Objects.nonNull(dto.getPuntoGeografico())){
            entity.setHistPunFKPuntoGeografico(PuntoGeograficoMapper.mapDtoToEntity(dto.getPuntoGeografico()));
        }

        _logger.debug( "Leaving HistoricoPuntoMapper.mapDtoToEntity: entity {}", entity );

        return entity;
    }

    public static HistoricoPuntoDto mapEntityToDto(HistoricoPunto entity){
        HistoricoPuntoDto dto =  new HistoricoPuntoDto();

        _logger.debug( "Get in HistoricoPuntoMapper.mapEntityToDto: entity {}", entity );

        dto.setFechaFin(formatDateToString(entity.getHistPunFechaFin()));
        dto.setFechaInicio(formatDateToString(entity.getHistPunFechaInicio()));

        if (Objects.nonNull(entity.getHistPunFKTelefono())){
            dto.setTelefono(TelefonoMapper.mapEntityToDto(entity.getHistPunFKTelefono()));
        }

        if (Objects.nonNull(entity.getHistPunFKPuntoGeografico())){
            dto.setPuntoGeografico(PuntoGeograficoMapper.mapEntityToDto(entity.getHistPunFKPuntoGeografico()));
        }

        _logger.debug( "Leaving HistoricoPuntoMapper.mapEntityToDto: dto {}", dto );

        return dto;

    }


}
