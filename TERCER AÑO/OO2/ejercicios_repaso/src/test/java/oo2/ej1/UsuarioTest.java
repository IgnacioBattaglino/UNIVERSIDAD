package oo2.ej1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("testUser");
    }

    @Test
    void testPostearTweet() {
        usuario.postearTweet("Hello World");
        assertEquals(1, usuario.getTweets().size());
        assertEquals("Hello World", usuario.getTweets().get(0).getText());
    }

    @Test
    void testReTweet() {
        Tweet originalTweet = new Tweet(new Usuario("otroUser"), "Original Tweet");
        usuario.reTweet(originalTweet);

        assertEquals(1, usuario.getTweets().size());
        assertEquals("Original Tweet", usuario.getTweets().get(0).getText());
    }

    @Test
    void testGetScreenName() {
        assertEquals("testUser", usuario.getScreenName());
    }
}
