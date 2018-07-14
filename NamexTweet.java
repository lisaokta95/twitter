/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LISA OKTA
 */
import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "tjXcjDUbRoDtDyHS5aSLotuwC";
    private final static String CONSUMER_KEY_SECRET = "jBAD9aT46kgewpPoWEo1ZstNvhdVwRY6scsrnPeqiS4YQEq6Os";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "fh1MM8oWqlHD1OTN0qkMajd7YWD2qLgCZCdjLbxm2UR6A";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "950198371028910080-SGFdQrfX86AGXLwH5qgs1F8rh5ci4dU";
    }
     public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
