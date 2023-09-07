package com.nexos.inventory.persistence;

import com.nexos.inventory.domain.UserDto;
import com.nexos.inventory.domain.repository.UserDtoRepository;
import com.nexos.inventory.persistence.crud.UserCrudRepository;
import com.nexos.inventory.persistence.entity.User;
import com.nexos.inventory.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements UserDtoRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserDto> getAll() {
        List<User> users = (List<User>) userCrudRepository.findAll();
        return mapper.toUsersDto(users);
    }

    @Override
    public Optional<UserDto> getUser(int userId) {
        return userCrudRepository.findById(userId).map(user -> mapper.toUserDto(user));
    }

    @Override
    public UserDto save(UserDto userDto) {
        return mapper.toUserDto(userCrudRepository.save(mapper.toUser(userDto)));
    }

    @Override
    public void delete(int userId) {
        userCrudRepository.deleteById(userId);
    }
}
