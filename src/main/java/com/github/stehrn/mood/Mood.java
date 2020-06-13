package com.github.stehrn.mood;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.io.Serializable;

@KeySpace("moods")
@AllArgsConstructor
@Data
@Builder
public class Mood implements Serializable {

    @Id
    private  String user;
    private  String mood;
}
