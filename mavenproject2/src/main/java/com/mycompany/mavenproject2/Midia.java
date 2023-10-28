
package com.mycompany.mavenproject2;

public class Midia {
    private static int contador = 1;
    private int identificador;
    private String tipo;
    private String titulo;
    private String genero;
    private int duracao;

    public Midia(int identificador, String tipo, String titulo, String genero, int duracao) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
    }


    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public String toString() {
    return "ID: " + identificador +
            ", Tipo: " + tipo +
            ", Título: " + titulo +
            ", Gênero: " + genero +
            ", Duração: " + duracao + " minutos";
}
}