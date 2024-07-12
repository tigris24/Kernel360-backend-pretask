package com.example.exception;

import com.example.exception.Model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExceptionApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void contextLoads() throws JsonProcessingException {
/*
		UserRequest userRequest = new UserRequest();
		userRequest.setUserName("홍길동");
		userRequest.setUserAge(10);
		userRequest.setEmail("hong@gmail.com");
		userRequest.setIsKorean(true);

		var jsonObject = objectMapper.writeValueAsString(userRequest);
		System.out.println(jsonObject);
*/

        var json = "{\"user_name\":\"홍길동\", \"user_age\":10, \"email\":\"hong@gmail.com\", \"is_korean\":true}";

		System.out.println(json);

//		var dto = objectMapper.readValue(jsonObject, UserRequest.class);
        var dto = objectMapper.readValue(json, UserRequest.class);
        System.out.println(dto);

    }

}
