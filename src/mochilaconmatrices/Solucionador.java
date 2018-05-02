package mochilaconmatrices;

public class Solucionador {

    public Pieza[] Piezas;
    public int TamañoMatriz;
    public int NumPiezas;
    public int TamañoTotal;

    public Solucionador(int NumPiezas, int tamañoMatriz) {
        this.TamañoMatriz = tamañoMatriz;
        this.TamañoTotal = tamañoMatriz * tamañoMatriz;
        this.NumPiezas = NumPiezas;
        Piezas = new Pieza[NumPiezas];
    }

    public void llenarMatrizdePiezas(int alto, int ancho, int beneficio, int indice) {
        Piezas[indice] = new Pieza(alto, ancho, beneficio);
    }

    public double solucionar(Pieza A[]) {
        double BeneficioTotal = 0;
        int Peso = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            //Discrimina las figuras cuyo alto o ancho es mayor al tamaño de la matriz
            if (A[i].alto <= TamañoMatriz && A[i].ancho <= TamañoMatriz) {
                if ((Peso + (A[i].alto * A[i].ancho)) <= TamañoTotal) {
                    Peso = Peso + (A[i].alto * A[i].ancho);
                    BeneficioTotal = BeneficioTotal + (double) A[i].beneficio;
                    System.out.println("Se usó la pieza con beneficio " + A[i].beneficio + ", cuyo peso es " + (A[i].alto * A[i].ancho));
                } else {
                    int excedente = TamañoTotal - Peso;
                    if (excedente == 0) {
                        break;
                    } else {
                        System.out.println("Se usó " + excedente + "/" + (A[i].alto * A[i].ancho) + " de beneficio " + A[i].beneficio);
                        BeneficioTotal = BeneficioTotal + (((double) excedente / (double) (A[i].alto * A[i].ancho)) * (double) A[i].beneficio);
                        break;
                    }
                }
            }
        }
        return BeneficioTotal;
    }

    public Pieza[] burbuja(Pieza A[]) {
        Pieza aux;
        int i, j;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1].relacion < A[j].relacion) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }
        return A;
    }

    public void imprimir(Pieza[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print("\n");
            System.out.print(A[i].alto + " | " + A[i].ancho + " | " + A[i].beneficio + " | " + A[i].relacion);
        }
        System.out.println("");
    }

}
