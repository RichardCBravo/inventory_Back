package com.nexos.inventory.persistence.mapper;

import com.nexos.inventory.domain.UserDto;
import com.nexos.inventory.persistence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = PositionMapper.class)
public interface UserMapper {
    UserDto toUserDto(User user);
    List<UserDto> toUsersDto(List<User> users);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    User toUser(UserDto userDto);
}
