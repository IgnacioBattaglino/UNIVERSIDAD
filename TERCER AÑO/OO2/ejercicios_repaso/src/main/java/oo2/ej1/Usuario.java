package oo2.ej1;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private String screenName;
    private List<Post> tweets;

    public Usuario(String screenName) {
        this.screenName = screenName;
        this.tweets = new java.util.ArrayList<>();
    }

    public void postearTweet(String text) {
        Tweet t = new Tweet(this, text);
        this.tweets.add(t);
    }

    public void reTweet(Tweet tweet) {
        ReTweet rt = new ReTweet(this, tweet);
        this.tweets.add(rt);
    }

    public String getScreenName() {
        return screenName;
    }

    public void eliminarTweets() {
        for (Post post : new ArrayList<>(tweets)) {
            if (post instanceof Tweet) { 
                post.eliminar();         
            }
        }
    }

    public void eliminarTweet(ReTweet reTweet) {
        this.tweets.remove(reTweet);
    }

    public List<Post> getTweets() {
        return tweets;
    }
}
