package site.todadak.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.todadak.web.dto.HelloResponseDto;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello() {
        return "Hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto HelloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
