package com.example.kafkaTwitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkaTwitter.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long>{

}
