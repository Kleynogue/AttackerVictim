package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.persona.atomic.AddPersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByFullNameCommand;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CommandFactory
{

    public static GetUserCommand createGetUserCommand(User user)
    {
        return new GetUserCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user)
    {
        return new GetUserByEmailCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user, DBHandler handler)
    {
        return new GetUserByEmailCommand(user, handler);
    }

    public static GetUserByIdCommand createGetUserByIdCommand (DBHandler handler, long userId )
    {
        return new GetUserByIdCommand(handler, userId);
    }

    public static AddUserCommand createAddUserCommand(User user, DBHandler handler)
    {
        return new AddUserCommand(user, handler);
    }

    public static AddUserCommand createAddUserCommand(User user)
    {
        return new AddUserCommand(user);
    }

    public static CreateUserCommand createCreateUserCommand(User user)
    {
        return new CreateUserCommand(user);
    }

    public static AddPersonaCommand createAddPersonaCommand(Persona persona) { return new AddPersonaCommand(persona);}

    public static AddPersonaCommand createAddPersonaCommand(Persona persona, DBHandler handler) { return new AddPersonaCommand(persona, handler);}

    public static GetPersonaByFullNameCommand createGetPersonaByFullNameCommand(Persona persona) { return new GetPersonaByFullNameCommand(persona);}

    public static GetPersonaByFullNameCommand createGetPersonaByFullNameCommand(Persona persona, DBHandler handler) { return new GetPersonaByFullNameCommand(persona, handler);}

    public static GetPersonaByIdCommand createGetPersonaByIdCommand(long id) {return new GetPersonaByIdCommand(id);}
}
