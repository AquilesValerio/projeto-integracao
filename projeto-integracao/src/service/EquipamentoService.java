package service;

import entities.Equipamento;
import repository.EquipamentoRepository;
import java.util.List;

public class EquipamentoService {

  // O Service agora depende apenas do "contrato" (Interface)
  private EquipamentoRepository repository;
  private int cont = 0;

  // Construtor: quem instanciar o Service vai decidir qual banco de dados usar
  public EquipamentoService(EquipamentoRepository repository) {
    this.repository = repository;
  }

  public Equipamento cadastrar(String nome, String patrimonio) {
    cont++;
    Equipamento equipamento = new Equipamento(cont, nome, patrimonio);

    // Delega o salvamento para o repositório
    repository.cadastrar(equipamento);
    return equipamento;
  }

  public List<Equipamento> listar() {
    return repository.listar();
  }

  public Equipamento buscarPorCodigo(int codigo) {
    Equipamento equipamento = repository.buscarPorCodigo(codigo);

    if (equipamento == null) {
      throw new IllegalArgumentException("Equipamento não encontrado.");
    }
    return equipamento;
  }

  public void alterar(int codigo, String novoNome, String novoPatrimonio) {
    // Reutiliza a busca para validar se existe
    Equipamento equipamento = buscarPorCodigo(codigo);

    equipamento.setNome(novoNome);
    equipamento.setPatrimonio(novoPatrimonio);

    // Atualiza no banco
    repository.alterar(equipamento);
  }

  public void excluir(int codigo) {
    // Valida se o equipamento existe antes de mandar excluir
    buscarPorCodigo(codigo);
    repository.excluir(codigo);
  }
}