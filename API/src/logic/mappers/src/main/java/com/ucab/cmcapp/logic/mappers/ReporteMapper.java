package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Reporte;
import com.ucab.cmcapp.logic.dtos.ReporteDto;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class ReporteMapper extends BaseMapper<ReporteDto, Reporte>{

    private static Logger _logger = LoggerFactory.getLogger( ReporteMapper.class );
    private TelefonoMapper telefonoMapper = new TelefonoMapper();
    private PuntoGeograficoMapper puntoGeograficoMapper = new PuntoGeograficoMapper();

    @Override
    public Reporte mapDtoToEntity(ReporteDto dto) throws ParseException {

        Reporte entity = EntityFactory.createReporte();

        _logger.debug( "Get in ReporteMapper.mapDtoToEntity: dto {}", dto );

        entity.setRepoFecha(BaseMapper.parseStringToDate(dto.getDate()));
        entity.setRepoTipo(dto.getType());

        if(Objects.nonNull(dto.getTelefono())) {
            entity.setRepoFKTelefono(telefonoMapper.mapDtoToEntity(dto.getTelefono()));
        }

        if(Objects.nonNull(dto.getPuntoGeografico())){
            entity.setRepoFKPuntoGeografico(puntoGeograficoMapper.mapDtoToEntity(dto.getPuntoGeografico()));
        }

        _logger.debug( "Leaving ReporteMapper.mapDtoToEntity: entity {}", entity );

        return entity;

    }

    @Override
    public ReporteDto mapEntityToDto(Reporte entity){

        ReporteDto dto = new ReporteDto();

        _logger.debug( "Get in ReporteMapper.mapEntityToDto: entity {}", entity );


        dto.setDate(BaseMapper.formatDateToString(entity.getRepoFecha()));
        dto.setType(entity.getRepoTipo());

        if (Objects.nonNull(entity.getRepoFKTelefono())){
            dto.setTelefono(telefonoMapper.mapEntityToDto(entity.getRepoFKTelefono()));
        }

        if(Objects.nonNull(entity.getRepoFKPuntoGeografico())){
            dto.setPuntoGeografico(puntoGeograficoMapper.mapEntityToDto(entity.getRepoFKPuntoGeografico()));
        }

        _logger.debug( "Leaving ReporteMapper.mapEntityToDto: dto {}", dto );

        return dto;

    }

}
