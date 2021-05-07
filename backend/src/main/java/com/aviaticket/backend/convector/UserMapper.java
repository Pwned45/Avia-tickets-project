package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.UserDto;
import com.aviaticket.backend.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {LocationMapper.class})
public interface UserMapper {

    @Mapping(source = "location", target = "locationDto")
    UserDto toUserDTO(User clients);

    List<UserDto> toUserDTOs(List<User> clients);

    @Mapping(target = "location", source = "locationDto")
    User toUser(UserDto clientsDto);
}
