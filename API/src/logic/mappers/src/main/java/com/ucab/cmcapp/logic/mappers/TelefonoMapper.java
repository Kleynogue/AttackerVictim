package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class TelefonoMapper extends BaseMapper{

    private static Logger _logger = LoggerFactory.getLogger( TelefonoMapper.class );

    public static Telefono mapDtoToEntity(TelefonoDto dto) throws ParseException {

        Telefono entity = EntityFactory.createTelefono();

        _logger.debug( "Get in TelefonoMapper.mapDtoToEntity: dto {}", dto );

        entity.setTeleBluetooth(dto.getBluetooth());
        entity.setTeleFechaFin(BaseMapper.parseStringToDate(dto.getFechaFin()));
        entity.setTeleFechaInicio(BaseMapper.parseStringToDate(dto.getFechaInicio()));

        if(Objects.nonNull(dto.getUsuario())){
            entity.setTeleFKUsuario(UsuarioMapper.mapDtoToEntity(dto.getUsuario()));
        }

        if(Objects.nonNull(dto.getQuerella())){
            entity.setTeleFKQuerella(QuerellaMapper.mapDtoToEntity(dto.getQuerella()));
        }

        _logger.debug( "Leaving TelefonoMapper.mapDtoToEntity: entity {}", entity );

        return entity;

    }

    public static TelefonoDto mapEntityToDto(Telefono entity) {
        TelefonoDto dto = new TelefonoDto();

        _logger.debug( "Get in TelefonoMapper.mapEntityToDto: entity {}", entity );

        dto.setBluetooth(entity.getTeleBluetooth());
        dto.setFechaFin(BaseMapper.formatDateToString(entity.getTeleFechaFin()));
        dto.setFechaInicio(BaseMapper.formatDateToString(entity.getTeleFechaInicio()));

        if (Objects.nonNull(entity.getTeleFKUsuario())){
            dto.setUsuario(UsuarioMapper.mapEntityToDto(entity.getTeleFKUsuario()));
        }

        if(Objects.nonNull(entity.getTeleFKQuerella())){
            dto.setQuerella(QuerellaMapper.mapEntityToDto(entity.getTeleFKQuerella()));
        }

        _logger.debug( "Leaving TelefonoMapper.mapEntityToDto: dto {}", dto );
        return dto;
    }

}
