package mochilaconmatrices;

import javax.swing.JOptionPane;

public class MochilaconMatrices {

    public static void main(String[] args) {

        int TamañoMatriz = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la matriz"));
        int NúmerodePiezas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de piezas"));
        Solucionador S = new Solucionador(NúmerodePiezas, TamañoMatriz);
        
        for (int i = 0; i < NúmerodePiezas; i++) {
            int alto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el alto de la figura " + (i+1)));
            int ancho = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ancho de la figura " + (i+1)));
            int beneficio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el beneficio de la figura " + (i+1)));
            S.llenarMatrizdePiezas(alto, ancho, beneficio, i);
        }
        
        S.imprimir(S.Piezas);
        S.Piezas = S.burbuja(S.Piezas);
        S.imprimir(S.Piezas);
        System.out.println("El máximo beneficio que se puede lograr es " + S.solucionar(S.Piezas));
    }

}
