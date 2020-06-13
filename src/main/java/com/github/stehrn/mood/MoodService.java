package com.github.stehrn.mood;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
class MoodService {

    @Value("${mood_not_found_message}")
    private String moodNotFoundMessage;

    private MoodRepository moodRepository;

    MoodService(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    Mood getMood(String user) {
        Optional<Mood> mood = moodRepository.findById(user);
        if(!mood.isPresent()) {
            throw new MoodNotSetException(moodNotFoundMessage);
        }
        return mood.get();
    }

    Mood setMood(String user, String mood) {
        log.info("Setting mood for {} to {}", user, mood);
        return moodRepository.save(Mood.builder().user(user).mood(mood).build());
    }
}
