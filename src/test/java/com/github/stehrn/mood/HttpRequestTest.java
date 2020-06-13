package com.github.stehrn.mood;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TestRedisConfiguration.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Test GET /user/{name}/mood
     */
    @Test
    public void notFoundCodeReturnedWhenMoodNotSetForUser()  {
        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/user/stehrn/mood",
                Mood.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    /**
     * Test PUT /user/{name}/mood "<current mood>"
     */
    @Test
    public void setMood()  {
        String mood  = "happy";
        String user  = "stehrn";

        restTemplate.put("http://localhost:" + port + "/mood/user/" + user, mood,
                String.class);

        Mood expected = new Mood(user, mood);
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/mood/user/" + user,
                Mood.class)).isEqualTo(expected);
    }
}