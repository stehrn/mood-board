package com.github.stehrn.mood;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("user")
@AllArgsConstructor
@Data
@Builder
public class Mood implements Serializable {

    @Id
    private  String user;
    private  String mood;
}
