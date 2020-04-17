/**
 * @author Lucas Pereira Torres de Araújo, 384364
 * Universidade Federal do Ceará - Técnicas de Programação I, 2017.1
 */

public class Pessoa {
  String nome;
  int idade;

  Pessoa() {
  }

  Pessoa (String nome, int idade) {
    setNome(nome);
    setIdade(idade);
  }

  void setNome (String pnome) {
    nome = pnome;
  }

  String getNome () {
    return nome;
  }

  void setIdade (int pIdade) {
    idade = pIdade;
  }

  int getIdade () {
    return idade;
  }

  String getNomeIdade() {
    return ("NOME:" + getNome() + ", IDADE:" + getIdade());
  }

}
