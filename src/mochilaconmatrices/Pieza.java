package mochilaconmatrices;

public class Pieza {

    public int alto;
    public int ancho;
    public int beneficio;
    public double relacion;

    public Pieza(int alto, int ancho, int beneficio) {
        this.alto = alto;
        this.ancho = ancho;
        this.beneficio = beneficio;
        this.relacion = (double) beneficio / (double) (ancho * alto);
    }

}
