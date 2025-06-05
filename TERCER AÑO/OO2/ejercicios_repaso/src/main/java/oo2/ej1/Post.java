package oo2.ej1;

public abstract class Post {
    protected Usuario autor;

    public Post(Usuario autor) {
        this.autor = autor;
    }

    public abstract String getText();

    public abstract void eliminar();

    public Usuario getAutor() {
        return autor;
    }
}
