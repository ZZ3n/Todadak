package site.todadak.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HelloResponseDtoTest {
    @Test
    public void lombokDtoTest() {
        String name = "박재현";
        int amount = 10000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);


        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}