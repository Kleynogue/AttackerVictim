package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.logic.dtos.ReporteDto;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class ReporteMapper extends BaseMapper{

    private static Logger _logger = LoggerFactory.getLogger( ReporteMapper.class );

    public static Reporte mapDtoToEntity(ReporteDto dto) throws ParseException {

        Reporte entity = EntityFactory.createReporte();

        _logger.debug( "Get in ReporteMapper.mapDtoToEntity: dto {}", dto );

        entity.setRepoFecha(BaseMapper.parseStringToDate(dto.getDate()));
        entity.setRepoTipo(dto.getType());

        if(Objects.nonNull(dto.getTelefono())) {
            entity.setRepoFKTelefono(TelefonoMapper.mapDtoToEntity(dto.getTelefono()));
        }

        if(Objects.nonNull(dto.getPuntoGeografico())){
            entity.setRepoFKPuntoGeografico(PuntoGeograficoMapper.mapDtoToEntity(dto.getPuntoGeografico()));
        }

        _logger.debug( "Leaving ReporteMapper.mapDtoToEntity: entity {}", entity );

        return entity;

    }

    public static ReporteDto mapEntityToDto(Reporte entity){

        ReporteDto dto = new ReporteDto();

        _logger.debug( "Get in ReporteMapper.mapEntityToDto: entity {}", entity );


        dto.setDate(BaseMapper.formatDateToString(entity.getRepoFecha()));
        dto.setType(entity.getRepoTipo());

        if (Objects.nonNull(entity.getRepoFKTelefono())){
            dto.setTelefono(TelefonoMapper.mapEntityToDto(entity.getRepoFKTelefono()));
        }

        if(Objects.nonNull(entity.getRepoFKPuntoGeografico())){
            dto.setPuntoGeografico(PuntoGeograficoMapper.mapEntityToDto(entity.getRepoFKPuntoGeografico()));
        }

        _logger.debug( "Leaving ReporteMapper.mapEntityToDto: dto {}", dto );

        return dto;

    }

}
