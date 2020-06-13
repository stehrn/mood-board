package com.github.stehrn.mood;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MoodNotSetException extends RuntimeException {

    public MoodNotSetException(String message) {
        super(message);
    }
}
