
package com.mycompany.mavenproject2;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    
        private CadastroControle cadastro;

    public MenuPrincipal(CadastroControle cadastro) {
        this.cadastro = cadastro;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1 – Clientes");
            System.out.println("2 – Mídias");
            System.out.println("3 – Relatórios");
            System.out.println("4 – Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuMidias();
                    break;
                case 3:
                    exibirRelatorios();
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 4);
    }

    public void menuClientes() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu Clientes:");
            System.out.println("1 – Incluir Cliente");
            System.out.println("2 – Alterar Cliente");
            System.out.println("3 – Excluir Cliente");
            System.out.println("4 – Consultar Cliente");
            System.out.println("5 – Listar Clientes");
            System.out.println("6 – Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    incluirCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    excluirCliente();
                    break;
                case 4:
                    consultarCliente();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 6);
    }

public void incluirCliente() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Nome: ");
    String nome = scanner.nextLine();

    if (nome.isEmpty()) {
        System.out.println("Nome não pode ser vazio.");
        return;
    }

    System.out.print("Data de Nascimento (DD/MM/AAAA): ");
    String dataNascimento = scanner.nextLine();

    System.out.print("Endereço: ");
    String endereco = scanner.nextLine();

    System.out.print("Telefone: ");
    String telefone = scanner.nextLine();

    System.out.print("Sexo (M/F): ");
    char sexo = scanner.nextLine().charAt(0);

    Cliente cliente = new Cliente(0, nome, dataNascimento, endereco, telefone, sexo);
    cadastro.adicionarCliente(cliente);

    System.out.println("Cliente cadastrado com sucesso. ID: " + cliente.getIdentificador());
}
    
    public void alterarCliente() {
        Scanner scanner = new Scanner(System.in);

    System.out.print("Informe o ID do cliente a ser alterado: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha

    Cliente cliente = cadastro.consultarClientePorId(id);

    if (cliente != null) {
        System.out.print("Nome (" + cliente.getNome() + "): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {
            cliente.setNome(nome);
        }

        System.out.print("Data de Nascimento (" + cliente.getDataNascimento() + "): ");
        String dataNascimento = scanner.nextLine();
        if (!dataNascimento.isEmpty()) {
            cliente.setDataNascimento(dataNascimento);
        }

        System.out.print("Endereço (" + cliente.getEndereco() + "): ");
        String endereco = scanner.nextLine();
        if (!endereco.isEmpty()) {
            cliente.setEndereco(endereco);
        }

        System.out.print("Telefone (" + cliente.getTelefone() + "): ");
        String telefone = scanner.nextLine();
        if (!telefone.isEmpty()) {
            cliente.setTelefone(telefone);
        }

        System.out.print("Sexo (" + cliente.getSexo() + "): ");
        String sexoInput = scanner.nextLine();
        if (!sexoInput.isEmpty()) {
            char sexo = sexoInput.charAt(0);
            cliente.setSexo(sexo);
        }

        cadastro.alterarCliente(cliente);
        System.out.println("Cliente alterado com sucesso.");
    } else {
        System.out.println("Cliente não encontrado.");
    }
    }

    public void excluirCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID do cliente a ser excluído: ");
        int id = scanner.nextInt();

        boolean sucesso = cadastro.excluirCliente(id);

        if (sucesso) {
            System.out.println("Cliente excluído com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void consultarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID do cliente a ser consultado: ");
        int id = scanner.nextInt();

        Cliente cliente = cadastro.consultarClientePorId(id);

        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("ID: " + cliente.getIdentificador());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Sexo: " + cliente.getSexo());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void listarClientes() {
        List<Cliente> clientes = cadastro.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\nLista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente.toString());
            }
        }
    }

    public void menuMidias() {
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
        System.out.println("\nMenu Mídias:");
        System.out.println("1 – Incluir Mídia");
        System.out.println("2 – Alterar Mídia");
        System.out.println("3 – Excluir Mídia");
        System.out.println("4 – Consultar Mídia");
        System.out.println("5 – Listar Mídias");
        System.out.println("6 – Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                incluirMidia();
                break;
            case 2:
                alterarMidia();
                break;
            case 3:
                excluirMidia();
                break;
            case 4:
                consultarMidia();
                break;
            case 5:
                listarMidias();
                break;
            case 6:
                System.out.println("Voltando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }

    } while (opcao != 6);
}

    public void incluirMidia() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Tipo (Fita de Vídeo, DVD ou Blu-ray): ");
    String tipo = scanner.nextLine();

    System.out.print("Título: ");
    String titulo = scanner.nextLine();

    System.out.print("Gênero: ");
    String genero = scanner.nextLine();

    System.out.print("Duração(em minutos): ");
    int duracao = Integer.parseInt(scanner.nextLine());

    Midia midia = new Midia(0, tipo, titulo, genero, duracao);
    cadastro.adicionarMidia(midia);

    System.out.println("Mídia cadastrada com sucesso. ID: " + midia.getIdentificador());
}

    public void alterarMidia() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID da mídia a ser alterada: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Midia midia = cadastro.consultarMidiaPorId(id);

        if (midia != null) {
            System.out.print("Título (" + midia.getTitulo() + "): ");
            String titulo = scanner.nextLine();
            if (!titulo.isEmpty()) {
                midia.setTitulo(titulo);
            }

            System.out.print("Gênero (" + midia.getGenero() + "): ");
            String genero = scanner.nextLine();
            if (!genero.isEmpty()) {
                midia.setGenero(genero);
            }

            System.out.print("Duração (" + midia.getDuracao() + "): ");
            String duracaoStr = scanner.nextLine();
            if (!duracaoStr.isEmpty()) {
                int duracao = Integer.parseInt(duracaoStr);
                midia.setDuracao(duracao);
            }

            cadastro.alterarMidia(midia);
            System.out.println("Mídia alterada com sucesso.");
        } else {
            System.out.println("Mídia não encontrada.");
        }
    }

    public void excluirMidia() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID da mídia a ser excluída: ");
        int id = scanner.nextInt();

        boolean sucesso = cadastro.excluirMidia(id);

        if (sucesso) {
            System.out.println("Mídia excluída com sucesso.");
        } else {
            System.out.println("Mídia não encontrada.");
        }
    }

    public void consultarMidia() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID da mídia a ser consultada: ");
        int id = scanner.nextInt();

        Midia midia = cadastro.consultarMidiaPorId(id);

        if (midia != null) {
            System.out.println("Mídia encontrada:");
            System.out.println("ID: " + midia.getIdentificador());
            System.out.println("Tipo: " + midia.getTipo());
            System.out.println("Título: " + midia.getTitulo());
            System.out.println("Gênero: " + midia.getGenero());
            System.out.println("Duração: " + midia.getDuracao() + " minutos");
        } else {
            System.out.println("Mídia não encontrada.");
        }
    }

    /**
     *
     */

    public void exibirRelatorios() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu Relatórios:");
            System.out.println("1 – Listar Clientes por Sexo");
            System.out.println("2 – Listar Mídias por Tipo");
            System.out.println("3 – Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarClientesPorSexo();
                    break;
                case 2:
                    listarMidiasPorTipo();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 3);
    }

    public void listarClientesPorSexo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o sexo (M/F): ");
        char sexo = scanner.nextLine().charAt(0);

        List<Cliente> clientes = cadastro.getClientesPorSexo(sexo);

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente do sexo " + sexo + " encontrado.");
        } else {
            System.out.println("\nClientes do sexo " + sexo + ":");
            for (Cliente cliente : clientes) {
                System.out.println(cliente.toString());
            }
        }
    }

    public void listarMidiasPorTipo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o tipo de mídia (Fita de Vídeo, DVD ou Blu-ray): ");
        String tipo = scanner.nextLine();

        List<Midia> midias = cadastro.getMidiasPorTipo(tipo);

        if (midias.isEmpty()) {
            System.out.println("Nenhuma mídia do tipo " + tipo + " encontrada.");
        } else {
            System.out.println("\nMídias do tipo " + tipo + ":");
            for (Midia midia : midias) {
                System.out.println(midia.toString());
            }
        }
    }
    public void listarMidias() {
    List<Midia> midias = cadastro.getMidias();
    if (midias.isEmpty()) {
        System.out.println("Nenhuma mídia cadastrada.");
    } else {
        System.out.println("\nRelatório de Mídias:");
        for (Midia midia : midias) {
            System.out.println("ID: " + midia.getIdentificador() +
                               ", Tipo: " + midia.getTipo() +
                               ", Título: " + midia.getTitulo() +
                               ", Gênero: " + midia.getGenero() +
                               ", Duração: " + midia.getDuracao() + " minutos");
        }
    }
}
}