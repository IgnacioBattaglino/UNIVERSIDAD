package oo2.ej1;

import java.util.List;
import java.util.ArrayList;

public class Twitter {
    private List<Usuario> usuarios;

    public Twitter() {
        this.usuarios = new ArrayList<>();
    }

    private boolean existeUsuario(String screenName) {
        return usuarios.stream()
            .map(usuario -> usuario.getScreenName())
            .anyMatch(name -> name.equals(screenName));
    }

    public Usuario agregarUsuario(String screenName) {
        if (!existeUsuario(screenName)) {
            Usuario nuevoUsuario = new Usuario(screenName);
            usuarios.add(nuevoUsuario);
            return nuevoUsuario;
        }
        return null;
    }

    public void eliminarUsuario(String screenName) {
        Usuario usuarioAEliminar = buscarUsuario(screenName);
        if (usuarioAEliminar != null) {
            usuarioAEliminar.eliminarTweets();
            usuarios.remove(usuarioAEliminar);
        }
    }

    private Usuario buscarUsuario(String screenName) {
        return usuarios.stream()
            .filter(usuario -> usuario.getScreenName().equals(screenName))
            .findFirst()
            .orElse(null);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
