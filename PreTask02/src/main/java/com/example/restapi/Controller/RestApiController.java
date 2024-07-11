package com.example.restapi.Controller;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/hello")
    public String hello() {

        var html = "<html><body><h1>Hello Spring Boot </h1></body></html>";

        return html;
    }


    @GetMapping("/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(@PathVariable(name = "message") String msg,
                       @PathVariable int age,
                       @PathVariable boolean isMan) {
        System.out.println("echo message: " + msg);
        System.out.println("echo age: " + age);
        System.out.println("echo isMan: " + isMan);
        return msg.toUpperCase();
    }

    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping("/book")
    public void queryParam(@RequestParam String category,
                           @RequestParam String issuedYear,
                           @RequestParam(name = "issued-month") String issuedMonth,
                           @RequestParam(name = "issuedDay") String issuedDay
    ) {
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    // http://localhost:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    @GetMapping("/book2")
    public void queryParamDto(BookQueryParam bookQueryParam) {
        System.out.println(bookQueryParam);
    }

    @GetMapping("/calc")
    public void queryParamCalc(@RequestParam int first, @RequestParam int second, @RequestParam boolean check) {
        System.out.println(first + second);
        System.out.println(first * second);
        System.out.println(check);
    }
    @DeleteMapping(path = {"/user/{userName}/delete", "/del"})
    public void delete(@PathVariable String userName) {
        log.info("user-name:{}", userName);

    }



}
