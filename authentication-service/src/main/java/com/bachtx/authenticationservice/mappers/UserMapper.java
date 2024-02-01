package com.bachtx.authenticationservice.mappers;

import com.bachtx.authenticationservice.dto.response.UserResponse;
import com.bachtx.authenticationservice.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({})
    UserResponse userToUserResponse(User user);
}
