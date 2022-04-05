package me.jics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.annotation.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("/main")
@AllArgsConstructor
public class MainController {

    private final ObjectMapper mapper;

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }

    @Get("/user-wrong")
    public User getUserWrong() {
        var user = User.builder().name("test").build();
        log.info("User={}", JsonUtil.getStringFromObject(user));

        return user;
    }

    @Get("/user-fine")
    public User getUserFine() throws JsonProcessingException {
        var user = User.builder().name("test").build();
        log.info("User={}", mapper.writeValueAsString(user));

        return user;
    }

}