package oo2.ej1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TweetTest {
    private Usuario autor;
    private Tweet tweet;

    @BeforeEach
    void setUp() {
        autor = new Usuario("testUser");
        tweet = new Tweet(autor, "Hello World");
    }

    @Test
    void testGetText() {
        assertEquals("Hello World", tweet.getText());
    }

    @Test
    void testGetAutor() {
        assertEquals(autor, tweet.getAutor());
    }

    @Test
    void testInvalidTweet() {
        assertThrows(IllegalArgumentException.class, () -> new Tweet(autor, ""));
        assertThrows(IllegalArgumentException.class, () -> new Tweet(autor, null));
        assertThrows(IllegalArgumentException.class, () -> new Tweet(autor, "a".repeat(281)));
    }

    @Test
    void testAgregarReferencia() {
        ReTweet retweet = new ReTweet(new Usuario("otroUser"), tweet);
        assertEquals(1, tweet.getReferencias().size());
        assertTrue(tweet.getReferencias().contains(retweet));
    }
}
