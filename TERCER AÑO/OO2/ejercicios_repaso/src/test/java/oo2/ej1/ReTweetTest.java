package oo2.ej1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReTweetTest {
    private Usuario autor;
    private Tweet originalTweet;
    private ReTweet retweet;

    @BeforeEach
    void setUp() {
        autor = new Usuario("testUser");
        originalTweet = new Tweet(new Usuario("otroUser"), "Original Tweet");
        retweet = new ReTweet(autor, originalTweet);
    }

    @Test
    void testGetText() {
        assertEquals("Original Tweet", retweet.getText());
    }

    @Test
    void testGetOrigen() {
        assertEquals(originalTweet, retweet.getOrigen());
    }
}
