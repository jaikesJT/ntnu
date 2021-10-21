package objectstructures;

public class Tweet {
	TwitterAccount owner;
	String text;
	int retweets = 0;
	
	Tweet original = null;
	
	Tweet(TwitterAccount account, String text) {
		this.owner = account;
		this.text = text;
	}
	
	Tweet(TwitterAccount account, Tweet tweet) throws IllegalArgumentException {
		if (account.equals(tweet.getOwner())) {
			throw new IllegalArgumentException("An account cannot retweet its own tweet.");
		}
		
		this.owner = account;
		this.original = tweet;
		
		while (this.original.getOriginalTweet() != null) {
			this.original = this.original.getOriginalTweet();
		}
		
		this.text = this.original.getText();
		this.original.retweets++;
	}
	
	String getText() {
		return this.text;
	}
	
	TwitterAccount getOwner() {
		return this.owner;
	}
	
	Tweet getOriginalTweet() {
		return this.original;
	}
	
	int getRetweetCount() {
		return this.retweets;
	}
	
}
	
	