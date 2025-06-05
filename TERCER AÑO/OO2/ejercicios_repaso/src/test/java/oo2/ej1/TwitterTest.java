package oo2.ej1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;

public class TwitterTest {
    private Twitter twitter;
    private Usuario usuario;
    private Usuario otroUsuario;

    @BeforeEach
    void setUp() {
        twitter = new Twitter();
        usuario = twitter.agregarUsuario("testUser");
        otroUsuario = twitter.agregarUsuario("otroUser");
    }

    @Test
    void testAgregarUsuario() {
        assertNotNull(usuario);
        assertEquals("testUser", usuario.getScreenName());
        assertNull(twitter.agregarUsuario("testUser")); // Usuario duplicado
    }

    @Test
    void testEliminarUsuario() {
        usuario.postearTweet("Hello World");
        Tweet tweet = (Tweet) usuario.getTweets().get(0);
        ReTweet retweet = new ReTweet(otroUsuario, tweet);
        otroUsuario.getTweets().add(retweet);

        // Crear WeakReferences antes de eliminar
        WeakReference<Usuario> weakUsuario = new WeakReference<>(usuario);
        WeakReference<Tweet> weakTweet = new WeakReference<>(tweet);
        WeakReference<ReTweet> weakRetweet = new WeakReference<>(retweet);

        // Eliminar el usuario
        twitter.eliminarUsuario("testUser");

        // Eliminar referencias fuertes
        usuario = null;
        tweet = null;
        retweet = null;

        // Forzar el garbage collector
        System.gc();

        assertEquals(0, otroUsuario.getTweets().size());

        // Verificar que los objetos fueron recolectados
        assertNull(weakUsuario.get(), "El usuario debería haber sido recolectado");
        assertNull(weakTweet.get(), "El tweet debería haber sido recolectado");
        assertNull(weakRetweet.get(), "El retweet debería haber sido recolectado");
    }

    @Test
    void testEliminarUsuarioInexistente() {
        twitter.eliminarUsuario("nonExistentUser");
        assertEquals(2, twitter.getUsuarios().size());
    }

    @Test
    void testEliminarUsuarioEliminaRetweetsAsociados() {
        Usuario autor = twitter.agregarUsuario("autor");
        Usuario retweeter = twitter.agregarUsuario("retweeter");
        
        autor.postearTweet("texto original");
        Tweet tweet = (Tweet) autor.getTweets().get(0);
        retweeter.reTweet(tweet);
        ReTweet retweet = (ReTweet) retweeter.getTweets().get(0);
        
        assertTrue(retweeter.getTweets().contains(retweet));
        
        twitter.eliminarUsuario("autor");
        
        assertFalse(retweeter.getTweets().contains(retweet));
    }
}
