package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.dtos.BaseDto;
import com.ucab.cmcapp.logic.dtos.ConexionDto;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class ConexionMapper extends BaseMapper<ConexionDto, Conexion>{

    private static Logger _logger = LoggerFactory.getLogger( ConexionMapper.class );
    private TelefonoMapper telefonoMapper = new TelefonoMapper();

    @Override
    public Conexion mapDtoToEntity(ConexionDto dto) throws ParseException {

        Conexion entity = EntityFactory.createConexion();

        _logger.debug("Get in ConexionMapper.mapDtoToEntity: dto {}", dto);

        entity.setConeFecha(BaseMapper.parseStringToDate(dto.getDate()));

        if (Objects.nonNull(dto.getTelefono())) {
            entity.setConeFKTelefono(telefonoMapper.mapDtoToEntity(dto.getTelefono()));
        }

        _logger.debug( "Leaving ConexionMapper.mapDtoToEntity: entity {}", entity );

        return entity;

    }

    @Override
    public ConexionDto mapEntityToDto(Conexion entity){

        ConexionDto dto = new ConexionDto();

        _logger.debug( "Get in ConexionMapper.mapEntityToDto: entity {}", entity );

        dto.setDate(BaseMapper.formatDateToString(entity.getConeFecha()));

        if(Objects.nonNull(entity.getConeFKTelefono())){
            dto.setTelefono(telefonoMapper.mapEntityToDto(entity.getConeFKTelefono()));
        }

        _logger.debug( "Leaving ConexionMapper.mapEntityToDto: dto {}", dto );

        return dto;
    }
}
