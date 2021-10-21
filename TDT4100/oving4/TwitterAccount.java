package objectstructures;

import java.util.*;

public class TwitterAccount {
	String username;
	
	ArrayList<TwitterAccount> followers = new ArrayList<TwitterAccount>();
	ArrayList<TwitterAccount> following = new ArrayList<TwitterAccount>();
	
	ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	TwitterAccount(String username) {
		this.username = username;
	}
	
	String getUserName() {
		return this.username;
	}
	
	void follow(TwitterAccount account) {
		this.following.add(account);
		account.followers.add(this);
	}
	
	void unfollow(TwitterAccount account) {
		this.following.remove(account);
		account.followers.remove(this);
	}
	
	boolean isFollowing(TwitterAccount account) {
		return this.following.contains(account);
	}
	
	boolean isFollowedBy(TwitterAccount account) {
		return this.followers.contains(account);
	}
	
	void tweet(String text) {
		this.tweets.add(new Tweet(this, text));
	}
	
	void retweet(Tweet tweet) {
		this.tweets.add(new Tweet(this, tweet));
	}
	
	Tweet getTweet(int i) {
		return this.tweets.get(this.tweets.size() - i);
	}
	
	int getTweetCount() {
		return this.tweets.size();
	}
	
	int getRetweetCount() {
		int retweets = 0;
		for (int i = 0; i < this.tweets.size(); i++) {
			retweets += this.getTweet(i+1).getRetweetCount();
		}
		
		return retweets;
	}
	
	
	
	
}
