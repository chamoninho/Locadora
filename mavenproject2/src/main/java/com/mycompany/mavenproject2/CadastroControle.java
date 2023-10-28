
package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class CadastroControle {
    private List<Cliente> clientes;
    private List<Midia> midias;
    private int proximoIdCliente;
    private int proximoIdMidia;

    public CadastroControle() {
        this.clientes = new ArrayList<>();
        this.midias = new ArrayList<>();
        this.proximoIdCliente = 1;
        this.proximoIdMidia = 1;
    }
    public void adicionarCliente(Cliente cliente) {
    if (clientes.size() >= 100) {
        System.out.println("Limite máximo de clientes atingido (100).");
        return;
    }
    cliente.setIdentificador(proximoIdCliente++);
    clientes.add(cliente);
}
public Cliente consultarClientePorId(int id) {
    for (Cliente cliente : clientes) {
        if (cliente.getIdentificador() == id) {
            return cliente;
        }
    }
    return null;
}

    /**
     *
     * @param midia
     */
public void adicionarMidia(Midia midia) {
    if (midias.size() >= 100) {
        System.out.println("Limite máximo de mídias atingido (100).");
        return;
    }
    int novoIdentificador = gerarNovoIdentificador();
    midia.setIdentificador(novoIdentificador);
    midias.add(midia);
}
    public Midia consultarMidiaPorId(int id) {
        for (Midia midia : midias) {
            if (midia.getIdentificador() == id) {
                return midia;
            }
        }
        return null;
    }

    public void alterarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdentificador() == cliente.getIdentificador()) {
                clientes.set(i, cliente);
                return;
            }
        }
    }

    public void alterarMidia(Midia midia) {
        for (int i = 0; i < midias.size(); i++) {
            if (midias.get(i).getIdentificador() == midia.getIdentificador()) {
                midias.set(i, midia);
                return;
            }
        }
    }

    public boolean excluirCliente(int id) {
        Cliente cliente = consultarClientePorId(id);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }

    public boolean excluirMidia(int id) {
        Midia midia = consultarMidiaPorId(id);
        if (midia != null) {
            midias.remove(midia);
            return true;
        }
        return false;
    }

    public List<Midia> getMidias() {
        return midias;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    
        public List<Cliente> getClientesPorSexo(char sexo) {
        List<Cliente> clientesPorSexo = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getSexo() == sexo) {
                clientesPorSexo.add(cliente);
            }
        }
        return clientesPorSexo;
    }

    public List<Midia> getMidiasPorTipo(String tipo) {
        List<Midia> midiasPorTipo = new ArrayList<>();
        for (Midia midia : midias) {
            if (midia.getTipo().equalsIgnoreCase(tipo)) {
                midiasPorTipo.add(midia);
            }
        }
        return midiasPorTipo;
    }
public void carregarDados() {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("dados_clientes_midias.csv"));

        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] partes = linha.split(",");
            if (partes[0].equals("C")) {
                Cliente cliente = new Cliente(Integer.parseInt(partes[1]), partes[2], partes[3], partes[4], partes[5], partes[6].charAt(0));
                clientes.add(cliente);
            } else if (partes[0].equals("M")) {
                Midia midia = new Midia(Integer.parseInt(partes[1]), partes[2], partes[3], partes[4], Integer.parseInt(partes[5]));
                midias.add(midia);
            }
        }

        reader.close();

        int maxIdCliente = clientes.stream().mapToInt(Cliente::getIdentificador).max().orElse(0);
        int maxIdMidia = midias.stream().mapToInt(Midia::getIdentificador).max().orElse(0);

        proximoIdCliente = Math.max(maxIdCliente, maxIdMidia) + 1;
        proximoIdMidia = proximoIdCliente; // Se desejar IDs únicos para clientes e mídias

        System.out.println("Dados carregados com sucesso.");
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Erro ao carregar dados.");
    }
}

    public void salvarDados() {
        try {
            FileWriter writer = new FileWriter("dados_clientes_midias.csv");

            // Escrever dados dos clientes
            for (Cliente cliente : clientes) {
                writer.write("C," + cliente.getIdentificador() + "," + cliente.getNome() + "," + cliente.getDataNascimento() + "," + cliente.getEndereco() + "," + cliente.getTelefone() + "," + cliente.getSexo() + "\n");
            }

            // Escrever dados das mídias
            for (Midia midia : midias) {
                writer.write("M," + midia.getIdentificador() + "," + midia.getTipo() + "," + midia.getTitulo() + "," + midia.getGenero() + "," + midia.getDuracao() + "\n");
            }

            writer.close();
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar dados.");
        }
    }   
private int gerarNovoIdentificador() {
    return proximoIdMidia++;
}
}