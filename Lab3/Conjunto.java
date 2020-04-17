/**
 * @author Lucas Pereira Torres de Araújo, 384364
 * Universidade Federal do Ceará - Técnicas de Programação I, 2017.1
 */

public class Conjunto {
    Object[] vetor;
    int tamanho;
    int ponteiro;
    int quantidade;

    Conjunto (int tamanho) {
      this.vetor = new Object[tamanho];
      this.tamanho = tamanho;
      this.quantidade = 0;
      this.ponteiro = -1;
    }

    boolean inserirValor(Object valor) {
      if (this.ponteiro < (this.tamanho-1)) {
        this.quantidade++;
        this.ponteiro++;
        this.vetor[this.ponteiro] = valor;
        return true;
      } else {
        System.out.println ("Conjunto cheio.");
        return false;
      }
    }

    boolean verificarValor(Object valor) {
      int verificador = 0;
      while (verificador <= this.ponteiro) {
        if (this.vetor[verificador] == valor) {
          verificador = -1;
          break;
        }
        verificador++;
      }

      if (verificador == -1) {
        //System.out.println ("O valor pertence ao conjunto.");
        return true;
      } else {
        //System.out.println ("O valor nao pertence ao conjunto.");
        return false;
      }
    }

    int verificarSubconjunto(Conjunto c) {

      if (c.quantidade > this.quantidade) {
        //System.out.println ("O subconjunto e maior que o conjunto comparado.");
        return -1;
      } else {

        int check = c.ponteiro;
        int flag = c.quantidade;
        int contador = 0;
        while (flag > 0) {
          if (this.verificarValor(c.vetor[check])) {
            contador++;
          }
          flag--;
          check--;
        }

        if (contador == c.quantidade) {
          //System.out.println ("E subconjunto.");
          return 1;
        } else {
          //System.out.println ("Nao e subconjunto.");
          return 0;
        }
      }
    }

    Conjunto uniaoConjunto(Conjunto c) {
      if (this.verificarSubconjunto(c) == 0) {

          Conjunto uniao_teste = new Conjunto(this.quantidade + c.quantidade);

          int t1 = this.ponteiro;
          int t2 = c.ponteiro;

          for (int x = this.quantidade; x > 0; x--) {
            if (!uniao_teste.verificarValor(this.vetor[t1])) {
              uniao_teste.inserirValor(this.vetor[t1]);
              t1--;
            }
          }

          for (int x = c.quantidade; x > 0; x--) {
            if(!uniao_teste.verificarValor(c.vetor[t2])) {
              uniao_teste.inserirValor(c.vetor[t2]);
            }
            t2--;
          }

          Conjunto uniao = new Conjunto(uniao_teste.quantidade);

          t1 = this.ponteiro;
          t2 = c.ponteiro;

          for (int x = this.quantidade; x > 0; x--) {
            if (!uniao.verificarValor(this.vetor[t1])) {
              uniao.inserirValor(this.vetor[t1]);
              t1--;
            }
          }

          for (int x = c.quantidade; x > 0; x--) {
            if(!uniao.verificarValor(c.vetor[t2])) {
              uniao.inserirValor(c.vetor[t2]);
            }
            t2--;
          }
          return uniao;
      } else {
        return this;
      }
    }

    Conjunto interConjunto(Conjunto c) {

      Conjunto inter_teste = new Conjunto(this.quantidade + c.quantidade);

      int contador;

      for (int i = 0; i < this.quantidade; i++) {
        for (int j = 0; j < c.quantidade; j++) {
          if (this.vetor[i].equals(c.vetor[j]) && !inter_teste.verificarValor(this.vetor[i])) {
            inter_teste.inserirValor(this.vetor[i]);
          }
        }
      }

      if (inter_teste.quantidade == 0) {
          contador = 1;
      } else {
          contador = inter_teste.quantidade;
      }

      Conjunto intersec = new Conjunto(contador);

      for (int i = 0; i < inter_teste.quantidade; i++) {
          intersec.inserirValor(inter_teste.vetor[i]);
      }

      return intersec;

    }

    Conjunto diferencaConjunto(Conjunto c) {

      Conjunto auxiliar = this.interConjunto(c);

      if (this.verificarSubconjunto(auxiliar) == 0) {

          Conjunto diferenca = new Conjunto(1);
          return diferenca;

      }

      if (this.quantidade == auxiliar.quantidade) {

          Conjunto diferenca = new Conjunto(1);
          return diferenca;
      }

      Conjunto diferenca = new Conjunto(this.quantidade - auxiliar.quantidade);

      for (int i = 0; i < this.quantidade; i++) {
          if (!auxiliar.verificarValor(this.vetor[i])) {
              diferenca.inserirValor(this.vetor[i]);
          }
      }

      return diferenca;

    }

    Conjunto produtoCartesiano(Conjunto c) {

        if (this.quantidade > 0 && c.quantidade > 0) {

            Conjunto cartesiano = new Conjunto(this.quantidade * c.quantidade);

            for (int contA = 0; contA < this.quantidade; contA++) {
                for (int contB = 0; contB < c.quantidade; contB++) {
                    cartesiano.inserirValor("("+this.vetor[contA]+","+c.vetor[contB]+")");
                }
            }

            return cartesiano;

        } else {
            Conjunto cartesiano = new Conjunto(1);
            cartesiano.inserirValor("NULO");
            return cartesiano;
        }
    }

    Conjunto conjuntoPotencia() {

        double s = Math.pow(2, this.quantidade);
        Conjunto potencia = new Conjunto((int) s);

        Conjunto valoresBinarios = new Conjunto(potencia.tamanho);

        for (int i = 0; i < potencia.tamanho; i++) {
            String binario = Integer.toBinaryString(i);
            for (int j = binario.length(); j < this.quantidade; j++) {
                binario = "0"+binario;
            }

            valoresBinarios.inserirValor(binario);
            //System.out.println(binario);
        }
        //System.out.println(valoresBinarios.vetor[0].getClass().getName());
        //valoresBinarios.imprimirVetor();

        for (int i = 0; i < valoresBinarios.quantidade; i++) {
            String msg = "(";
            for (int j = 0; j < this.quantidade; j++) {
                String bin = (String) valoresBinarios.vetor[i];
                char teste = bin.charAt(j);
                if (teste == '1') {
                    msg += this.vetor[j] + ",";
                }
            }
            msg += ")";
            potencia.inserirValor(msg);
        }

        return potencia;
    }

    //Checa se um conjunto é igual ao outro
    boolean igualdadeConjunto(Conjunto c) {
        if (this.quantidade == c.quantidade) {
            int contador = 0;

            for (int i = 0; i < this.quantidade; i++) {
                if (this.verificarValor(c.vetor[i])) {
                    contador++;
                }
            }

            if (contador == this.quantidade) {
                System.out.println ("Os conjuntos sao iguais.");
                return true;
            } else {
                System.out.println ("Os conjuntos sao diferentes. (2)");
                return false;
            }

        } else {
            System.out.println ("Os conjuntos sao diferentes. (1)");
            return false;
        }
    }

    //Retorna o tamanho do conjunto
    int getLength() {
      return this.tamanho;
    }

    //Imprime o Conjunto
    void imprimirVetor() {
      String msg = "[";
      for (int x = 0; x <= getLength()-1; x++) {
        if (x == getLength()-1)
          msg += this.vetor[x] + "]";
        else
          msg += this.vetor[x] + ",";
      }

      System.out.println(msg);
    }

}
