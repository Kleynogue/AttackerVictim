package com.ucab.cmcapp.logic.dtos;

public class PersonaDto extends BaseDto{
    private String name;
    private String lastName;
    private String address;


    public PersonaDto(){

    }

    public PersonaDto(long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonaDto{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", _id=" + _id +
                '}';
    }
}
