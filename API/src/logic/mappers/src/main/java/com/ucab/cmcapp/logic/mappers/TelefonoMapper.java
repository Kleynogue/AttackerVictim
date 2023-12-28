package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Telefono;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class TelefonoMapper extends BaseMapper<TelefonoDto, Telefono>{

    private static Logger _logger = LoggerFactory.getLogger( TelefonoMapper.class );
    private UsuarioMapper usuarioMapper = new UsuarioMapper();
    private QuerellaMapper querellaMapper = new QuerellaMapper();

    @Override
    public Telefono mapDtoToEntity(TelefonoDto dto) throws ParseException {

        Telefono entity = EntityFactory.createTelefono();

        _logger.debug( "Get in TelefonoMapper.mapDtoToEntity: dto {}", dto );

        entity.setTeleID(dto.getId());
        entity.setTeleBluetooth(dto.getBluetooth());
        entity.setTeleFechaFin(BaseMapper.parseStringToDate(dto.getFechaFin()));
        entity.setTeleFechaInicio(BaseMapper.parseStringToDate(dto.getFechaInicio()));

        if(Objects.nonNull(dto.getUsuario())){
            entity.setTeleFKUsuario(usuarioMapper.mapDtoToEntity(dto.getUsuario()));
        }

        if(Objects.nonNull(dto.getQuerella())){
            entity.setTeleFKQuerella(querellaMapper.mapDtoToEntity(dto.getQuerella()));
        }

        _logger.debug( "Leaving TelefonoMapper.mapDtoToEntity: entity {}", entity );

        return entity;

    }

    @Override
    public TelefonoDto mapEntityToDto(Telefono entity) {
        TelefonoDto dto = new TelefonoDto();

        _logger.debug( "Get in TelefonoMapper.mapEntityToDto: entity {}", entity );

        dto.setId(entity.getTeleID());
        dto.setBluetooth(entity.getTeleBluetooth());
        dto.setFechaFin(BaseMapper.formatDateToString(entity.getTeleFechaFin()));
        dto.setFechaInicio(BaseMapper.formatDateToString(entity.getTeleFechaInicio()));

        if (Objects.nonNull(entity.getTeleFKUsuario())){
            dto.setUsuario(usuarioMapper.mapEntityToDto(entity.getTeleFKUsuario()));
        }

        if(Objects.nonNull(entity.getTeleFKQuerella())){
            dto.setQuerella(querellaMapper.mapEntityToDto(entity.getTeleFKQuerella()));
        }

        _logger.debug( "Leaving TelefonoMapper.mapEntityToDto: dto {}", dto );
        return dto;
    }

}
