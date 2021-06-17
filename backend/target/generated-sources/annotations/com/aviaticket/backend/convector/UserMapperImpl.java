package com.aviaticket.backend.convector;

import com.aviaticket.backend.dto.UserDto;
import com.aviaticket.backend.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T22:17:43+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public UserDto toUserDTO(User clients) {
        if ( clients == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setLocationDto( locationMapper.toLocationDTO( clients.getLocation() ) );
        userDto.setIdUser( clients.getIdUser() );
        userDto.setRoles( clients.getRoles() );
        userDto.setName( clients.getName() );
        userDto.setLastName( clients.getLastName() );
        userDto.setBornDay( clients.getBornDay() );
        userDto.setLogin( clients.getLogin() );
        userDto.setPass( clients.getPass() );
        userDto.setEmail( clients.getEmail() );
        userDto.setPhone( clients.getPhone() );

        return userDto;
    }

    @Override
    public List<UserDto> toUserDTOs(List<User> clients) {
        if ( clients == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( clients.size() );
        for ( User user : clients ) {
            list.add( toUserDTO( user ) );
        }

        return list;
    }

    @Override
    public User toUser(UserDto clientsDto) {
        if ( clientsDto == null ) {
            return null;
        }

        User user = new User();

        user.setLocation( locationMapper.toLocation( clientsDto.getLocationDto() ) );
        user.setIdUser( clientsDto.getIdUser() );
        user.setRoles( clientsDto.getRoles() );
        user.setName( clientsDto.getName() );
        user.setLastName( clientsDto.getLastName() );
        user.setBornDay( clientsDto.getBornDay() );
        user.setLogin( clientsDto.getLogin() );
        user.setPass( clientsDto.getPass() );
        user.setEmail( clientsDto.getEmail() );
        user.setPhone( clientsDto.getPhone() );

        return user;
    }
}
