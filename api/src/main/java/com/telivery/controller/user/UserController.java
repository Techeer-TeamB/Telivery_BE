package com.telivery.controller.user;

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
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    // 사용 예시입니다.
    // 실제 API 개발 할 때는 generic을 리턴 DTO 등으로 대체합니다.
    @GetMapping(value = "/{userId}")
    public ResponseEntity<?> test (
            @PathVariable final long userId
    ) {
        if (userId > 10) throw new UserNotFoundException();
        return new ResponseEntity<>("안녕 나는 exception 테스트용 컨트롤러야", HttpStatus.OK);
    }
}
