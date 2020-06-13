package com.github.stehrn.mood;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodRepository extends CrudRepository<Mood, String> {
}
