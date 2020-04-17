/**
 * @author Lucas Pereira Torres de Araújo, 384364
 * Universidade Federal do Ceará - Tecnicas de Programacao I, 2017.1
 */

public class Quadrado extends Ponto implements Figura, Colorida {
    private final float lado; //O lado do quadrado nao pode ser alterado
    private Ponto cimaEsquerdo;
    private Ponto cimaDireito;
    private Ponto baixoEsquerdo;
    private Ponto baixoDireito;
    public String cor;

    Quadrado (float lado, Ponto p) {
        super(p.px, p.py); //Instancio o ponto base do quadrado, chamando o metodo construtor de Ponto
        this.lado = lado;
        this.baixoEsquerdo = p; //Ponto base do quadrado
        this.baixoDireito = new Ponto(p.px+lado, p.py);
        this.cimaEsquerdo = new Ponto(p.px, p.py+lado);
        this.cimaDireito = new Ponto(p.px+lado, p.py+lado);
    }

    Quadrado (float lado, Ponto p, String cor) {
        super(p.px, p.py); //Instancio o ponto base do quadrado, chamando o metodo construtor de Ponto
        this.lado = lado;
        this.baixoEsquerdo = p; //Ponto base do quadrado
        this.baixoDireito = new Ponto(p.px+lado, p.py);
        this.cimaEsquerdo = new Ponto(p.px, p.py+lado);
        this.cimaDireito = new Ponto(p.px+lado, p.py+lado);
        this.cor = cor;
    }

    @Override //Sobrescrever o metodo da interface
    public void mover(float dx, float dy) {
        this.baixoEsquerdo.moverPonto(dx, dy);
        this.baixoDireito.moverPonto(dx, dy);
        this.cimaEsquerdo.moverPonto(dx, dy);
        this.cimaDireito.moverPonto(dx, dy);
    }

    @Override //Sobrescrever o metodo da interface
    public double calcularArea() {
        float base = this.baixoDireito.px - this.baixoEsquerdo.px;
        float altura = this.cimaEsquerdo.py - this.baixoEsquerdo.py;

        return base*altura;
    }

    @Override //Sobrescrever o metodo da interface
    public String desenhar() {
        return (this.toString() + " de lado " + this.lado + " e vertices: cimaEsquerdo" + this.cimaEsquerdo.imprimirPonto() + ", cimaDireito" + this.cimaDireito.imprimirPonto() + ", baixoEsquerdo" + this.baixoEsquerdo.imprimirPonto() + ", baixoDireito" + this.baixoDireito.imprimirPonto() + ".");
    }

    @Override
    public String desenhar(String cor) {
        this.cor = cor;
        return (this.toString() + " de cor " + this.cor + " e de lado " + this.lado + " e vertices: cimaEsquerdo" + this.cimaEsquerdo.imprimirPonto() + ", cimaDireito" + this.cimaDireito.imprimirPonto() + ", baixoEsquerdo" + this.baixoEsquerdo.imprimirPonto() + ", baixoDireito" + this.baixoDireito.imprimirPonto() + ".");
    }

    @Override
    public void setCor(String cor) {
        this.cor = cor;
    }

}
