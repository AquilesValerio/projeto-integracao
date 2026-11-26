package entities;

public class Equipamento {

  private int codigo;
  private String patrimonio;
  private String nome;

  public Equipamento() {
  }

  public Equipamento(int codigo, String nome, String patrimonio) {
    this.codigo = codigo;
    this.nome = nome;
    this.patrimonio = patrimonio;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getPatrimonio() {
    return patrimonio;
  }

  public void setPatrimonio(String patrimonio) {
    this.patrimonio = patrimonio;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public String toString() {
    return "Equipamento: " + nome + " || " + "cod: " + codigo + " || " + "Patrimonio " + patrimonio;
  }

}
