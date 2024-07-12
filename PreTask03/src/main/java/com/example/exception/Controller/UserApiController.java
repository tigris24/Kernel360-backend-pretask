package com.example.exception.Controller;

import com.example.exception.Model.Api;
import com.example.exception.Model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private static  List<UserResponse> userResponseLists = List.of(
            UserResponse.builder()
                    .id("1")
                    .age(10)
                    .name("홍길동")
                    .build(),
            UserResponse.builder()
                    .id("2")
                    .age(10)
                    .name("유관순")
                    .build()
    );

    @GetMapping("/id/{userId}")
    public Api<UserResponse> getUser(@PathVariable String userId){

/*        if(true) {
            throw new RuntimeException("message");
        }*/

         var user = userResponseLists.stream()
                 .filter(it -> it.getId().equals(userId))
                 .findFirst()
                 .get();

         Api<UserResponse> responseApi = Api.<UserResponse> builder()
                 .resultCode(String.valueOf(HttpStatus.OK.value()))
                 .resultMessage(HttpStatus.OK.name())
                 .data(user)
                 .build();




         return responseApi;
    }

}
