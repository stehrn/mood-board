package com.github.stehrn.mood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoodController {

    @Autowired
    private MoodService moodService;

    @GetMapping("/mood/user/{name}")
    public Mood getMood(@PathVariable(value = "name") String name) {
        return moodService.getMood(name);
    }

    @PutMapping("/mood/user/{name}")
    void setMood(@RequestBody String mood, @PathVariable String name) {
        moodService.setMood(name, mood);
    }
}
