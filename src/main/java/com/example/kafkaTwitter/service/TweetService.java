package com.example.kafkaTwitter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kafkaTwitter.model.Tweet;
import com.example.kafkaTwitter.repository.TweetRepository;

@Service
public class TweetService {
	@Autowired
	private TweetRepository tweetRepo;
	
	public List<Tweet> getAllTweets(){
		return tweetRepo.findAll();
	}
	
	public void saveTweet(Tweet tweet) {
		this.tweetRepo.save(tweet);
	}
}
