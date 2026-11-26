package repository;

import java.util.List;
import entities.Equipamento;

public interface EquipamentoRepository {

    void cadastrar(Equipamento equipamento);

    List<Equipamento> listar();

    Equipamento buscarPorCodigo(int codigo);

    void alterar(Equipamento equipamento);

    void excluir(int codigo);
}