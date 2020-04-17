/**
 * @author Lucas Pereira Torres de Araújo, 384364
 * Universidade Federal do Ceará - Tecnicas de Programacao I, 2017.1
 */

public class Ponto {
    float px;
    float py;

    Ponto(float x, float y) {
        this.px = x;
        this.py = y;
    }

    void moverPonto(float dx, float dy) {
        this.px += dx;
        this.py += dy;
    }

    String imprimirPonto() {
        return "("+this.px+", "+this.py+")";
    }

}
