/**
 * @author Lucas Pereira Torres de Araújo, 384364
 * Universidade Federal do Ceará - Tecnicas de Programacao I, 2017.1
 */

public class Lab3_TesteMain {

    public static void main(String[] args) {

        //Quadrado (float lado, Ponto p)
        Ponto p1 = new Ponto(0, 0);
        Quadrado q1 = new Quadrado(12, p1);

        //Circulo(Ponto centro, float raio)
        Ponto p2 = new Ponto(5, 5);
        Circulo c1 = new Circulo(p2, 10);

        //String desenhar()
        System.out.println(q1.desenhar());
        System.out.println(c1.desenhar());

        //double calcularArea()
        System.out.println(""); //Quebra de linha
        System.out.println("Area do " + q1.toString() + ": " + q1.calcularArea());
        System.out.println("Area do " + c1.toString() + ": " + c1.calcularArea());

        //void mover(float dx, float dy)
        q1.mover(5,10);
        c1.mover(5,10);

        System.out.println(""); //Quebra de linha
        System.out.println(q1.desenhar("Laranja"));
        System.out.println(c1.desenhar()+ "\n");

        //Criando um vetor para armazenar 10 figuras concretas
        //Utilizo a classe Conjunto ao inves do ArrayList
        Conjunto lista = new Conjunto(10);
        lista.inserirValor(new Circulo(p2, 1, "PRETO"));
        lista.inserirValor(new Circulo(p1, 2));
        lista.inserirValor(new Circulo(p2, 3));
        lista.inserirValor(new Circulo(p1, 4, "AZUL"));
        lista.inserirValor(new Circulo(p2, 5));
        lista.inserirValor(new Quadrado(8, p1));
        lista.inserirValor(new Quadrado(10, p2));
        lista.inserirValor(new Quadrado(12, p1, "LARANJA"));
        lista.inserirValor(new Quadrado(14, p2));
        lista.inserirValor(new Quadrado(16, p1, "AMARELO"));

        //Imprimo o vetor completo
        System.out.println("Lista de Figuras:"); //Quebra de linha
        lista.imprimirVetor();
        System.out.println(""); //Quebra de linha

        //Percorro o vetor e imprimo apenas as areas das figuras coloridas
        //Utilizo o metodo getClass e getName para checar o tipo da classe do vetor
        for (int i = 0; i < lista.getLength(); i++) {
            String check = lista.vetor[i].getClass().getName();
            if ("Quadrado".equals(check)) {
                if (((Quadrado) lista.vetor[i]).cor != null) {
                    System.out.println("A area do " + ((Quadrado) lista.vetor[i]).toString() + " de cor " + ((Quadrado) lista.vetor[i]).cor + ": " + ((Quadrado) lista.vetor[i]).calcularArea());
                }

            } else if ("Circulo".equals(check)) {
                if (((Circulo) lista.vetor[i]).cor != null) {
                    System.out.println("A area do " + ((Circulo) lista.vetor[i]).toString() + " de cor " + ((Circulo) lista.vetor[i]).cor + ": " + ((Circulo) lista.vetor[i]).calcularArea());
                }

            }
        }

    }

}
