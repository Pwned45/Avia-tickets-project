package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.UserDto;
import com.aviaticket.backend.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toClientsDTO(User clients);

    List<UserDto> toClientsDTOs(List<User> clients);

    User toClients(UserDto clientsDto);
}
