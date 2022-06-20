package by.iba.project.service;

import by.iba.project.dto.UserDto;
import by.iba.project.entity.User;
import by.iba.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        User saved = userRepository.save(user);

        //added user surname and age

        return new UserDto(
                saved.getId(),
                saved.getLogin(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getEmail()
        );
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream().map(dbUser -> new UserDto(
                dbUser.getId(),
                dbUser.getLogin(),
                dbUser.getFirstName(),
                dbUser.getLastName(),
                dbUser.getEmail())).collect(Collectors.toList());
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new RuntimeException()); // TODO create exception
        user.setLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        User saved = userRepository.save(user);

        //added user surname and age

        return new UserDto(
                saved.getId(),
                saved.getLogin(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getEmail()
        );
    }

}

// Не конечная версия, а версия которая работает @ Nikita