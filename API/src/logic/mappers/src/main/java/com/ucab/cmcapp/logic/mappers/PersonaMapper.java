package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.dtos.PersonaDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaMapper extends BaseMapper<PersonaDto, Persona>{

    private static Logger _logger = LoggerFactory.getLogger( PersonaMapper.class );



    @Override
    public Persona mapDtoToEntity(PersonaDto dto){

        Persona entity = EntityFactory.createPersona();
        _logger.debug( "Get in PersonaMapper.mapDtoToEntity: dto {}", dto );

        entity.setPersID(dto.getId());
        entity.setPersNombre(dto.getName());
        entity.setPersApellido(dto.getLastName());
        entity.setPersDireccion(dto.getAddress());

        _logger.debug( "Leaving ParsonaMapper.mapDtoToEntity: entity {}", entity );

        return entity;
    }

    @Override
    public PersonaDto mapEntityToDto(Persona entity) {
        PersonaDto dto = new PersonaDto();

        _logger.debug("Get in PersonaMapper.mapEntityToDto: entity {}", entity);

        dto.setId(entity.getPersID());
        dto.setName(entity.getPersNombre());
        dto.setLastName(entity.getPersApellido());
        dto.setAddress(entity.getPersDireccion());

        _logger.debug("Leaving PersonaMapper.mapEntityToDto: dto {}", dto);

        return dto;

    }


}
