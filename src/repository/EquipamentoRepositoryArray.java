package repository;

import java.util.ArrayList;
import java.util.List;
import entities.Equipamento;

public class EquipamentoRepositoryArray implements EquipamentoRepository {

    private Equipamento[] bancoVetor = new Equipamento[100];
    private int tamanho = 0;

    @Override
    public void cadastrar(Equipamento equipamento) {
        if (tamanho < bancoVetor.length) {
            bancoVetor[tamanho] = equipamento;
            tamanho++;
        } else {
            throw new RuntimeException("O banco de dados (Vetor) está cheio!");
        }
    }

    @Override
    public List<Equipamento> listar() {

        List<Equipamento> lista = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            lista.add(bancoVetor[i]);
        }
        return lista;
    }

    @Override
    public Equipamento buscarPorCodigo(int codigo) {
        for (int i = 0; i < tamanho; i++) {
            if (bancoVetor[i].getCodigo() == codigo) {
                return bancoVetor[i];
            }
        }
        return null;
    }

    @Override
    public void alterar(Equipamento equipamento) {

    }

    @Override
    public void excluir(int codigo) {
        for (int i = 0; i < tamanho; i++) {
            if (bancoVetor[i].getCodigo() == codigo) {
                bancoVetor[i] = bancoVetor[tamanho - 1];
                bancoVetor[tamanho - 1] = null;
                tamanho--;
                return;
            }
        }
    }
}