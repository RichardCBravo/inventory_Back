package com.nexos.inventory.domain.service;

import com.nexos.inventory.domain.UserDto;
import com.nexos.inventory.domain.repository.UserDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDtoRepository userDtoRepository;

    public List<UserDto> getAll() {
        return userDtoRepository.getAll();
    }

    public Optional<UserDto> getUser(int userid){
        return userDtoRepository.getUser(userid);
    }

    public UserDto save(UserDto userDto){
        return userDtoRepository.save(userDto);
    }

    public boolean delete(int userId){
        return getUser(userId).map(userDto -> {
            userDtoRepository.delete(userId);
            return true;
        }).orElse(false);
    }
}
