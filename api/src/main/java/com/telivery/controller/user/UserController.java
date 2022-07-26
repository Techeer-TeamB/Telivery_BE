package com.telivery.controller.user;

import com.telivery.persistence.user.UserService;
import com.telivery.persistence.user.dto.UserInfoDto;
import com.telivery.persistence.user.entity.User;
import com.telivery.persistence.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/info")
    public ResponseEntity<UserInfoDto> test (
        @CurrentUser final User user
    ) {
        return new ResponseEntity<>(new UserInfoDto(user), HttpStatus.OK);
    }
}
