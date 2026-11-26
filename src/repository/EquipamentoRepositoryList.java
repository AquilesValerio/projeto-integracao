package repository;

import java.util.ArrayList;
import java.util.List;
import entities.Equipamento;

public class EquipamentoRepositoryList implements EquipamentoRepository {

    private List<Equipamento> bancoMemoria = new ArrayList<>();

    @Override
    public void cadastrar(Equipamento equipamento) {
        bancoMemoria.add(equipamento);
    }

    @Override
    public List<Equipamento> listar() {
        return bancoMemoria;
    }

    @Override
    public Equipamento buscarPorCodigo(int codigo) {
        for (Equipamento equipamento : bancoMemoria) {
            if (equipamento.getCodigo() == codigo) {
                return equipamento;
            }
        }
        return null;
    }

    @Override
    public void alterar(Equipamento equipamento) {

    }

    @Override
    public void excluir(int codigo) {
        Equipamento equipamento = buscarPorCodigo(codigo);
        if (equipamento != null) {
            bancoMemoria.remove(equipamento);
        }
    }
}