package com.example.kafkaTwitter.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafkaTwitter.model.Tweet;
import com.vdurmont.emoji.EmojiParser;


@Service
public class Consumer {
	
	@Autowired
	private TweetService tweetServ;
	
	@KafkaListener(topics="topic1", groupId="g1")
	public void consumeFromTopic(String message) {
		//System.out.println("Consumed message"+message);
		if(message.length()!=0) {
			JSONObject obj = new JSONObject(message.substring(message.indexOf('{')));
			JSONObject jsonObject = obj.getJSONObject("data");
			System.out.println("\n\n\t\t ");
			String text = (String) jsonObject.get("text");
			//System.out.println(text);
			//System.out.println("\n\n\t\t ");
			String tweet = text.trim()
	                // remove links
	                .replaceAll("http.*?[\\S]+", "")
	                // remove usernames
	                .replaceAll("@[\\S]+", "")
	                // replace hashtags by just words
	                .replaceAll("#", "")
	                // correct all multiple white spaces to a single white space
	                .replaceAll("[\\s]+", " ");
			String result = EmojiParser.removeAllEmojis(tweet);
			//System.out.println(result);
			
			NLP.init();
			int score = NLP.findSentiment(result);
			System.out.println(result + " : " + score);
			
			Tweet twt = new Tweet();
			twt.setTweet(result);
			twt.setScore(score);
			
			tweetServ.saveTweet(twt);
			
		}
	}
}