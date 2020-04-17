/**
 * @author Lucas Pereira Torres de Araújo, 384364
 * Universidade Federal do Ceará - TEcnicas de Programacao I, 2017.1
 */

public class Main {
  public static void main (String args[]) {

    System.out.println("--------------- Teste 1 ---------------");
    Pessoa p1 = new Pessoa();
    p1.setNome("Ana");
    p1.setIdade(20);
    Pessoa p2 = new Pessoa();
    p2.setNome("João");
    p2.setIdade(18);
    System.out.println ("Nome1:" + p1.getNome());
    System.out.println ("Idade1:" + p1.getIdade());
    System.out.println (p2.getNome());
    System.out.println (p2.getIdade());
    Pessoa p3 = new Pessoa("Lucas", 19);
    System.out.println ("Nome3:" + p3.getNome());
    System.out.println ("Idade3:" + p1.getIdade());


    System.out.println("\n--------------- Teste 2 ---------------");
    Pessoa p4 = new Pessoa();
    p4.setNome("Ana");
    Pessoa p5 = new Pessoa();
    p5.setNome("João");
    System.out.println (p4.getNome());
    System.out.println (p5.getNome());
    p4 = p5;
    System.out.println (p4.getNome());
    System.out.println (p5.getNome());

    System.out.println("\n--------------- Teste 3 ---------------");
    Pessoa p6 = new Pessoa();
    p6.setNome("Ana");
    p6.setIdade(20);
    Pessoa p7 = new Pessoa();
    p7.setNome("João");
    p7.setIdade(18);
    System.out.println (p6.getNomeIdade());
    System.out.println (p7.getNomeIdade());

  }
}
