
package com.mycompany.mavenproject2;

public class Cliente {
    private static int contadorIds = 1; // Adicionamos um contador de IDs estático
    private int identificador;    
    private String nome;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private char sexo;

public Cliente(int identificador, String nome, String dataNascimento, String endereco, String telefone, char sexo) {
    this.identificador = identificador;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.endereco = endereco;
    this.telefone = telefone;
    this.sexo = sexo;
}

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public String toString() {
    return "ID: " + identificador +
            ", Nome: " + nome +
            ", Data de Nascimento: " + dataNascimento +
            ", Endereço: " + endereco +
            ", Telefone: " + telefone +
            ", Sexo: " + sexo;
}
    
}
