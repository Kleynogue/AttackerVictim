package com.ucab.cmcapp.logic.dtos;

public class ZonaSeguridadDto extends BaseDto{

    private String name;
    private QuerellaDto querella;


    public ZonaSeguridadDto(){

    }

    public ZonaSeguridadDto(long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuerellaDto getQuerella() {
        return querella;
    }

    public void setQuerella(QuerellaDto querella) {
        this.querella = querella;
    }

    @Override
    public String toString() {
        return "ZonaSeguridadDto{" +
                "name='" + name + '\'' +
                ", querella=" + querella +
                ", _id=" + _id +
                '}';
    }
}
