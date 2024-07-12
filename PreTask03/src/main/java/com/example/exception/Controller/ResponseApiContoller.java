package com.example.exception.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiContoller {

   /* @GetMapping("")
    public ResponseEntity<UserRequest> user(){
        var request = new UserRequest();
        request.setUserName("홍길동");
        request.setUserAge(10);
        request.setEmail("hong@gmail.com");

        log.info("user: {}", request);

        var response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header("x-custom", "hi")
                .body(request);

        return response;
    }*/
}
