package com.example.gameflix;

//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
class GameFlixApplicationTests {

    @Test
    void contextLoads() {
    }

}
