/**
 * @author Lucas Pereira Torres de Araújo, 384364
 * Universidade Federal do Ceará - Tecnicas de Programacao I, 2017.1
 */

public class Circulo extends Ponto implements Figura, Colorida {
    private final float raio;
    private Ponto centro;
    public String cor;

    Circulo(Ponto centro, float raio) {
        super(centro.px, centro.py); //Instancio o centro base do circulo, chamando o metodo construtor de Ponto
        this.centro = centro;
        this.raio = raio;
    }

    Circulo(Ponto centro, float raio, String cor) {
        super(centro.px, centro.py); //Instancio o centro base do circulo, chamando o metodo construtor de Ponto
        this.centro = centro;
        this.raio = raio;
        this.cor = cor;
    }

    @Override //Sobrescrever o metodo da interface
    public void mover(float dx, float dy) {
        this.centro.moverPonto(dx, dy);
    }

    @Override //Sobrescrever o metodo da interface
    public double calcularArea() {
        return (Math.PI * Math.pow(raio, 2)); // Valor de PI vezes o quadrado do raio
    }

    @Override //Sobrescrever o metodo da interface
    public String desenhar() {
        return (this.toString() + " de raio " + this.raio + " no centro de coordenadas " + this.centro.imprimirPonto() + ".");
    }

    @Override //Sobrescrever o metodo da interface
    public String desenhar(String cor) {
        this.cor = cor;
        return (this.toString() + " de cor " + this.cor + " e de raio " + this.raio + " no centro de coordenadas " + this.centro.imprimirPonto() + ".");
    }

    @Override
    public void setCor(String cor) {
        this.cor = cor;
    }

}
