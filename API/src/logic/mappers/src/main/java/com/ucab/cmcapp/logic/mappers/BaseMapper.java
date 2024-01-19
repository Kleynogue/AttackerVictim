package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.logic.dtos.BaseDto;
import com.ucab.cmcapp.properties.Registry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BaseMapper<T, K>
{
    public static Date parseStringToDate( String date ) throws ParseException
    {
        SimpleDateFormat formatter =  new SimpleDateFormat(
                Registry.getInstance().getProperty( Registry.DATE_FORMAT ));

        return formatter.parse( date );
    }

    public static String formatDateToString( Date dateTime )
    {
        SimpleDateFormat formatter = new SimpleDateFormat(
                Registry.getInstance().getProperty( Registry.DATE_FORMAT ));

        return formatter.format( dateTime );
    }

    public List<T> ListEntityToDto(List<K> entities){
        List<T> dtos = new ArrayList<>();
        for (K entity: entities){
            dtos.add(mapEntityToDto(entity));
        }
        
        return dtos;
    }

    public abstract K mapDtoToEntity(T dto) throws ParseException;
    public abstract T mapEntityToDto(K entity);

}
