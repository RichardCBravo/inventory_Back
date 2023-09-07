package com.nexos.inventory.domain.repository;

import com.nexos.inventory.domain.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserDtoRepository {
    List<UserDto> getAll();

    Optional<UserDto> getUser(int userId);

    UserDto save(UserDto userDto);

    void delete(int userId);
}
