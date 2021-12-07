package com.example.kafkaTwitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.kafkaTwitter.model.Tweet;
import com.example.kafkaTwitter.service.TweetService;

@Controller
public class TweetController {
	
	@Autowired 
	private TweetService tweetServ;
	
	@GetMapping("/viewAllTweets")
	public List<Tweet> getAll(){
		return tweetServ.getAllTweets();
	}
}
