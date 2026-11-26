package service;

import entities.Equipamento;
import repository.EquipamentoRepository;
import java.util.List;

public class EquipamentoService {

 
  private EquipamentoRepository repository;
  private int cont = 0;

 
  public EquipamentoService(EquipamentoRepository repository) {
    this.repository = repository;
  }

  public Equipamento cadastrar(String nome, String patrimonio) {
    cont++;
    Equipamento equipamento = new Equipamento(cont, nome, patrimonio);

   
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
    
    Equipamento equipamento = buscarPorCodigo(codigo);

    equipamento.setNome(novoNome);
    equipamento.setPatrimonio(novoPatrimonio);

   
    repository.alterar(equipamento);
  }

  public void excluir(int codigo) {
    
    buscarPorCodigo(codigo);
    repository.excluir(codigo);
  }
}
