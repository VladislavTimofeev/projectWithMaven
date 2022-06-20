package by.iba.project.controller;

import by.iba.project.dto.UserDto;
import by.iba.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        UserDto resp = userService.save(userDto);

        return ResponseEntity.ok().body(resp);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> resp = userService.findAll();

        return ResponseEntity.ok().body(resp);
    }

    @PutMapping
    public ResponseEntity<UserDto> partialUpdate(@RequestBody UserDto userDto) {
        UserDto resp = userService.update(userDto);

        return ResponseEntity.ok().body(resp);
    }

}
