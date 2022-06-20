package by.iba.project.service;

import by.iba.project.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);

    List<UserDto> findAll();

    UserDto update(UserDto userDto);
}

