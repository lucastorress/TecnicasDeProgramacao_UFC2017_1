/**
 * @author Lucas Pereira Torres de Araújo, 384364
 * Universidade Federal do Ceará - TEcnicas de Programacao I, 2017.1
 */

public class Lab2 {

    public static void main(String[] args) {

      //Dez primeiros numeros naturais
      Conjunto n1 = new Conjunto(10);
      n1.inserirValor(0);
      n1.inserirValor(1);
      n1.inserirValor(2);
      n1.inserirValor(3);
      n1.inserirValor(4);
      n1.inserirValor(5);
      n1.inserirValor(6);
      n1.inserirValor(7);
      n1.inserirValor(8);
      n1.inserirValor(9);

      //Cinco primeiros numeros pares
      Conjunto n2 = new Conjunto(5);
      n2.inserirValor(2);
      n2.inserirValor(4);
      n2.inserirValor(6);
      n2.inserirValor(8);
      n2.inserirValor(10);

      //Cinco primeiros numeros impares
      Conjunto n3 = new Conjunto(5);
      n3.inserirValor(1);
      n3.inserirValor(3);
      n3.inserirValor(5);
      n3.inserirValor(7);
      n3.inserirValor(9);

      //Dez primeiros numeros primos
      Conjunto n4 = new Conjunto(10);
      n4.inserirValor(2);
      n4.inserirValor(3);
      n4.inserirValor(5);
      n4.inserirValor(7);
      n4.inserirValor(11);
      n4.inserirValor(13);
      n4.inserirValor(17);
      n4.inserirValor(19);
      n4.inserirValor(23);
      n4.inserirValor(29);

      Conjunto p1 = new Conjunto(3);
      p1.inserirValor(1);
      p1.inserirValor(2);
      p1.inserirValor(3);
      Conjunto p2 = new Conjunto(3);
      p2.inserirValor(4);
      p2.inserirValor(5);
      p2.inserirValor(6);

      //Imprimo os conjuntos
      System.out.println("Conjunto 1:"); n1.imprimirVetor();
      System.out.println("Conjunto 2:"); n2.imprimirVetor();
      System.out.println("Conjunto 3:"); n3.imprimirVetor();
      System.out.println("Conjunto 4:"); n4.imprimirVetor();

      System.out.println("\n--------------- ITEM A ---------------");
        //Se o conjunto 4 E subconjunto de si mesmo
        switch (n4.verificarSubconjunto(n4)) {
            case 1:
                System.out.println ("E subconjunto de si mesmo.");
                break;
            case 0:
                System.out.println ("Nao e subconjunto de si mesmo.");
                break;
            default:
                System.out.println ("O subconjunto e maior que o conjunto comparado.");
                break;
        }

      System.out.println("\n--------------- ITEM B ---------------");
      //A pertinencia dos conjuntos 2, 3 e 4 no conjunto 1
      System.out.println("-------------- ITEM B.1 --------------");
      System.out.println ("A pertinencia do conjunto 2 no conjunto 1:");
        switch (n1.verificarSubconjunto(n2)) {
            case 1:
                System.out.println ("E subconjunto.");
                break;
            case 0:
                System.out.println ("Nao e subconjunto.");
                break;
            default:
                System.out.println ("O subconjunto e maior que o conjunto comparado.");
                break;
        }

      System.out.println("-------------- ITEM B.2 --------------");
      System.out.println ("A pertinencia do conjunto 3 no conjunto 1:");
        switch (n1.verificarSubconjunto(n3)) {
            case 1:
                System.out.println ("E subconjunto.");
                break;
            case 0:
                System.out.println ("Nao e subconjunto.");
                break;
            default:
                System.out.println ("O subconjunto e maior que o conjunto comparado.");
                break;
        }

      System.out.println("-------------- ITEM B.3 --------------");
      System.out.println ("A pertinencia do conjunto 4 no conjunto 1:");
        switch (n1.verificarSubconjunto(n4)) {
            case 1:
                System.out.println ("E subconjunto.");
                break;
            case 0:
                System.out.println ("Nao e subconjunto.");
                break;
            default:
                System.out.println ("O subconjunto e maior que o conjunto comparado.");
                break;
        }

      System.out.println("\n--------------- ITEM C ---------------");
      //Se a uniao de 2 e 3 E igual ao conjunto 1;
      Conjunto union = n2.uniaoConjunto(n3);
      System.out.println("Uniao - Conjunto 2 e 3:"); union.imprimirVetor();

      System.out.println("\n--------------- ITEM D ---------------");
      //Se a interseccao dos conjuntos 1 e 2 E vazia
      Conjunto inter = n1.interConjunto(n2);
      if (inter.quantidade > 0) {
          System.out.println("A interseccao nao e vazia.");
      } else {
          System.out.println("A interseccao e vazia.");
      }
      System.out.println("Interseccao - Conjunto 1 e 2:"); inter.imprimirVetor();

      System.out.println("\n--------------- ITEM E ---------------");
      //Qual a diferenca entre os conjuntos 1 e 2
      Conjunto difer = n1.diferencaConjunto(n2);
      System.out.println("Diferenca - Conjunto 1 e 2:"); difer.imprimirVetor();

      System.out.println("--------------- FIM ---------------\n");

      System.out.println("Conjunto A:"); p1.imprimirVetor();
      System.out.println("Conjunto B:"); p2.imprimirVetor();
      Conjunto cartesiano = p1.produtoCartesiano(p2);
      System.out.println("Conjunto Cartesiano de A e B:"); cartesiano.imprimirVetor();
      Conjunto potencia_a = p1.conjuntoPotencia();
      System.out.println("Conjunto Potencia de A:"); potencia_a.imprimirVetor();
      Conjunto potencia_b = p2.conjuntoPotencia();
      System.out.println("Conjunto Potencia de B:"); potencia_b.imprimirVetor();

      //Conjunto Universo
      Conjunto universo = new Conjunto(50);
      for (int numero = 0; numero <= 49; numero++) {
          universo.inserirValor(numero);
      }
      System.out.println("\nConjunto Universo:"); universo.imprimirVetor();

      //Conjuntos Base
      Conjunto DeMorganUniao = n2.uniaoConjunto(n3);
      Conjunto DeMorganInter = n2.interConjunto(n3);

      Conjunto ComplementoDeMorganUniao = universo.diferencaConjunto(DeMorganUniao);
      Conjunto ComplementoDeMorganInter = universo.diferencaConjunto(DeMorganInter);

      Conjunto ComplementoA = universo.diferencaConjunto(n2);
      Conjunto ComplementoB = universo.diferencaConjunto(n3);

      Conjunto ComplementoInter = ComplementoA.interConjunto(ComplementoB);
      Conjunto ComplementoUniao = ComplementoA.uniaoConjunto(ComplementoB);

      System.out.println("\nDeMorgan Uniao:"); ComplementoDeMorganUniao.igualdadeConjunto(ComplementoInter);
      System.out.println("DeMorgan Interseccao:"); ComplementoDeMorganInter.igualdadeConjunto(ComplementoUniao);

    }

}
