import java.util.ArrayList;
import java.util.Scanner;

import entities.Equipamento;
import service.EquipamentoService;

public class App {

  private static Scanner scanner = criarScanner();
  private static EquipamentoService service = new EquipamentoService();

  public static void main(String[] args) {
    int opcao = -1;

    while (opcao != 0) {
      mostrarMenu();
      opcao = lerNumero("Escolha uma opção: ");

      try {
        if (opcao == 1) {
          cadastrar();
        } else if (opcao == 2) {
          listar();
        } else if (opcao == 3) {
          buscar();
        } else if (opcao == 4) {
          alterar();
        } else if (opcao == 5) {
          excluir();
        } else if (opcao == 0) {
          System.out.println("Encerrando o EmprestaLab. Até logo!");
        } else {
          System.out.println("Opção inválida. Digite um número de 0 a 5.");
        }
      } catch (IllegalArgumentException e) {
        System.out.println("Erro: " + e.getMessage());
      }
    }
  }

  private static void mostrarMenu() {
    System.out.println();
    System.out.println("===== EMPRESTALAB =====");
    System.out.println("1. Cadastrar equipamento");
    System.out.println("2. Listar equipamentos");
    System.out.println("3. Buscar equipamento por código");
    System.out.println("4. Alterar equipamento");
    System.out.println("5. Excluir equipamento");
    System.out.println("0. Sair");
  }

  private static void cadastrar() {
    String nome = lerTexto("Nome: ");
    String patrimonio = lerTexto("Patrimônio: ");

    Equipamento equipamento = service.cadastrar(nome, patrimonio);
    System.out.println("Equipamento cadastrado com sucesso! Código: " + equipamento.getCodigo());
  }

  private static void listar() {
    ArrayList<Equipamento> equipamentos = service.listar();

    if (equipamentos.isEmpty()) {
      System.out.println("Nenhum equipamento cadastrado.");
    } else {
      for (Equipamento equipamento : equipamentos) {
        System.out.println(equipamento);
      }
    }
  }

  private static void buscar() {
    int codigo = lerNumero("Código do equipamento: ");
    System.out.println(service.buscarPorCodigo(codigo));
  }

  private static void alterar() {
    int codigo = lerNumero("Código do equipamento: ");

    System.out.println("Atual: " + service.buscarPorCodigo(codigo));

    String novoNome = lerTexto("Novo nome: ");
    String novoPatrimonio = lerTexto("Novo patrimônio: ");

    service.alterar(codigo, novoNome, novoPatrimonio);
    System.out.println("Equipamento alterado com sucesso!");
  }

  private static void excluir() {
    int codigo = lerNumero("Código do equipamento: ");

    Equipamento equipamento = service.buscarPorCodigo(codigo);
    String resposta = lerTexto("Excluir \"" + equipamento.getNome() + "\"? (S/N): ");

    if (resposta.trim().equalsIgnoreCase("S")) {
      service.excluir(codigo);
      System.out.println("Equipamento excluído com sucesso!");
    } else {
      System.out.println("Exclusão cancelada.");
    }
  }

  private static String lerTexto(String pergunta) {
    System.out.print(pergunta);
    if (!scanner.hasNextLine()) {
      return "";
    }
    return scanner.nextLine();
  }

  private static int lerNumero(String pergunta) {
    System.out.print(pergunta);
    if (!scanner.hasNextLine()) {
      return 0;
    }
    String texto = scanner.nextLine().trim();
    try {
      return Integer.parseInt(texto);
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  private static Scanner criarScanner() {
    if (System.console() != null) {
      return new Scanner(System.in, System.console().charset());
    }
    return new Scanner(System.in);
  }
}
