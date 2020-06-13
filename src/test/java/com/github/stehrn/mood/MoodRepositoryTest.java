package com.github.stehrn.mood;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
public class MoodRepositoryTest {

    @Autowired
    private MoodRepository repository;

    @Test
    public void saveMood() {
        assertThat(repository.findById("stehrn").isPresent()).isFalse();

        Mood mood = Mood.builder().user("stehrn").mood("happy").build();
        assertThat(repository.save(mood)).isNotNull();

        Optional<Mood> search = repository.findById("stehrn");
        assertThat(search.isPresent()).isTrue();
        assertThat(search.get()).isEqualTo(mood);
    }
}
