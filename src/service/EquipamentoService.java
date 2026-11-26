package service;

import java.util.ArrayList;

import entities.Equipamento;

public class EquipamentoService {

  private ArrayList<Equipamento> bancoMemoria = new ArrayList<>();
  private int cont = 0;

  public Equipamento cadastrar(String nome, String patrimonio) {
    cont++;
    Equipamento equipamento = new Equipamento(cont, nome, patrimonio);
    bancoMemoria.add(equipamento);
    return equipamento;
  }

  public ArrayList<Equipamento> listar() {
    return bancoMemoria;
  }

  public Equipamento buscarPorCodigo(int codigo) {
    for (Equipamento equipamento : bancoMemoria) {
      if (equipamento.getCodigo() == codigo) {
        return equipamento;
      }
    }
    throw new IllegalArgumentException("Equipamento não encontrado.");
  }

  public void alterar(int codigo, String novoNome, String novoPatrimonio) {
    Equipamento equipamento = buscarPorCodigo(codigo);
    equipamento.setNome(novoNome);
    equipamento.setPatrimonio(novoPatrimonio);
  }

  public void excluir(int codigo) {
    Equipamento equipamento = buscarPorCodigo(codigo);
    bancoMemoria.remove(equipamento);
  }

}
